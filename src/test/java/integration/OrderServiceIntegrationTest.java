package integration;

import dal.OrderService;
import dal.PizzaService;
import functional.helpers.DatabaseSetupRule;
import model.Order;
import model.Pizza;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

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
        Pizza pizza = pizzaService.getPizzaBySlug("veggie").get();
        Order order = orderService.createOrder(customerName, pizza.getUuid().toString());
        assertThat(order.getCustomer_name() , is(customerName));
        assertThat(order.getPizza_id(), is(pizza.getUuid()));
    }

    @Test
    public void shouldRetrievePizzaName() {
        Pizza pizza = pizzaService.getPizzaBySlug("veggie").get();
        Order order = orderService.createOrder("Arpitha", pizza.getUuid().toString());
        assertNotNull(order);
        assertThat(pizzaService.getPizzaFromOrder(order.getPizza_id()).get().getName(), is("Veggie"));

    }

}
