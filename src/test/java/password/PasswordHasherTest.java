package password;

import org.junit.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PasswordHasherTest {
    @Test
    public void shouldHashAndSaltPassword() throws Exception {
        String password = "pass123";
        assertThat(PasswordHasher.hashAndSalt(password), is("9B8769A4A742959A2D0298C36FB70623F2DFACDA8436237DF08D8DFD5B37374C"));

    }
}
