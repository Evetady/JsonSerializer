import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import models.Person
import models.TestData

object JsonSerializer {
    private val json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
        isLenient = true
    }

    fun <T> serialize(obj: T, serializer: SerializationStrategy<T>): String {
        return json.encodeToString(serializer, obj)
    }

    fun <T> deserialize(jsonString: String, deserializer: DeserializationStrategy<T>): T {
        return json.decodeFromString(deserializer, jsonString)
    }

    fun serializePerson(person: Person): String {
        return json.encodeToString(person)
    }

    fun deserializePerson(jsonString: String): Person {
        return json.decodeFromString(jsonString)
    }

    fun serializeTestData(testData: TestData): String {
        return json.encodeToString(testData)
    }

    fun deserializeTestData(jsonString: String): TestData {
        return json.decodeFromString(jsonString)
    }
}