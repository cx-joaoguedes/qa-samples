object HardcodedSecret {
    def getJwtWithExp () :String = {
    val bytesEncoded = Base64.getEncoder.encode("MY_SECRET_KEY".getBytes) // Secret is hardcoded
    val today : Date = new Date()
    val expDate : Date = new Date(today.getTime() + 900000) // +15 minutes (in milliseconds)
    Jwts.builder()
        .setHeaderParam("typ", "JWT")
        .setHeaderParam("alg", "HS256")
        .setExpiration(expDate)
        .setIssuer("issuer")
        .claim("claim","claimVal")
        .signWith(SignatureAlgorithm.HS256, bytesEncoded) // bytesEncoded is based on a hardcoded string
        .compact()
    }
}