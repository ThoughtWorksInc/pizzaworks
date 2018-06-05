package controllers;

import dal.OrderService;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static util.TemplateHelper.renderTemplate;

public class ConfirmationController {


    private  static OrderService orderService;

    public static void initialize(OrderService orderService) {
        ConfirmationController.orderService = orderService;
        get("/confirmation", (req, res) -> renderConfirmationPage());
        //post("/confirmation", );

    }

    private static Object renderConfirmationPage() {
        Map<String, Object> model = new HashMap<>();
        return renderTemplate("velocity/confirmation.vm", model);
    }



}
