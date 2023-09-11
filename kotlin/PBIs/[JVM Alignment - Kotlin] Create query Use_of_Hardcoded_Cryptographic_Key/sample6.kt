import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

fun encryptData(data: String): String {
    val key = "my_secret_key".toByteArray(Charsets.UTF_8)
    val skey = SecretKeySpec(key, "AES")
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.ENCRYPT_MODE, skey)
    val encrypted = cipher.doFinal(data.toByteArray())
    return String(encrypted, Charsets.UTF_8)
}

fun main() {
    val data = "sensitive data"
    val encryptedData = encryptData(data)
    println(encryptedData)
}
