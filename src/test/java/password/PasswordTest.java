package password;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PasswordTest {
    @Test
    public void shouldHashAndSaltPassword() throws Exception {
        String password = "apple";
        assertThat(Password.hashAndSalt(password), is("3A7BD3E2360A3D29EEA436FCFB7E44C735D117C42D1C1835420B6B9942DD4F1B"));

    }
}
