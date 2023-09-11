import pdi.jwt.JwtAlgorithm
import pdi.jwt.JwtJson
import pdi.jwt.JwtOptions

class JwtAuthenticator {
  private val jwtSecret = "my-secret"
  private val algorithm = JwtAlgorithm.HS256

  def generateToken(username: String): String = {
    val claims = Map("username" -> username)
    JwtJson.encode(claims, jwtSecret, algorithm)
  }

  def validateToken(token: String): Option[String] = {
    try {
      val claims = JwtJson.decode(token, jwtSecret, Seq(algorithm), JwtOptions.DEFAULT)
      Some(claims("username").toString)
    } catch {
      case _: Throwable => None
    }
  }
}
