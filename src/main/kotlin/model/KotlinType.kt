package model

import kotlin.reflect.KClass

data class KotlinType(
    val name: String,
    val type: KClass<*>,
    val required: Boolean = false,
)
