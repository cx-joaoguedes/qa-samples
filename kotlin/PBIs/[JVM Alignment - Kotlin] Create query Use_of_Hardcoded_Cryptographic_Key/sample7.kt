import java.security.Key
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

fun encryptData(data: String): String {
    val key = byteArrayOf(0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16)
    val skey = SecretKeySpec(key, "AES")
    val cipher = Cipher.getInstance("AES")
    cipher.init(Cipher.ENCRYPT_MODE, skey)
    val encrypted = cipher.doFinal(data.toByteArray())
    return String(encrypted)
}

fun main() {
    val data = "sensitive data"
    val encryptedData = encryptData(data)
    println(encryptedData)
}
