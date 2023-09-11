import java.security.MessageDigest;

public class InsecurePasswordStorage {
    private static final String SALT = "StaticSalt123";

    public static String hashPassword(String password) {
        String saltedPassword = SALT + password;
        String hashedPassword = "";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedBytes = md.digest(saltedPassword.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            hashedPassword = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hashedPassword;
    }
}
