package dal;

import model.Pizza;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Sql2oDatabaseModelTest {

    @Mock
    private Sql2o sql2oMock;

    @InjectMocks
    private Sql2oDatabaseModel sql2oDatabaseModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldQueryForAllPizzas() {
        Connection connectionMock = mock(Connection.class);
        when(sql2oMock.open()).thenReturn(connectionMock);
        Query queryMock = mock(Query.class);
        when(connectionMock.createQuery(ArgumentMatchers.eq("select * from pizza"))).thenReturn(queryMock);

        sql2oDatabaseModel.getAllPizzas();
        verify(queryMock).executeAndFetch(Pizza.class);
    }

}