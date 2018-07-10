package password;

import dal.LoginService;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {


    public Password(LoginService loginService) {

    }

    public static String hashAndSalt(String password) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

        String hashedPassword = DatatypeConverter.printHexBinary(hash);


        return hashedPassword;

    }
}
