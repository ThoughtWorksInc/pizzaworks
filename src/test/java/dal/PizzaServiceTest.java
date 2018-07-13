package dal;

import builders.PizzaDaoBuilder;
import com.google.common.collect.Lists;
import dal.dao.PizzaDAO;
import model.Pizza;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class PizzaServiceTest {

    @Mock
    private Connection connectionMock;

    @Mock
    private Query queryMock;

    @Mock
    private Sql2o sql2oMock;


    @InjectMocks
    private PizzaService pizzaService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(sql2oMock.open()).thenReturn(connectionMock);
    }

    @Test
    public void shouldQueryForAllPizzas() {
        when(connectionMock.createQuery(eq("select * from pizza"))).thenReturn(queryMock);
        when(queryMock.executeAndFetch(PizzaDAO.class)).thenReturn(Lists.newArrayList(PizzaDaoBuilder.pizzaDao().withName("test").build()));
        List<Pizza> allPizzas = pizzaService.getAllPizzas();
        assertThat(allPizzas.get(0).getName(), is("test"));
        verify(queryMock).executeAndFetch(PizzaDAO.class);
    }

    @After
    public void validate() {
        validateMockitoUsage();
    }


}