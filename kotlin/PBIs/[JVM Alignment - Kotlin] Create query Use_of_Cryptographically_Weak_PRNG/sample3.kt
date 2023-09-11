import java.security.SecureRandom
import javax.crypto.spec.IvParameterSpec

fun main(){
    val salt = ByteArray(16)
    val random = Random()
    random.nextBytes(salt)
    val ivSpec = IvParameterSpec(salt)
}