package dal;

import functional.helpers.DatabaseSetupRule;
import javafx.beans.binding.BooleanExpression;
import model.Order;
import model.Pizza;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import static javax.management.Query.not;
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
        Order order = orderService.createOrder(customerName, pizza.getUuid().toString());
        Assert.assertNotNull(order.getOrder_number());

    }

}
