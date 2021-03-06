package controllers;

import dal.PizzaService;
import domain.PizzaWorksRequest;
import model.NutritionalValues;
import model.Pizza;
import spark.Request;
import spark.Response;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;
import static util.TemplateHelper.renderTemplate;

public class AdminController {
    private static PizzaService pizzaService;

    public static void initialize(PizzaService pizzaService) {
        AdminController.pizzaService = pizzaService;

        get("/admin", (req, res) -> {
            PizzaWorksRequest pizzaWorksRequest = new PizzaWorksRequest(req);
            return pizzaWorksRequest.isLoggedIn() ? renderAdminPage(req) : redirectToLogin(res);
        });

        post("/admin", AdminController::savePizza);

    }

    private static Response redirectToLogin(Response res) {
        res.redirect("/login");
        return res;
    }

    private static String renderAdminPage(Request req) {
        Map<String, Object> model = new HashMap<>();
        model.put("pizzas", pizzaService.getAllPizzas());
        return renderTemplate("velocity/admin.vm", model, req);
    }

    private static Object savePizza(Request req, Response res) {

//        String[] alarray = req.queryParamsValues("allergen");
//        List<String> list = Arrays.asList(alarray);
//        System.out.println(list);
//        System.out.println(req.body());


        String pizza_name = req.queryParams("pizzaname");
//        String s = req.queryParams("pizzaprice");
//      float pizza_Price = Float.valueOf(s.trim()).floatValue();
        float pizza_Price = Float.parseFloat(req.queryParams("pizzaprice"));
        String pizza_ingredients = req.queryParams("pizzaingredients");
        String pizzaSlug = req.queryParams("pizzaslug");
        int weight = Integer.parseInt(req.queryParams("pizzaweight"));
        int numOfSlices = Integer.parseInt(req.queryParams("pizzaslice"));
        int energy_per_slice = Integer.parseInt(req.queryParams("energy"));
        float protein_per_slice = Float.parseFloat(req.queryParams("protein"));
        float carbohydrate_per_slice = Float.parseFloat(req.queryParams("carbs"));
        float sugars_per_slice = Float.parseFloat(req.queryParams("sugars"));
        float fat_per_slice = Float.parseFloat(req.queryParams("fat"));
        float saturated_fat_per_slice = Float.parseFloat(req.queryParams("saturatedfat"));
        float salt_per_slice = Float.parseFloat(req.queryParams("salt"));
        int energy_per_100 = Integer.parseInt(req.queryParams("energy100"));
        float protein_per_100 = Float.parseFloat(req.queryParams("protein100"));
        float carbohydrate_per_100 = Float.parseFloat(req.queryParams("carbs100"));
        float sugars_per_100 = Float.parseFloat(req.queryParams("sugars100"));
        float fat_per_100 = Float.parseFloat(req.queryParams("fat100"));
        float saturated_fat_per_100 = Float.parseFloat(req.queryParams("saturatedfat100"));
        float salt_per_100 = Float.parseFloat(req.queryParams("salt100"));
        List<String> allergens = Arrays.asList(req.queryParamsValues("allergen"));
        String allergen = String.join(", ", allergens);
        boolean vegetarian = Boolean.parseBoolean(req.queryParams("myonoffswitch"));
        boolean vegan = Boolean.parseBoolean(req.queryParams("myonoffswitch1"));

        System.out.println(vegan);
        System.out.println(vegetarian);
        System.out.println(allergen);


        NutritionalValues nutritionalValues1 = new NutritionalValues(weight, numOfSlices, energy_per_slice, protein_per_slice,
                carbohydrate_per_slice, sugars_per_slice, fat_per_slice, saturated_fat_per_slice, salt_per_slice, energy_per_100, protein_per_100,
                carbohydrate_per_100, sugars_per_100, fat_per_100, saturated_fat_per_100, salt_per_100, allergen, vegetarian, vegan);


        Pizza newPizza = new Pizza(pizza_name, UUID.randomUUID(), pizza_Price, pizza_ingredients, pizzaSlug, nutritionalValues1);
        if (newPizza.isValid()) {
            pizzaService.createPizza(newPizza);
            res.redirect("/admin");
            return res;
        } else {
            res.redirect("/admin ?Valid=false");
            return res;
        }

    }
}