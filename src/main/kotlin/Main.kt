fun main() {
    val person = Person("John Doe", 35, "john.doe@example.com", listOf("Cycling", "Photography"))

    // Сериализация
    val jsonString = JsonSerializer.serialize(person)
    println("Serialized JSON:")
    println(jsonString)

    // Десериализация
    val deserializedPerson = JsonSerializer.deserialize<Person>(jsonString)
    println("\nDeserialized object:")
    println(deserializedPerson)

    // Проверка равенства
    println("\nOriginal and deserialized objects are equal: ${person == deserializedPerson}")
}