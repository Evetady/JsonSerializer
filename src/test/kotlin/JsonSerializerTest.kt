import models.Person
import models.TestData
import kotlin.test.Test
import kotlin.test.assertEquals

class JsonSerializerTest {
    @Test
    fun `test serialize and deserialize Person`() {
        val person = Person("Alice", 30, "alice@example.com", listOf("Reading", "Hiking"))

        val jsonString = JsonSerializer.serializePerson(person)
        val deserializedPerson = JsonSerializer.deserializePerson(jsonString)

        assertEquals(person, deserializedPerson)
    }

    @Test
    fun `test serialize and deserialize TestData`() {
        val testData = TestData(1, "test value", listOf("tag1", "tag2"))

        val jsonString = JsonSerializer.serializeTestData(testData)
        val deserializedData = JsonSerializer.deserializeTestData(jsonString)

        assertEquals(testData, deserializedData)
    }

    @Test
    fun `test deserialize with missing optional field`() {
        val jsonString = """{"name":"Bob","age":25}"""
        val expectedPerson = Person("Bob", 25)

        val deserializedPerson = JsonSerializer.deserializePerson(jsonString)

        assertEquals(expectedPerson, deserializedPerson)
    }

    @Test
    fun `test serialize with null field`() {
        val person = Person("Charlie", 40, null)

        val jsonString = JsonSerializer.serializePerson(person)
        val deserializedPerson = JsonSerializer.deserializePerson(jsonString)

        assertEquals(person, deserializedPerson)
    }
}