import controllers.LoginController;
import controllers.OrderController;
import controllers.PizzaController;
import dal.LoginService;
import dal.PizzaService;
import database.DatabaseSetUp;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(getAssignedPort());
        exception(Exception.class, (e, req, res) -> e.printStackTrace()); // print all exceptions
        staticFiles.location("/public");

        PizzaController.initialize(new PizzaService(DatabaseSetUp.sql2oFromDataBase()));
        LoginController.initialize(new LoginService(DatabaseSetUp.sql2oFromDataBase()));
        OrderController.initialize();
    }

    static int getAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }


}
