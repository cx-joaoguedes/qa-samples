class Sample {
	def getJwtWithExpUnsafe () : String = {
		val bytesEncoded = Base64.getEncoder.encode(System.getenv("MY_SECRET_KEY").getBytes)
		val today : Date = new Date()
		val expDate : Date = new Date(today.getTime() + 2592000000) //+30 days (in milliseconds)
		
		Jwts.builder()
			.setHeaderParam("typ", "JWT")
			.setHeaderParam("alg", "HS256")
			.setExpiration(expDate)
			.setIssuer("issuer")
			.claim("claim","claimVal")
			.signWith(SignatureAlgorithm.HS256, bytesEncoded)
			.compact()
	}
	
	def getJwtWithExpSafe () : String = {
		val bytesEncoded = Base64.getEncoder.encode(System.getenv("JWT_SIGNATURE_SECRET").getBytes)
		val today : Date = new Date()
		val expDate : Date = new Date(today.getTime() + 900000) //+15 minutes (in milliseconds)
		
		Jwts.builder()
			.setHeaderParam("typ", "JWT")
			.setHeaderParam("alg", "HS256")
			.setExpiration(expDate)
			.setIssuer("issuer")
			.claim("claim","claimVal")
			.signWith(SignatureAlgorithm.HS256, bytesEncoded)
			.compact()
	}
}