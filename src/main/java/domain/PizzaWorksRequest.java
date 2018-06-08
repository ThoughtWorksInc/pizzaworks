package domain;

import password.Password;
import spark.Request;

import java.security.NoSuchAlgorithmException;

public class PizzaWorksRequest {
    private Request req;

    public PizzaWorksRequest(Request req) {
        this.req = req;
    }

    public boolean isLoggedIn() {
        if(req.session().attribute("loggedIn") != null)
            return true;

         else return false;
    }




    public String getUsername() {
        return req.params("username");
    }

    public String getHashedPassword() throws NoSuchAlgorithmException {
        String password = req.params("password");
        return Password.hashAndSalt(password);
    }
}
