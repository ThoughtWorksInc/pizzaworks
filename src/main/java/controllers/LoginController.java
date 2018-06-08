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
        get("/admin", (req, res) -> renderAdminPage());
        post("/login", (req, res) -> {
            System.out.println("*****" + req.body());
            return renderAdminPage();
        });

        before("/admin", (req, res) -> {
            System.out.println("*****" + req.body());
            PizzaWorksRequest pizzaWorksRequest = new PizzaWorksRequest(req);
            processLogin(req, res, pizzaWorksRequest);
        });
    }

    private static void processLogin(Request request, Response response, PizzaWorksRequest pizzaWorksRequest) throws NoSuchAlgorithmException {

        System.out.println("IS LOGGED IN BEFORE? " + pizzaWorksRequest.isLoggedIn());

        String username = pizzaWorksRequest.getUsername();
        String hashedPassword = pizzaWorksRequest.getHashedPassword();
        if (loginService.isValidAdminUser(username, hashedPassword)) {
            System.out.println(pizzaWorksRequest.getUsername());
            request.session().attribute("loggedIn", true);
        }
        System.out.println("IS LOGGED IN AFTER? " + pizzaWorksRequest.isLoggedIn());
        if (pizzaWorksRequest.isLoggedIn()) {
            System.out.println("IS LOGGED IN IN IF? " + pizzaWorksRequest.isLoggedIn());
            response.redirect("/admin", 301);
        } else {
            response.redirect("/login", 301);
        }
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
