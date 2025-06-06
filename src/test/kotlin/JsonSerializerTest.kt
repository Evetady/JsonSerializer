import kotlinx.serialization.Serializable
import kotlin.test.Test
import kotlin.test.assertEquals

@Serializable
data class TestData(
    val id: Int,
    val value: String,
    val tags: List<String> = emptyList()
)

class JsonSerializerTest {
    @Test
    fun `test serialize and deserialize Person`() {
        val person = Person("Alice", 30, "alice@example.com", listOf("Reading", "Hiking"))

        val jsonString = JsonSerializer.serialize(person)
        val deserializedPerson = JsonSerializer.deserialize<Person>(jsonString)

        assertEquals(person, deserializedPerson)
    }

    @Test
    fun `test serialize and deserialize with custom class`() {
        val testData = TestData(1, "test value", listOf("tag1", "tag2"))

        val jsonString = JsonSerializer.serialize(testData)
        val deserializedData = JsonSerializer.deserialize<TestData>(jsonString)

        assertEquals(testData, deserializedData)
    }

    @Test
    fun `test deserialize with missing optional field`() {
        val jsonString = """{"name":"Bob","age":25}"""
        val expectedPerson = Person("Bob", 25)

        val deserializedPerson = JsonSerializer.deserialize<Person>(jsonString)

        assertEquals(expectedPerson, deserializedPerson)
    }

    @Test
    fun `test serialize with null field`() {
        val person = Person("Charlie", 40, null)

        val jsonString = JsonSerializer.serialize(person)
        val deserializedPerson = JsonSerializer.deserialize<Person>(jsonString)

        assertEquals(person, deserializedPerson)
    }
}