import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import java.util.Base64

// TP

fun main(args: Array<String>) {
    val keyString = "ThisIsMySecretKey"
    val key = SecretKeySpec(keyString.toByteArray(), "AES")
	
    val message = "Hello, world!"

    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.ENCRYPT_MODE, key)
    val encryptedMessage = cipher.doFinal(message.toByteArray())

    println("Encrypted message: " + Base64.getEncoder().encodeToString(encryptedMessage))
}

// DMS sample: TP

fun encrypt1() {
	
	val hardcodedSymmetricKey = "supersecretsymmetrickey!!!"
	val hardcodedSecretKey = hardcodedSymmetricKey.toByteArray()
	val secretKey = SecretKeySpec(hardcodedSecretKey, 0, hardcodedSecretKey.size, "AES")
	val cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM)
	val encrypted = cipher.encrypt(ToEncrypt, secretKey, true)
}

// DMS sample: TN

fun encrypt2() {
	
	val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
	val builder = KeyGenParameterSpec.Builder("AppCipherKey", KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
			.setBlockModes(KeyProperties.BLOCK_MODE_CBC)
			.setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
			
	keyGenerator.init(builder.build())
	val secretKey = keyGenerator.generateKey()
	val symmetricKey = SecretKeySpec(secretKey, 0, secretKey.size, "AES")
	val cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM)
	val encrypted = cipher.encrypt(DataToEncrypt, symmetricKey, true)
}
