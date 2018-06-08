import dal.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;
import sun.rmi.runtime.Log;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

public class LoginServiceTest {

    private LoginService loginService;

    @Before
    public void setUp() throws Exception {
        Sql2o sql2o = mock(Sql2o.class);
        loginService = new LoginService(sql2o);
    }

    @Test
    public void shouldReturnFalseIfNullUsernameAndPassword() {
        assertFalse(loginService.isValidAdminUser(null, null));
    }
}
