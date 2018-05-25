package controllers;

import dal.PizzaService;
import model.Pizza;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static spark.Spark.*;

public class PizzaController {
    private  static PizzaService pizzaService;

    public static void initialize(PizzaService pizzaService) {
        PizzaController.pizzaService = pizzaService;
        get("/", (req, res) -> renderPizzas());
        get("/pizza/:pizzaslug", (req, res) -> renderChosenPizza(req.params(":pizzaslug")));
        get("/login", (req, res) -> renderLoginPage());



        after((req, res) -> {
            if (res.body() == null) { // if the route didn't return anything
                res.body(renderPizzas());
            }
        });
    }

    private static String renderLoginPage() {
        Map<String, Object> model = new HashMap<>();
        return renderTemplate("velocity/login.vm", model);
    }

    private static String renderChosenPizza(String slug) {
        Map<String, Pizza> model = new HashMap<>();
        Optional<Pizza> pizzaBySlug = pizzaService.getPizzaBySlug(slug);
        if (!pizzaBySlug.isPresent()) {
            halt("Not found");
        }
        model.put("chosenPizza", pizzaBySlug.get());
        return renderTemplate("velocity/chosenPizza.vm", model);
    }

    private static String renderPizzas() {
        Map<String, Object> model = new HashMap<>();
        model.put("pizzas", pizzaService.getAllPizzas());

        return renderTemplate("velocity/pizzaList.vm", model);
    }

    private static String renderTemplate(String template, Map model) {
        model.put("template", template);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "velocity/index.vm"));
    }
}
