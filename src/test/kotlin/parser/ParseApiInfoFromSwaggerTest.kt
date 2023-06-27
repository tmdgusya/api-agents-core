package parser

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.swagger.v3.oas.models.Operation
import io.swagger.v3.oas.models.PathItem
import io.swagger.v3.oas.models.Paths
import io.swagger.v3.oas.models.media.Content
import io.swagger.v3.oas.models.media.MediaType
import io.swagger.v3.oas.models.media.Schema
import io.swagger.v3.oas.models.responses.ApiResponses

class ParseApiInfoFromSwaggerTest : FunSpec({
    test("Get ApiPath and ResponseBody Information From Swagger") {
        val sut = SwaggerParser()
        val path: Paths = Paths().apply {
            addPathItem(
                "/api/v1/roachs",
                PathItem().apply {
                    get = Operation().apply {
                        responses = ApiResponses().also {
                            it.addApiResponse(
                                "200",
                                io.swagger.v3.oas.models.responses.ApiResponse().apply {
                                    content = Content().also {
                                        it.addMediaType("application/json", MediaType().apply {
                                            schema = Schema<Any>().apply {
                                                addProperty("id", Schema<Any>().apply {
                                                    type = "integer"
                                                    format = "int64"
                                                })
                                                addProperty("name", Schema<Any>().apply {
                                                    type = "string"
                                                })
                                            }
                                        })
                                    }
                                },
                            )
                            it.addApiResponse(
                                "400",
                                io.swagger.v3.oas.models.responses.ApiResponse().apply {
                                    content = Content().also {
                                        it.addMediaType("application/json", MediaType().apply {
                                            schema = Schema<Any>().apply {
                                                addProperty("id", Schema<Any>().apply {
                                                    type = "integer"
                                                    format = "int64"
                                                })
                                                addProperty("name", Schema<Any>().apply {
                                                    type = "string"
                                                })
                                            }
                                        })
                                    }
                                },
                            )
                        }
                    }
                }
            )
        }

        val result = sut.parseApiInfos(path)

        result[0].get.responseBody["200"]?.get(0)?.name shouldBe "id"
        result[0].get.responseBody["200"]?.get(0)?.type shouldBe Long::class
        result[0].get.responseBody["200"]?.get(1)?.name shouldBe "name"
        result[0].get.responseBody["200"]?.get(1)?.type shouldBe String::class

        result[0].get.responseBody["400"]?.get(0)?.name shouldBe "id"
        result[0].get.responseBody["400"]?.get(0)?.type shouldBe Long::class
        result[0].get.responseBody["400"]?.get(1)?.name shouldBe "name"
        result[0].get.responseBody["400"]?.get(1)?.type shouldBe String::class
    }

    test("Post ApiPath and ResponseBody Information From Swagger") {
        val sut = SwaggerParser()
        val path: Paths = Paths().apply {
            addPathItem(
                "/api/v1/roachs",
                PathItem().apply {
                    post = Operation().apply {
                        responses = ApiResponses().also {
                            it.addApiResponse(
                                "200",
                                io.swagger.v3.oas.models.responses.ApiResponse().apply {
                                    content = Content().also {
                                        it.addMediaType("application/json", MediaType().apply {
                                            schema = Schema<Any>().apply {
                                                addProperty("id", Schema<Any>().apply {
                                                    type = "integer"
                                                    format = "int64"
                                                })
                                                addProperty("name", Schema<Any>().apply {
                                                    type = "string"
                                                })
                                            }
                                        })
                                    }
                                },
                            )
                            it.addApiResponse(
                                "400",
                                io.swagger.v3.oas.models.responses.ApiResponse().apply {
                                    content = Content().also {
                                        it.addMediaType("application/json", MediaType().apply {
                                            schema = Schema<Any>().apply {
                                                addProperty("id", Schema<Any>().apply {
                                                    type = "integer"
                                                    format = "int64"
                                                })
                                                addProperty("name", Schema<Any>().apply {
                                                    type = "string"
                                                })
                                            }
                                        })
                                    }
                                },
                            )
                        }
                    }
                }
            )
        }

        val result = sut.parseApiInfos(path)

        result[0].post.responseBody["200"]?.get(0)?.name shouldBe "id"
        result[0].post.responseBody["200"]?.get(0)?.type shouldBe Long::class
        result[0].post.responseBody["200"]?.get(1)?.name shouldBe "name"
        result[0].post.responseBody["200"]?.get(1)?.type shouldBe String::class

        result[0].post.responseBody["400"]?.get(0)?.name shouldBe "id"
        result[0].post.responseBody["400"]?.get(0)?.type shouldBe Long::class
        result[0].post.responseBody["400"]?.get(1)?.name shouldBe "name"
        result[0].post.responseBody["400"]?.get(1)?.type shouldBe String::class
    }

    test("Put ApiPath and ResponseBody Information From Swagger") {
        val sut = SwaggerParser()
        val path: Paths = Paths().apply {
            addPathItem(
                "/api/v1/roachs",
                PathItem().apply {
                    put = Operation().apply {
                        responses = ApiResponses().also {
                            it.addApiResponse(
                                "200",
                                io.swagger.v3.oas.models.responses.ApiResponse().apply {
                                    content = Content().also {
                                        it.addMediaType("application/json", MediaType().apply {
                                            schema = Schema<Any>().apply {
                                                addProperty("id", Schema<Any>().apply {
                                                    type = "integer"
                                                    format = "int64"
                                                })
                                                addProperty("name", Schema<Any>().apply {
                                                    type = "string"
                                                })
                                            }
                                        })
                                    }
                                },
                            )
                            it.addApiResponse(
                                "400",
                                io.swagger.v3.oas.models.responses.ApiResponse().apply {
                                    content = Content().also {
                                        it.addMediaType("application/json", MediaType().apply {
                                            schema = Schema<Any>().apply {
                                                addProperty("id", Schema<Any>().apply {
                                                    type = "integer"
                                                    format = "int64"
                                                })
                                                addProperty("name", Schema<Any>().apply {
                                                    type = "string"
                                                })
                                            }
                                        })
                                    }
                                },
                            )
                        }
                    }
                }
            )
        }

        val result = sut.parseApiInfos(path)

        result[0].put.responseBody["200"]?.get(0)?.name shouldBe "id"
        result[0].put.responseBody["200"]?.get(0)?.type shouldBe Long::class
        result[0].put.responseBody["200"]?.get(1)?.name shouldBe "name"
        result[0].put.responseBody["200"]?.get(1)?.type shouldBe String::class

        result[0].put.responseBody["400"]?.get(0)?.name shouldBe "id"
        result[0].put.responseBody["400"]?.get(0)?.type shouldBe Long::class
        result[0].put.responseBody["400"]?.get(1)?.name shouldBe "name"
        result[0].put.responseBody["400"]?.get(1)?.type shouldBe String::class
    }

    test("Delte ApiPath and ResponseBody Information From Swagger") {
        val sut = SwaggerParser()
        val path: Paths = Paths().apply {
            addPathItem(
                "/api/v1/roachs",
                PathItem().apply {
                    delete = Operation().apply {
                        responses = ApiResponses().also {
                            it.addApiResponse(
                                "200",
                                io.swagger.v3.oas.models.responses.ApiResponse().apply {
                                    content = Content().also {
                                        it.addMediaType("application/json", MediaType().apply {
                                            schema = Schema<Any>().apply {
                                                addProperty("id", Schema<Any>().apply {
                                                    type = "integer"
                                                    format = "int64"
                                                })
                                                addProperty("name", Schema<Any>().apply {
                                                    type = "string"
                                                })
                                            }
                                        })
                                    }
                                },
                            )
                            it.addApiResponse(
                                "400",
                                io.swagger.v3.oas.models.responses.ApiResponse().apply {
                                    content = Content().also {
                                        it.addMediaType("application/json", MediaType().apply {
                                            schema = Schema<Any>().apply {
                                                addProperty("id", Schema<Any>().apply {
                                                    type = "integer"
                                                    format = "int64"
                                                })
                                                addProperty("name", Schema<Any>().apply {
                                                    type = "string"
                                                })
                                            }
                                        })
                                    }
                                },
                            )
                        }
                    }
                }
            )
        }

        val result = sut.parseApiInfos(path)

        result[0].delete.responseBody["200"]?.get(0)?.name shouldBe "id"
        result[0].delete.responseBody["200"]?.get(0)?.type shouldBe Long::class
        result[0].delete.responseBody["200"]?.get(1)?.name shouldBe "name"
        result[0].delete.responseBody["200"]?.get(1)?.type shouldBe String::class

        result[0].delete.responseBody["400"]?.get(0)?.name shouldBe "id"
        result[0].delete.responseBody["400"]?.get(0)?.type shouldBe Long::class
        result[0].delete.responseBody["400"]?.get(1)?.name shouldBe "name"
        result[0].delete.responseBody["400"]?.get(1)?.type shouldBe String::class
    }
})