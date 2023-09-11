import io.jsonwebtoken.{Jwts, SignatureAlgorithm}

val userId = "12345"
val username = "example_user"

val jwt = Jwts.builder()
  .setSubject(userId)
  .claim("username", username)
  .signWith(null, SignatureAlgorithm.NONE)
  .compact()
