import java.io.File

fun main() {
    var configFile = File("src/main/kotlin/com/example/config.txt")
    if (!configFile.exists()) {
        println("File not found: config.txt")
        return
    }

    var passwordRegex = Regex("password=(.*)")

    configFile.forEachLine { line ->
        var matchResult = passwordRegex.find(line)
        if (matchResult != null) {
            var userPassword = matchResult.groupValues[1]
            throw CustomException(userPassword)
        }
    }
}

class CustomException(message: String) : Exception(message) {
    init {
        println("Custom exception: $message")
    }
}