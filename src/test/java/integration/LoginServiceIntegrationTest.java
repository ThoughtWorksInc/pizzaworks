package integration;

import dal.LoginService;
import functional.helpers.DatabaseSetupRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginServiceIntegrationTest {

    private LoginService loginService;

    @ClassRule
    public static DatabaseSetupRule dbSetupRule = new DatabaseSetupRule();

    @Before
    public void setUp() throws Exception {
        loginService = new LoginService(dbSetupRule.getSql2o());
    }

    @Test
    public void shouldRetrieveAndVerifyTheAdminUsername(){
        String givenAdminUsername = "Admin1";
        String givenAdminHashedPassword = "9B8769A4A742959A2D0298C36FB70623F2DFACDA8436237DF08D8DFD5B37374C";
        assertTrue("Expected password and username to match, but didn't", loginService.isValidAdminUser(givenAdminUsername, givenAdminHashedPassword));
    }
}
