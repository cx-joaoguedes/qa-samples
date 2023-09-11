object HardcodedSecret {

  public static String generateToken() {
    String secretKey = "my_hardcoded_secret_key";
    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + 86400000);

    Jwts.builder()
      .setSubject("user")
      .setIssuedAt(now)
      .setExpiration(expiryDate)
      .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
      .compact();
  }

}
