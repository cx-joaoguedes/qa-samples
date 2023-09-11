object HardcodedSecret {
    def getJwtWithExp () :String = {
    val today : Date = new Date()
    val expDate : Date = new Date(today.getTime() + 900000) // +15 minutes (in milliseconds)
    Jwts.builder()
        .setHeaderParam("typ", "JWT")
        .setHeaderParam("alg", "HS256")
        .setExpiration(expDate)
        .setIssuer("issuer")
        .claim("claim","claimVal")
        .signWith(SignatureAlgorithm.HS256, "MY_SECRET_KEY") // Secret is hardcoded
        .compact()
    }
}