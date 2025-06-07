import models.Person
import models.TestData

fun main() {
    // Пример с классом Person
    val person = Person("John Doe", 35, "john.doe@example.com", listOf("Cycling", "Photography"))

    println("Serialized Person:")
    val personJson = JsonSerializer.serializePerson(person)
    println(personJson)

    val deserializedPerson = JsonSerializer.deserializePerson(personJson)
    println("\nDeserialized Person:")
    println(deserializedPerson)

    // Пример с классом TestData
    val testData = TestData(42, "Test value", listOf("important", "kotlin"))

    println("\nSerialized TestData:")
    val testDataJson = JsonSerializer.serializeTestData(testData)
    println(testDataJson)

    val deserializedTestData = JsonSerializer.deserializeTestData(testDataJson)
    println("\nDeserialized TestData:")
    println(deserializedTestData)
}