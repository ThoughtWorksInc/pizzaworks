package integration;

import dal.OrderService;
import dal.PizzaService;
import model.Pizza;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderServiceIntegrationTest extends DBIntegrationTest {

    private OrderService orderService;
    private PizzaService pizzaService;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        orderService = new OrderService(sql2o);
        pizzaService = new PizzaService(sql2o);

    }

    @Test
    public void shouldCreateAndGetOrder() {
        String customerName = "Jenny";
        Pizza pizza = pizzaService.getPizzaBySlug("veggie").get();
        orderService.createOrder(customerName, pizza);

    }


    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
