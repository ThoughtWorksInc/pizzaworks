package controllers;

import dal.LoginService;
import domain.PizzaWorksRequest;
import spark.Request;
import spark.Response;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import static util.TemplateHelper.renderTemplate;

public class LoginController {
    private static LoginService loginService;

    public static void initialize(LoginService loginService) {
        LoginController.loginService = loginService;

        get("/login", (req, res) -> renderLoginPage());
        get("/admin", (req, res) -> {
            PizzaWorksRequest pizzaWorksRequest = new PizzaWorksRequest(req);
            return adminValidCheck(pizzaWorksRequest) ? renderAdminPage() : redirectToLogin(res);
        });


        post("/admin", (req, res) -> {
            PizzaWorksRequest pizzaWorksRequest = new PizzaWorksRequest(req);
            processLogin(req, pizzaWorksRequest);
            return adminValidCheck(pizzaWorksRequest) ? renderAdminPage() : redirectToLogin(res);
        });
    }

    private static Response redirectToLogin(Response res) {
        res.redirect("/login");
        return res;
    }

    private static void processLogin(Request request, PizzaWorksRequest pizzaWorksRequest) throws NoSuchAlgorithmException {

        String username = pizzaWorksRequest.getUsername();
        String hashedPassword = pizzaWorksRequest.getHashedPassword();
        if (loginService.isValidAdminUser(username, hashedPassword)) {
            request.session().attribute("loggedIn", true);
        }
    }

    private static Boolean adminValidCheck(PizzaWorksRequest pizzaWorksRequest) {
        System.out.println("Admin logged in: " + pizzaWorksRequest.isLoggedIn());
        return (pizzaWorksRequest.isLoggedIn());
    }

    private static String renderLoginPage() {
        Map<String, Object> model = new HashMap<>();
        return renderTemplate("velocity/login.vm", model);
    }

    private static String renderAdminPage() {
        Map<String, Object> model = new HashMap<>();
        return renderTemplate("velocity/admin.vm", model);
    }
}
