package integration;

import dal.OrderService;
import dal.PizzaService;
import functional.helpers.DatabaseSetupRule;
import model.Pizza;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
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
        orderService.createOrder(customerName, pizza);
    }

    @Test
    public void shouldRetrieveOrderedPizzaDetailsFromDatabase() {

        Pizza orderedPizza = pizzaService.getPizzaBySlug("veggie").get();
        // bring back one pizza e.g veggie as per our params
        // then be able to get that pizza's name / price / size

        assertThat(orderedPizza.getName(), is("Veggie"));
        assertThat(orderedPizza.getPrice(), is(12.99F));
    }

}
