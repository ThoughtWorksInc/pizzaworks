package controllers;

import dal.PizzaService;
import model.NutritionalValues;
import model.Order;
import model.Pizza;
import spark.Request;
import spark.Response;
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
        post("/admin", PizzaController::savePizza);
        get("/admin", (req, res) -> renderPizzas(req));

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

    private static Object savePizza(Request req, Response res) {
        System.out.println(res);

        String pizza_name = req.queryParams("pizzaname");
        Float pizza_Price = Float.parseFloat("pizzaprice");
        String pizza_ingredients = req.queryParams("pizzaingredients");
        String pizzaSlug = req.queryParams("pizzaslug");
        int weight = Integer.parseInt(req.queryParams("weight"));
        int numOfSlices = Integer.parseInt(req.queryParams("numOfSlices"));
        int energy_per_slice = Integer.parseInt(req.queryParams("energy_per_slice"));
        float protein_per_slice = Float.parseFloat(req.queryParams("pizza_price"));
        float carbohydrate_per_slice = Float.parseFloat(req.queryParams("pizza_price"));
        float sugars_per_slice = Float.parseFloat(req.queryParams("pizza_price"));
        float fat_per_slice = Float.parseFloat(req.queryParams("pizza_price"));
        float saturated_fat_per_slice = Float.parseFloat(req.queryParams("pizza_price"));
        float salt_per_slice = Float.parseFloat(req.queryParams("pizza_price"));
        int energy_per_100 = Integer.parseInt(req.queryParams("energy_per_slice"));
        float protein_per_100 = Float.parseFloat(req.queryParams("pizza_price"));
        float carbohydrate_per_100 = Float.parseFloat(req.queryParams("pizza_price"));
        float sugars_per_100 = Float.parseFloat(req.queryParams("pizza_price"));
        float fat_per_100 = Float.parseFloat(req.queryParams("pizza_price"));
        float saturated_fat_per_100 = Float.parseFloat(req.queryParams("pizza_price"));
        float salt_per_100 = Float.parseFloat(req.queryParams("pizza_price"));
        String allergens = req.queryParams("allergens");
        boolean vegetarian = Boolean.parseBoolean(req.queryParams("vegetarian"));
        boolean vegan = Boolean.parseBoolean(req.queryParams("vegan"));

        if (pizza_name.equals("")) {
            res.redirect("/admin" + pizzaSlug + "?Valid=false");
            return res;
        } else {
//            NutritionalValues nutritionalValues1 = new NutritionalValues(weight, numOfSlices, energy_per_slice, protein_per_slice, carbohydrate_per_slice,
//                    sugars_per_slice, fat_per_slice, saturated_fat_per_slice, salt_per_slice, energy_per_100, protein_per_100,
//                    carbohydrate_per_100, sugars_per_100, fat_per_100, saturated_fat_per_100, salt_per_100, allergens, vegetarian, vegan);

            NutritionalValues nutritionalValues1 = new NutritionalValues(1,1,1,1,
                    1,1,1,1,1,1,1,
                    1,1,1,1,1,"all", true,false);


            Pizza pizza1 = new Pizza(pizza_name, UUID.randomUUID(), pizza_Price, pizza_ingredients,pizzaSlug, nutritionalValues1);
            List<Pizza> pizza = pizzaService.createPizza(pizza1);
            res.redirect("/admin");
            return res;
        }


    }


}
