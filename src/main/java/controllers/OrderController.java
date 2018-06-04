package controllers;

import dal.PizzaService;
import model.Pizza;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static util.TemplateHelper.renderTemplate;

public class OrderController {

    private  static PizzaService pizzaService;

    public static void initialize(PizzaService pizzaService) {
        OrderController.pizzaService = pizzaService;
        get("/checkout/:slug", (req, res) -> renderCheckoutPage(req.params(":slug")));
    }

    private static String renderCheckoutPage(String slug) {
        Map<String, Object> model = new HashMap<>();
        Pizza orderedPizza = pizzaService.getPizzaBySlug(slug).get();
        model.put("orderedPizza", orderedPizza);
        return renderTemplate("velocity/checkout.vm", model);
    }

};