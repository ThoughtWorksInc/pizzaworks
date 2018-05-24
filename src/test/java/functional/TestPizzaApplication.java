package functional;

import config.DatabaseConfig;
import controllers.PizzaController;
import dal.PizzaService;
import database.DatabaseSetUp;
import spark.servlet.SparkApplication;

public class TestPizzaApplication implements SparkApplication {
    @Override
    public void init() {
        PizzaController.initialize(new PizzaService(DatabaseSetUp.sql2oFromDataBase()));
    }

    public static DatabaseConfig getPizzaTestConfig() {
        return new DatabaseConfig("localhost", "5434", "superpizza", "pizzaworks", "password");
    }
}
