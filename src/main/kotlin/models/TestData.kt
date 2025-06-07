package models

import kotlinx.serialization.Serializable

@Serializable
data class TestData(
    val id: Int,
    val value: String,
    val tags: List<String> = emptyList()
)