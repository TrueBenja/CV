package no.truebenja;

import jakarta.xml.bind.DatatypeConverter;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

@Service
public class PasswordService {
    /**
     * @return A randomly generated salt of 16 bytes using SHA1PRNG
     */
    public String generateRandomSalt() {
        SecureRandom sr;
        byte[] salt = new byte[16];
        try {
            sr = SecureRandom.getInstance("SHA1PRNG");
            sr.nextBytes(salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return DatatypeConverter.printHexBinary(salt);
    }

    /**
     * This method takes in a password in clear text, and a 16 byte salt, and hashes them with the PBKDF2WithHmacSHA1 algorithm.
     * It does so for 1000 iterations.
     * @param password The password to hash
     * @param salt The salt generated from generateRandomSalt()
     * @return A 64 character long hex-string which represents a 256-bit hash
     */
    public String hashWithSalt(String password, String salt) {
        if (password == null || salt == null) {
            throw new IllegalArgumentException("Password or salt is null");
        }

        char[] passChars = password.toCharArray();
        byte[] saltChars = DatatypeConverter.parseHexBinary(salt);

        byte[] keyHash = null;

        try {
            PBEKeySpec pks = new PBEKeySpec(passChars, saltChars, 1000, 256);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            keyHash = skf.generateSecret(pks).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return  DatatypeConverter.printHexBinary(keyHash);
    }

    public boolean checkPassword(String password, String hash, String salt) {
        if (password == null || hash == null || salt == null) {
            throw new IllegalArgumentException("Password or hash or salt is null");
        }

        return hash.equals(hashWithSalt(password, salt));
    }
}
