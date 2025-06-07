package models

import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val name: String,
    val age: Int,
    val email: String? = null,
    val hobbies: List<String> = emptyList()
)