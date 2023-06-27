package model

data class ApiInfo(
    val get: OperationInfo,
    val post: OperationInfo,
    val put: OperationInfo,
    val delete: OperationInfo,
)