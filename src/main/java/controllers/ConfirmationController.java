package controllers;

import dal.OrderService;
import dal.PizzaService;
import model.Order;
import spark.Request;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.post;
import static util.TemplateHelper.renderTemplate;

public class ConfirmationController {


    private  static OrderService orderService;
    private static PizzaService pizzaService;

    public static void initialize(OrderService orderService, PizzaService pizzaService) {
        ConfirmationController.orderService = orderService;
        ConfirmationController.pizzaService = pizzaService;
        post("/confirmation", (req, res) -> renderConfirmationPage(req));

    }


    private static Object renderConfirmationPage(Request req) {
        Map<String, Object> model = new HashMap<>();
        String pizza_id = req.queryParams("pizza_id");
        String customer_name = req.queryParams("customer_name");
        Order order = orderService.createOrder(customer_name, pizza_id);
        model.put("confirmedPizza", pizzaService.getPizzaFromOrder(order).get());
        model.put("orderName",order.getCustomer_name());
        model.put("orderNumber",order.getOrder_number());
        return renderTemplate("velocity/confirmation.vm", model);
    }


}
