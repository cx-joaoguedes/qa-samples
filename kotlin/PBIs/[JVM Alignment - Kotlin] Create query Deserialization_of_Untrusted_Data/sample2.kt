import java.io.*

class VulnerableClass : Serializable {
    lateinit var username: String
    lateinit var password: String

    private fun readObject(inputStream: ObjectInputStream) {
        username = inputStream.readObject() as String
        password = inputStream.readObject() as String
    }

    private fun writeObject(outputStream: ObjectOutputStream) {
        outputStream.writeObject(username)
        outputStream.writeObject(password)
    }
}

fun main(args: Array<String>) {
    val bytes = args
    val byteArrayInputStream = ByteArrayInputStream(bytes)
    val objectInputStream = ObjectInputStream(byteArrayInputStream)
    val vulnerableObject = objectInputStream.readObject() as VulnerableClass
    println(vulnerableObject.username)
    println(vulnerableObject.password)
}