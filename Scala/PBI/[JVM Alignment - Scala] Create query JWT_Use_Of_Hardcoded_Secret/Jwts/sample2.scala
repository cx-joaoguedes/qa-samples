object JwtGenerator {

  public static String generateToken() {
    String secretKey = "password123"; // weak key
    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + 86400000); // 24 hours

    return Jwts.builder()
      .setSubject("user")
      .setIssuedAt(now)
      .setExpiration(expiryDate)
      .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
      .compact();
  }

}
