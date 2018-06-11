package functional;

import config.DatabaseConfig;
import controllers.*;
import dal.LoginService;
import dal.OrderService;
import dal.PizzaService;
import database.DatabaseSetUp;
import spark.servlet.SparkApplication;

public class TestPizzaApplication implements SparkApplication {
    @Override
    public void init() {
        AdminController.initialize(new PizzaService(DatabaseSetUp.sql2oFromDataBase(getPizzaTestConfig())));
        PizzaController.initialize(new PizzaService(DatabaseSetUp.sql2oFromDataBase(getPizzaTestConfig())));
        LoginController.initialize(new LoginService(DatabaseSetUp.sql2oFromDataBase(getPizzaTestConfig())));
        CheckoutController.initialize(new PizzaService(DatabaseSetUp.sql2oFromDataBase(getPizzaTestConfig())));
        ConfirmationController.initialize(new OrderService(DatabaseSetUp.sql2oFromDataBase(getPizzaTestConfig())),new PizzaService(DatabaseSetUp.sql2oFromDataBase(getPizzaTestConfig())));
    }

    public static DatabaseConfig getPizzaTestConfig() {
        return new DatabaseConfig("localhost", "5434", "superpizza", "pizzaworks", "password");
    }
}
