package running

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldNotBe
import io.swagger.parser.OpenAPIParser
import io.swagger.v3.parser.OpenAPIV3Parser

class SwaggerParserTest : FunSpec({
    test("SwaggerParser") {
        val swagger = OpenAPIV3Parser().read("https://petstore3.swagger.io/api/v3/openapi.json")

        println(swagger.components.schemas)
    }
})