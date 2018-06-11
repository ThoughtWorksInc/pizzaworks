package controllers;

import dal.OrderService;
import model.Order;
import spark.Request;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.post;
import static util.TemplateHelper.renderTemplate;

public class ConfirmationController {


    private  static OrderService orderService;

    public static void initialize(OrderService orderService) {
        ConfirmationController.orderService = orderService;
        post("/confirmation", (req, res) -> renderConfirmationPage(req));
        //post("/confirmation", );
    }

    private static Object renderConfirmationPage(Request req) {
        Map<String, Object> model = new HashMap<>();
        String pizza_id = req.queryParams("pizza_id");
        String customer_name = req.queryParams("customer_name");
        Order order = orderService.createOrder(customer_name, pizza_id);
        model.put("orderedPizza", orderService.getPizzaFromOrder(order));
        return renderTemplate("velocity/confirmation.vm", model);
    }


}
