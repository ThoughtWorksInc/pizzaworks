package controllers;

import dal.PizzaService;
import model.Pizza;
import spark.Request;
import util.TemplateHelper;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.post;

public class PizzaController {
    private static PizzaService pizzaService;

    public static void initialize(PizzaService pizzaService) {
        PizzaController.pizzaService = pizzaService;

        get("/", (req, res) -> renderPizzas(req));
        get("/pizza/:pizzaslug", (req, res) -> renderChosenPizza(req));


    }

    private static String renderChosenPizza(Request req) {
        Map<String, Pizza> model = new HashMap<>();

        String slug = req.params(":pizzaslug");
        Optional<Pizza> pizzaBySlug = pizzaService.getPizzaBySlug(slug);
        if (!pizzaBySlug.isPresent()) {
            halt("Not found");
        }

        model.put("chosenPizza", pizzaBySlug.get());
        return TemplateHelper.renderTemplate("velocity/chosenPizza.vm", model, req);
    }

    private static String renderPizzas(Request req) {
        Map<String, Object> model = new HashMap<>();
        model.put("pizzas", pizzaService.getAllPizzas());
        return TemplateHelper.renderTemplate("velocity/pizzaList.vm", model, req);
    }



}
