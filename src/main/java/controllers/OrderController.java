package controllers;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static util.TemplateHelper.renderTemplate;

public class OrderController {
    public static void initialize() {

        get("/checkout", (req, res) -> renderCheckoutPage());
    }

    private static String renderCheckoutPage() {
        Map<String, Object> model = new HashMap<>();
        return renderTemplate("velocity/checkout.vm", model);
    }
};