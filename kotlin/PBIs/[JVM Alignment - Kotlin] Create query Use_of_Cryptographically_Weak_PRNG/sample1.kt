import java.util.Random

fun weakCryptoRandom() : ByteArray{
    val random = Random() // weak random
    
    val randomArray = ByteArray(16)
    random.nextBytes(randomArray) // input
    
    val md = MessageDigest.getInstance(CryptoConstants.HASH_ALG)
    md.update(randomArray) // result - using the weak random in a cryptographic operation
}