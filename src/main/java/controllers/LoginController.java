package controllers;

import dal.PizzaService;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.post;
import static util.TemplateHelper.renderTemplate;

public class LoginController {
    public static void initialize() {
        get("/login", (req, res) -> renderLoginPage());
        post("/login/admin", (req, res) -> renderAdminPage());

    }

    private static String renderLoginPage() {
        Map<String, Object> model = new HashMap<>();
        return renderTemplate("velocity/login.vm", model);
    }

    private static String renderAdminPage() {
        Map<String, Object> model = new HashMap<>();
        return renderTemplate("velocity/admin.vm", model);
    };
}
