package integration;

import dal.OrderService;
import dal.PizzaService;
import functional.helpers.DatabaseSetupRule;
import mappers.PizzaMapper;
import model.Pizza;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

public class OrderServiceIntegrationTest {

    private OrderService orderService;
    private PizzaService pizzaService;

    @ClassRule
    public static DatabaseSetupRule dbSetupRule = new DatabaseSetupRule();

    @Before
    public void setUp() {
        orderService = new OrderService(dbSetupRule.getSql2o());
        pizzaService = new PizzaService(dbSetupRule.getSql2o());

    }

    @Test
    public void shouldCreateAndGetOrder() {
        String customerName = "Jenny";
        Pizza pizza = PizzaMapper.toPizza(pizzaService.getPizzaBySlug("veggie").get());
        orderService.createOrder(customerName, pizza);

    }

}
