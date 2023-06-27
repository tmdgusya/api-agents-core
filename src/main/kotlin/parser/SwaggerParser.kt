package parser

import io.swagger.v3.oas.models.Operation
import io.swagger.v3.oas.models.Paths
import io.swagger.v3.oas.models.media.Schema
import model.ApiInfo
import model.KotlinType
import model.OperationInfo

class SwaggerParser {
    fun <T> parseTypeInfo(schema: Schema<T>): List<KotlinType> = schema
        .let { _schema ->  _schema.required to _schema.properties }
        .let { (required, properties) ->
            properties.map { property ->
                KotlinType(
                    name = property.key,
                    type = when (property.value.type) {
                        "integer" -> {
                            if (property.value.format == "int64") Long::class else Int::class
                        }
                        "string" -> String::class
                        else -> throw IllegalArgumentException("not supported type")
                    },
                    required = required.takeIf { it?.isNotEmpty() == true }?.let { property.key in required } ?: false
                )
            }
        }

    fun parseApiInfos(path: Paths) = path.values.map { pathInfo ->
        ApiInfo(
            get = OperationInfo(
                mutableMapOf<String, List<KotlinType>>().also { operationMap ->
                    pathInfo.get?.getOperationInfo(operationMap)
                }
            ),
            post = OperationInfo(
                mutableMapOf<String, List<KotlinType>>().also { operationMap ->
                    pathInfo.post?.getOperationInfo(operationMap)
                }
            ),
            put = OperationInfo(
                mutableMapOf<String, List<KotlinType>>().also { operationMap ->
                    pathInfo.put?.getOperationInfo(operationMap)
                }
            ),
            delete = OperationInfo(
                mutableMapOf<String, List<KotlinType>>().also { operationMap ->
                    pathInfo.delete?.getOperationInfo(operationMap)
                }
            ),
        )
    }

    private fun Operation.getOperationInfo(
        map: MutableMap<String, List<KotlinType>>,
    ) {
       this.responses.forEach { (statusCode, responseBody) ->
            map[statusCode] = responseBody.content.values.flatMap { content ->
                content.schema.properties.map { (key, property) ->
                    property.addProperty(key, property)
                    this@SwaggerParser.parseTypeInfo(property)
                }.flatten()
            }
        }
    }
}