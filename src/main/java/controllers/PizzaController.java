package controllers;

import config.DatabaseConfig;
import dal.PizzaService;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.after;
import static spark.Spark.get;

public class PizzaController {
    private  static PizzaService pizzaService;

    public static void initialize(PizzaService pizzaService) {
        PizzaController.pizzaService = pizzaService;
        get("/", (req, res) -> renderPizzas());
        get("/pizza/:pizzaslug", (req, res) -> renderChosenPizza(req.params(":pizzaslug")));

        after((req, res) -> {
            if (res.body() == null) { // if the route didn't return anything
                res.body(renderPizzas());
            }
        });
    }

    private static String renderChosenPizza(String slug) {
        Map<String, Object> model = new HashMap<>();
        model.put("chosenPizza", pizzaService.getPizzaBySlug(slug));
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
