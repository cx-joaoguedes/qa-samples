import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter password: ")
    val userPassword = readPassword(scanner)
    println("Password: $userPassword")
}

fun readPassword(scanner: Scanner): String {
    val passwordChars = scanner.nextLine().toCharArray()
    return String(passwordChars)
}