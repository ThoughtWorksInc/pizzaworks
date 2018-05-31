package domain;

import spark.Request;

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
}
