import java.security.Key
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

fun main() {
    val key = "mySecretKey".toByteArray()
    val spec = SecretKeySpec(key, "AES")
    val cipher = Cipher.getInstance("AES")
    cipher.init(Cipher.ENCRYPT_MODE, spec)
    val encrypted = cipher.doFinal("mySensitiveData".toByteArray())
    val encoded = Base64.encodeToString(encrypted, Base64.DEFAULT)
    println("Encoded Data: " + encoded)
    val decoded = Base64.decode(encoded, Base64.DEFAULT)
    cipher.init(Cipher.DECRYPT_MODE, spec)
    val decrypted = cipher.doFinal(decoded)
    println("Decrypted Data: " + String(decrypted))
}
