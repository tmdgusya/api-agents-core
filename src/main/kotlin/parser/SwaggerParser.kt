package parser

import io.swagger.v3.oas.models.media.Schema
import model.KotlinType

class SwaggerParser {

    fun <T> parseTypeInfo(schema: Schema<T>): List<KotlinType> = schema
        .let { _schema ->  _schema.required to _schema.properties }
        .let { (required, properties) ->
            properties.map { property ->
                KotlinType(
                    name = property.key,
                    type = when (property.value.type) {
                        "integer" -> { if (property.value.format == "int64") Long::class else Int::class }
                        "string" -> String::class
                        else -> throw IllegalArgumentException("not supported type")
                    },
                    required = required.takeIf { it?.isNotEmpty() == true }?.let { property.key in required } ?: false
                )
            }
        }
}