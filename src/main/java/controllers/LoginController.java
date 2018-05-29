package controllers;

import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import static util.TemplateHelper.renderTemplate;

public class LoginController {
    public static void initialize() {
        get("/login", (req, res) -> renderLoginPage());
        get("/admin", (req, res) -> renderAdminPage());
        post("/login", LoginController::processLogin);

        before("/admin", (request, response) -> {
            Boolean loggedIn = request.session().attribute("loggedIn");
            if(loggedIn == null || !loggedIn) {
                response.redirect("/login");
            }

        });
    }

    private static String processLogin(Request req, Response response) {
        req.session(true).attribute("loggedIn", true);
        response.redirect("/admin");
        return "";
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
