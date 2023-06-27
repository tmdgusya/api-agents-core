package parser

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.swagger.v3.oas.models.media.Schema

class ParseTypeFromSwaggerTest : FunSpec({

    test("return properties are kotlinType") {
        val sut = SwaggerParser()
        val schema = Schema<Any>().apply {
            addProperty("id", Schema<Any>().apply {
                type = "integer"
                format = "int64"
            })
            addProperty("name", Schema<Any>().apply {
                type = "string"
            })
        }

        val result = sut.parseTypeInfo(schema)

        result[0].name shouldBe "id"
        result[1].name shouldBe "name"
    }

    test("return properties types within KotlinType class") {
        val sut = SwaggerParser()
        val schema = Schema<Any>().apply {
            addProperty("id", Schema<Any>().apply {
                type = "integer"
            })
            addProperty("name", Schema<Any>().apply {
                type = "string"
            })
        }

        val result = sut.parseTypeInfo(schema)

        result[0].type shouldBe Int::class
        result[1].type shouldBe String::class
    }

    test("return Long Type within KotlinType class If there is 'int64' format with integer in schema") {
        val sut = SwaggerParser()
        val schema = Schema<Any>().apply {
            addProperty("id", Schema<Any>().apply {
                type = "integer"
                format = "int64"
            })
        }

        val result = sut.parseTypeInfo(schema)

        result[0].type shouldBe Long::class
    }

    test("some properties has required value is true If there is required properties in schema") {
        val sut = SwaggerParser()
        val schema = Schema<Any>().apply {
            addProperty("id", Schema<Any>().apply {
                type = "integer"
                format = "int64"
            })
            addProperty("name", Schema<Any>().apply {
                type = "string"
            })
            required = listOf("id")
        }

        val result = sut.parseTypeInfo(schema)

        result[0].required shouldBe true
        result[1].required shouldBe false
    }
})
