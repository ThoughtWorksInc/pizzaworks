package controllers;

import domain.PizzaWorksRequest;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static util.TemplateHelper.renderTemplate;

public class AdminController {

    public static void initialize() {
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
        return renderTemplate("velocity/admin.vm", model);
    }
}
