package domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import spark.Request;
import spark.Session;

import java.security.NoSuchAlgorithmException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class PizzaWorksRequestTest {
    @Mock
    private Request requestMock;

    @Mock
    private Session sessionMock;

    @InjectMocks
    PizzaWorksRequest pizzaWorksRequest;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldKnowIfUserIsLoggedIn() {
        when(requestMock.session()).thenReturn(sessionMock);
        when(sessionMock.attribute("loggedIn")).thenReturn(true);
        assertThat(pizzaWorksRequest.isLoggedIn(), is(true));
    }

    @Test
    public void shouldReturnFalseIfLoggedInAttributeIsNull(){
        when(requestMock.session()).thenReturn(sessionMock);
        when(sessionMock.attribute("loggedIn")).thenReturn(null);
        assertThat(pizzaWorksRequest.isLoggedIn(), is(false));
    }

    @Test
    public void shouldReturnUsernameFromRequest() {
        when(requestMock.queryParams("username")).thenReturn("apple");
        assertThat(pizzaWorksRequest.getUsername(), is("apple"));
    }


    @Test
    public void shouldReturnHashedPasswordFromRequest() throws NoSuchAlgorithmException {
        when(requestMock.queryParams("password")).thenReturn("mango");
        assertThat(pizzaWorksRequest.getHashedPassword(), is("6815F3C300383519DE8E437497E2C3E97852FE8D717A5419D5AAFB00CB43C494"));
    }


}
