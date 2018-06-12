package controllers;

import dal.PizzaService;
import model.Pizza;
import spark.Request;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static util.TemplateHelper.renderTemplate;

public class CheckoutController {

    private static PizzaService pizzaService;

    public static void initialize(PizzaService pizzaService) {
        CheckoutController.pizzaService = pizzaService;
        get("/checkout/:slug", (req, res) -> renderCheckoutPage(req));
    }

    private static String renderCheckoutPage(Request req) {
        Map<String, Object> model = new HashMap<>();
        String slug = req.params(":slug");
        Pizza orderedPizza = pizzaService.getPizzaBySlug(slug).get();
        model.put("orderedPizza", orderedPizza);
        return renderTemplate("velocity/checkout.vm", model, req);
    }

};