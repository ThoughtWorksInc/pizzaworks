package functional;

import config.DatabaseConfig;
import controllers.PizzaController;
import spark.servlet.SparkApplication;

public class TestPizzaApplication implements SparkApplication {
    @Override
    public void init() {
        PizzaController.initialize(getPizzaTestConfig());
    }

    public static DatabaseConfig getPizzaTestConfig() {
        return new DatabaseConfig("localhost", "5434", "superpizza", "pizzaworks", "password");
    }
}
