package dal;

import functional.helpers.DatabaseSetupRule;
import functional.helpers.FunctionalTestSetup;
import model.Order;
import model.Pizza;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

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

        assertThat(order.getOrder_number() , is(10000));
//
//        Order order2 = orderService.createOrder(customerName, pizza);
//        assertThat(order2.getOrder_number() , is(10001));
    }


}