import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

fun main() {
    val key = "mySecretKey".toByteArray()
    val spec = SecretKeySpec(key, "AES")
    val cipher = Cipher.getInstance("AES")
    cipher.init(Cipher.ENCRYPT_MODE, spec)
    val encrypted = cipher.doFinal("mySensitiveData".toByteArray())
    cipher.init(Cipher.DECRYPT_MODE, spec)
    val decrypted = cipher.doFinal(encrypted)
    println("Decrypted Data: " + String(decrypted))
}