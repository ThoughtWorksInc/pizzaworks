package dal;

import functional.helpers.DatabaseSetupRule;
import model.Order;
import model.Pizza;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OrderServiceTest{

    private PizzaService pizzaService;
    private OrderService orderService;

    @ClassRule
    public static DatabaseSetupRule dbSetupRule = new DatabaseSetupRule();

    @Before
    public void setUp() {
        orderService = new OrderService(dbSetupRule.getSql2o());
        pizzaService = new PizzaService(dbSetupRule.getSql2o());

    }

    @Test
    public void shouldReturnOrderNumberGenerated() throws InterruptedException {
        Pizza pizza = pizzaService.getPizzaBySlug("veggie").get();
        String customerName = "Rebe";
        System.out.println(pizza.getUuid()+"******");
        Order order = orderService.createOrder(customerName, pizza.getUuid().toString());

        assertThat(order.getOrder_number() , is(10000));

    }


}