package dal;

import dal.dao.PizzaDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PizzaDAOServiceTest {

    @Mock
    private Sql2o sql2oMock;

    @InjectMocks
    private PizzaService pizzaService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldQueryForAllPizzas() {
        Connection connectionMock = mock(Connection.class);
        when(sql2oMock.open()).thenReturn(connectionMock);
        Query queryMock = mock(Query.class);
        when(connectionMock.createQuery(eq("select * from pizza"))).thenReturn(queryMock);

        pizzaService.getAllPizzaDaos();
        verify(queryMock).executeAndFetch(PizzaDAO.class);
    }

}