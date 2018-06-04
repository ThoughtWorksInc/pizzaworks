package integration;

import dal.LoginService;
import dal.dao.PizzaDAO;
import functional.helpers.DatabaseSetupRule;
import model.Admin;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LoginIntegrationTest {

    private LoginService loginService;

    @ClassRule
    public static DatabaseSetupRule dbSetupRule = new DatabaseSetupRule();

    @Before
    public void setUp() throws Exception {
        loginService = new LoginService(dbSetupRule.getSql2o());
    }

    @Test
    public void shouldRetrieveTheAdminUsername(){
        Admin adminUserName = loginService.getAdminUserName("Admin1").get();
        assertThat(adminUserName.getName(), is("Admin1"));
    }
    @Test
    public void shouldRetrieveTheAdminHashcode(){
        String hashedCode = "9B8769A4A742959A2D0298C36FB70623F2DFACDA8436237DF08D8DFD5B37374C";
        Admin adminHashedCode = loginService.getAdminUserHashcode(hashedCode).get();
        assertThat(adminHashedCode.getHashcode(), is(hashedCode));
    }
}
