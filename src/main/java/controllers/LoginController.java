package controllers;

import dal.LoginService;
import domain.PizzaWorksRequest;
import spark.Request;
import spark.Response;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static util.TemplateHelper.renderTemplate;

public class LoginController {
    private static LoginService loginService;

    public static void initialize(LoginService loginService) {
        LoginController.loginService = loginService;

        get("/login", (req, res) -> renderLoginPage(false));
        post("/login", (req, res) -> {
            PizzaWorksRequest pizzaWorksRequest = new PizzaWorksRequest(req);
            processLogin(req, pizzaWorksRequest);

            return pizzaWorksRequest.isLoggedIn() ? redirectToAdmin(res) : renderLoginPage(true);
        });
    }

    private static Response redirectToAdmin(Response res) {
        res.redirect("/admin");
        return res;
    }

    private static void processLogin(Request request, PizzaWorksRequest pizzaWorksRequest) throws NoSuchAlgorithmException {

        String username = pizzaWorksRequest.getUsername();
        String hashedPassword = pizzaWorksRequest.getHashedPassword();
        if (loginService.isValidAdminUser(username, hashedPassword)) {
            request.session().attribute("loggedIn", true);
        }
    }

    private static String renderLoginPage(Boolean loginError) {
        Map<String, Object> model = new HashMap<>();
        model.put("loginError", loginError);
        return renderTemplate("velocity/login.vm", model);
    }

}
