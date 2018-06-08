package controllers;

import dal.OrderService;
import model.Pizza;
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
        Pizza pizza = new Pizza();
        String pizza_id = req.queryParams("pizza_id");
        orderService.createOrder("Rebecca", pizza_id);
        return renderTemplate("velocity/confirmation.vm", model);
    }



}
