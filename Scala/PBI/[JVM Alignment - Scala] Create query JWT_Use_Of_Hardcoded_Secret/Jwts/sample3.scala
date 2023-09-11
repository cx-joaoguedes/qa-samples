object JwtGenerator {

  public static String generateToken() {
    SecureRandom random = new SecureRandom();
    byte[] bytes = new byte[20];
    random.nextBytes(bytes);
    String secretKey = Base64.getEncoder().encodeToString(bytes); // weak key
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
