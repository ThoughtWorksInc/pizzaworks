package controllers;

import dal.PizzaService;
import dal.dao.PizzaDAO;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import model.Pizza;
import util.TemplateHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static spark.Spark.*;

public class PizzaController {
    private static PizzaService pizzaService;

    public static void initialize(PizzaService pizzaService) {
        PizzaController.pizzaService = pizzaService;

        get("/", (req, res) -> renderPizzas());
        get("/pizza/:pizzaslug", (req, res) -> renderChosenPizza(req.params(":pizzaslug")));
    }

    private static String renderChosenPizza(String slug) {
        Map<String, Pizza> model = new HashMap<>();
        Optional<Pizza> pizzaBySlug = pizzaService.getPizzaBySlug(slug);
        if (!pizzaBySlug.isPresent()) {
            halt("Not found");
        }
        model.put("chosenPizza", pizzaBySlug.get());
        return TemplateHelper.renderTemplate("velocity/chosenPizza.vm", model);
    }

    private static String renderPizzas() {
        Map<String, Object> model = new HashMap<>();
        model.put("pizzas", pizzaService.getAllPizzas());

        return TemplateHelper.renderTemplate("velocity/pizzaList.vm", model);
    }

}
