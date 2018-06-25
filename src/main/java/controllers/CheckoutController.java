package controllers;

import dal.PizzaService;
import model.Pizza;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static util.TemplateHelper.renderTemplate;

public class CheckoutController {

    private static PizzaService pizzaService;

    public static void initialize(PizzaService pizzaService) {
        CheckoutController.pizzaService = pizzaService;
        get("/checkout/:slug", CheckoutController::renderCheckoutPage);
    }

    private static String renderCheckoutPage(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        String slug = req.params(":slug");
        Pizza orderedPizza = pizzaService.getPizzaBySlug(slug).get();
        model.put("orderedPizza", orderedPizza);
        if(!Boolean.parseBoolean(req.queryParams("Valid"))) {
            model.put("invalid", true);
        }
        return renderTemplate("velocity/checkout.vm", model, req);
    }

}