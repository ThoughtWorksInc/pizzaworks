import controllers.CheckoutController;
import controllers.ConfirmationController;
import controllers.LoginController;
import controllers.PizzaController;
import dal.OrderService;
import dal.PizzaService;
import database.DatabaseSetUp;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(getAssignedPort());
        exception(Exception.class, (e, req, res) -> e.printStackTrace()); // print all exceptions
        staticFiles.location("/public");

        PizzaController.initialize(new PizzaService(DatabaseSetUp.sql2oFromDataBase()));
        LoginController.initialize();
        CheckoutController.initialize(new PizzaService(DatabaseSetUp.sql2oFromDataBase()));
        ConfirmationController.initialize(new OrderService(DatabaseSetUp.sql2oFromDataBase()), new PizzaService(DatabaseSetUp.sql2oFromDataBase()));
    }

    static int getAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }


}
