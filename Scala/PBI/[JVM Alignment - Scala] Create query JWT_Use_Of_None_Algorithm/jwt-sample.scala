import io.jsonwebtoken.{Claims, Jws, Jwts, SignatureAlgorithm}

import java.time.Instant
import java.util.{Date, UUID}

object JwtExample {

  // TN
  def getJwtSafe() : String = {
    Jwts.builder()
      .setHeaderParam("typ", "JWT")
      .setHeaderParam("alg", "HS256")
      .claim("name","value")
      .signWith(SignatureAlgorithm.HS256, secretBytes)
      .compact()
  }

  //TP
  def getJwtWithNoneAlg() : String = {
    Jwts.builder() //Result
      .setHeaderParam("typ", "JWT")
      .setHeaderParam("alg", "None") //Explicitly set to "None"
      .claim("name","value")
      .compact()
  }

  //TP
  def getJwt() : String = {
    Jwts.builder() //Result
      .setHeaderParam("typ", "JWT")
      //In JJWT Library, if algorithm is specified but signWith() is never called,
      //the algorithm will be None
      .setHeaderParam("alg", "HS256")
      .claim("name","value")
      .compact()
  }

  def main(args: Array[String]): Unit = {
    val jwt = getJwtSafe()
    println(s"JWT: $jwt")
  }
}
