import java.security.MessageDigest
import java.security.SecureRandom

object Crypto {
  def weakHashPassword(password: String): Array[Byte] = {
    val salt = "HardcodedPredictableSalt" //Salt should be unique
    val plainTextBytes = password.getBytes()
    val md = MessageDigest.getInstance("aaa")
    md.update(salt.getBytes())
    md.digest(plainTextBytes) //result
    md.digest(password.getBytes()) //result
  }

  def hashPasswordUnsafeRandom(password: String): Array[Byte] = {
    val random = new Random()
    val salt =  new Array[Byte](16)
    random.nextBytes(salt)
    val plainTextBytes = password.getBytes()
    val md = MessageDigest.getInstance("SHA")
    md.update(salt)
    md.digest(plainTextBytes)
  }

  def UnsafePredictableSalt(password: String) = {
		val data : Array[Char] = password.toCharArray
		var hash : Array[Byte] = null
		val ITERATION_COUNT : Int = 1025
		val KEY_LENGTH : Int = 256

		try {
			val rand : Random = new Random()
			val salt : Array[Byte] = new Array[Byte](32)
			rand.nextBytes(salt)
			val skf : SecretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
			val spec : PBEKeySpec = new PBEKeySpec(data, salt, ITERATION_COUNT, KEY_LENGTH)
      
			val key = skf.generateSecret(spec)
			hash = key.getEncoded
		} catch {
			case gse: GeneralSecurityException =>
		} finally Arrays.fill(password.getBytes, 0.toByte)
		Base64.getEncoder.encodeToString(hash)
	}
	
	def SafePredictableSalt(password: String) = {
		val data : Array[Char] = password.toCharArray
		var hash : Array[Byte] = null

		try {
			val rand : SecureRandom = new SecureRandom()
			val salt : Array[Byte] = new Array[Byte](32)
			rand.nextBytes(salt)
			val skf : SecretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
			val spec : PBEKeySpec = new PBEKeySpec(data, salt, ITERATION_COUNT, KEY_LENGTH)
      
			val key = skf.generateSecret(spec) //result
		}
	}

  def hashPasswordSafe(password: String): Array[Byte] = {
    val random = new SecureRandom()
    val salt =  new Array[Byte](16)
    random.nextBytes(salt)
    val plainTextBytes = password.getBytes()
    val md = MessageDigest.getInstance("SHA")
    md.update(salt)
    md.digest(plainTextBytes)
  }
  
}