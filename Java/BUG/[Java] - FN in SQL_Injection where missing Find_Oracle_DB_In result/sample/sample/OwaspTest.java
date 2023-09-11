package com.celestica;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.servlet.http.HttpServletRequest;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

public class OwaspTest {

    public void sqlInjection(Connection conn, String customerId) {
        String sql = "select * "
                + " from Accounts where customer_id = '"
                + customerId
                + "'";

        try (ResultSet rs = conn.createStatement().executeQuery(sql);) {
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean sqlInjection2(HttpServletRequest request) {
        boolean loggedIn = false;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String sql = "select * from users where (email ='" + email + "' and password ='" + password + "')";

        try (Connection connection = DriverManager.getConnection("...");) {
            Statement statement = connection.createStatement();
            try (ResultSet result = statement.executeQuery(sql);) {

                if (result.next()) {
                    loggedIn = true;
                } else {
                    loggedIn = false; // redundant
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loggedIn;
    }

    public SecretKey generateKey(int n) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(n);
        SecretKey key = keyGenerator.generateKey();
        return key;
    }

    public IvParameterSpec generateIv() {
        byte[] iv = new byte[8];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public String weakEncryption()
            throws NoSuchAlgorithmException, InvalidAlgorithmParameterException,
            InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException,
            BadPaddingException {
        String input = "testinputstring";
        SecretKey key = generateKey(56);
        IvParameterSpec iv = generateIv();
        String algorithm = "DES/CBC/PKCS5Padding";
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }

    public byte[] weakMd5Hash()
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] bytesOfMessage = "testinputstring".getBytes("UTF-8");

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] md5Digest = md.digest(bytesOfMessage);
        return md5Digest;
    }

    public static void main(String[] args) {
        OwaspTest o = new OwaspTest();
        try {
            Connection con = DriverManager.getConnection("...");
            o.sqlInjection(con, args[0]);
            String encryptedString = o.weakEncryption();
            System.out.println(encryptedString);
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
}
