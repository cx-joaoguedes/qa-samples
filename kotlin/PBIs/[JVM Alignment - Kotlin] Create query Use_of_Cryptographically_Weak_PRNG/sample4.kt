import java.security.KeyPairGenerator
import java.security.SecureRandom

fun main() {
    val keyGen = KeyPairGenerator.getInstance("RSA")
    val random = Random()
    keyGen.initialize(2048, random)
    val keyPair = keyGen.generateKeyPair()
    val privateKey = keyPair.private
}