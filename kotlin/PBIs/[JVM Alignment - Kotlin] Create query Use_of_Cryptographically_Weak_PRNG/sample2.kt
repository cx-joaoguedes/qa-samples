import java.util.SecureRandom

fun weakCryptoRandom() : ByteArray{
    //// example of a strong random:
    val random = SecureRandom()
    
    val randomArray = ByteArray(16)
    random.nextBytes(randomArray) // input
    
    val md = MessageDigest.getInstance(CryptoConstants.HASH_ALG)
    md.update(randomArray) // result - using the strong random in a cryptographic operation
}