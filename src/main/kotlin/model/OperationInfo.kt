package model

data class OperationInfo(
    // this String type is StatusCode
    val responseBody: Map<String, List<KotlinType>>,
)
