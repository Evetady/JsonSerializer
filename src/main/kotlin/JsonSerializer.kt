import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString

@Serializable
data class Person(
    val name: String,
    val age: Int,
    val email: String? = null,
    val hobbies: List<String> = emptyList()
)

object JsonSerializer {
    private val json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
        isLenient = true
    }

    fun <T> serialize(obj: T): String where T : Any {
        return json.encodeToString(obj)
    }

    inline fun <reified T> deserialize(jsonString: String): T {
        return json.decodeFromString(jsonString)
    }
}