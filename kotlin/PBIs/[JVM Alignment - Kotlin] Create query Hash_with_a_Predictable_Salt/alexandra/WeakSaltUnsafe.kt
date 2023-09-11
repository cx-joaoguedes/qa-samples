package com.example.sampleautomation

import org.springframework.security.crypto.bcrypt.BCrypt
import java.security.MessageDigest
import java.security.SecureRandom
import java.util.*

public class CryptoQueriesUnsafe {
    companion object {
        fun hashPassword(password: String): String {
            val generatedSecuredPasswordHash = BCrypt.hashpw(password, BCrypt.gensalt(12)); //Secure
        }

        fun weakHashPassword(password: String): ByteArray {
            //Not secure:
			val salt = "HardcodedPredictableSalt"
            val md = MessageDigest.getInstance(CryptoConstants.HASH_ALG)
            md.update(salt) //usage of hardcoded salt
			return md.digest(password.getBytes()) //result
        }
		
		 fun weakHashPassword2(password: String): ByteArray {
			val salt = "HardcodedPredictableSalt"
            val md = MessageDigest.getInstance(CryptoConstants.HASH_ALG)
            md.update(salt) //usage of hardcoded salt
			var data = password.getBytes()
			return md.digest(data) //result
        }
		
		fun hashWithPreditableSaltUnsafeRandom(password: String): ByteArray {
            val random = Random()
            val salt = ByteArray(16)
            random.nextBytes(salt)
            val md = MessageDigest.getInstance(CryptoConstants.HASH_ALG)
            md.update(salt)
            return md.digest(password.encodeToByteArray())
        }
    }
}