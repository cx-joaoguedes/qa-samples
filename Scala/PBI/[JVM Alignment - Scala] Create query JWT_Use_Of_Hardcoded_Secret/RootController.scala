package spring.boot.scala.example.controller

import io.micrometer.core.annotation.Timed
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.{RequestMapping, RestController}

import java.time.LocalDateTime
import java.util.{Base64, Date}
import io.jsonwebtoken.Jwt
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.UnsupportedJwtException


@RestController
class RootController {
  @Value("${jwt.base64-secret:MY_SECRET_KEY}")
  val appName: String = null

  @RequestMapping(path = Array("/"), method = Array(GET))
  @Timed
  def root(): Map[String, Any] = {
    Map("name" -> appName, "message" -> "It works on my machine!")
  }

  def getJwtWithExp(): String = {
    val bytesEncoded = Base64.getEncoder.encode(appName.getBytes) //Secret is hardcoded
    val today: Date = new Date()
    val expDate: Date = new Date(today.getTime() + 900000) //+15 minutes (in milliseconds)
    Jwts.builder()
      .setHeaderParam("typ", "JWT")
      .setHeaderParam("alg", "HS256")
      .setExpiration(expDate)
      .setIssuer("issuer")
      .claim("claim", "claimVal")
      .signWith(SignatureAlgorithm.HS256, bytesEncoded) //bytesEncoded is based on a hardcoded string
      .compact()
  }

  // Checking if the flow is correct
  def getJwtWithExp2(): String = {
    val bytesEncoded = Base64.getEncoder.encode(appName.getBytes) //Secret is hardcoded
    val today: Date = new Date()
    val expDate: Date = new Date(today.getTime() + 900000) //+15 minutes (in milliseconds)
    Jwts.builder()
      .setHeaderParam("typ", "JWT")
      .setHeaderParam("alg", "HS256")
      .setExpiration(expDate)
      .setIssuer("issuer")
      .claim("claim", "claimVal")
      .signWith(SignatureAlgorithm.HS256, bytesEncoded) //bytesEncoded is based on a hardcoded string
      .compact()
  }
}

