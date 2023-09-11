import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

fun main() {
    val key = "mySecretKey".toByteArray()
    val spec = SecretKeySpec(key, "DES")
    val cipher = Cipher.getInstance("DES")
    cipher.init(Cipher.ENCRYPT_MODE, spec)
    val encrypted = cipher.doFinal("mySensitiveData".toByteArray())
    println("Encrypted Data: " + String(encrypted))
}
