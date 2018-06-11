package controllers;

import dal.PizzaService;
import domain.PizzaWorksRequest;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static util.TemplateHelper.renderTemplate;

public class AdminController {
    private static PizzaService pizzaService;

    public static void initialize(PizzaService pizzaService) {
        AdminController.pizzaService = pizzaService;

        get("/admin", (req, res) -> {
            PizzaWorksRequest pizzaWorksRequest = new PizzaWorksRequest(req);
            return pizzaWorksRequest.isLoggedIn() ? renderAdminPage() : redirectToLogin(res);
        });
    }

    private static Response redirectToLogin(Response res) {
        res.redirect("/login");
        return res;
    }

    private static String renderAdminPage() {
        Map<String, Object> model = new HashMap<>();
        model.put("pizzas", pizzaService.getAllPizzas());
        return renderTemplate("velocity/admin.vm", model);
    }
}
