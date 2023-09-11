import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import javax.crypto.spec.PBEKeySpec

class Vulnerable {
	val ENCRYPTION_KEY: Array[Byte] = "SUPER_secret_ENCRYTION_key".getBytes(StandardCharsets.UTF_8)
	def encrypt(plaintext: String, ivBytes: Array[Byte]): String = {
		try {
		  val iv = new IvParameterSpec(ivBytes)
		  val skeySpec = new SecretKeySpec(ENCRYPTION_KEY, "AES")
		  val cipher = Cipher.getInstance("CIPHER")
		  cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv)
		  val encrypted = cipher.doFinal(plaintext.getBytes)
		  return Base64.encodeBase64String(encrypted)
		} catch {
		  case ex: Exception =>
			ex.printStackTrace()
		}
		null
	}


	
	def encrypt2(plaintext: String, ivBytes: Array[Byte]): String = {
		try {
		  val ENCRYPTION_KEY2: Array[Byte] = "SUPER_secret_ENCRYTION_key".getBytes(StandardCharsets.UTF_8)
		  val iv = new IvParameterSpec(ivBytes)
		  val skeySpec = new SecretKeySpec(ENCRYPTION_KEY2, "AES")
		  val cipher = Cipher.getInstance("CIPHER")
		  cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv)
		  val encrypted = cipher.doFinal(plaintext.getBytes)
		  return Base64.encodeBase64String(encrypted)
		} catch {
		  case ex: Exception =>
			ex.printStackTrace()
		}
		null
	}

	def HardCodedCriptographicKey() = {
		val secretKey : String = "secretKey"
		val spec : PBEKeySpec = new PBEKeySpec(secretKey)
	}
}
  
  
  
  
  