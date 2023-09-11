data class User(val name: String, val age: Int)

fun main() {
    val user = User("Alice", 25)
    println("User: $user")
}