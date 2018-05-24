package controllers;

import config.DatabaseConfig;
import dal.PizzaService;
import org.apache.velocity.app.VelocityEngine;
import org.sql2o.Sql2o;
import org.sql2o.converters.UUIDConverter;
import org.sql2o.quirks.PostgresQuirks;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static spark.Spark.after;
import static spark.Spark.get;

public class PizzaController {
    private static DatabaseConfig databaseConfig;

    public static void initialize(DatabaseConfig databaseConfig) {
        PizzaController.databaseConfig = databaseConfig;
        get("/", (req, res) -> renderPizzas());
        get("/pizza/:pizzaslug", (req, res) -> renderChosenPizza());

        after((req, res) -> {
            if (res.body() == null) { // if the route didn't return anything
                res.body(renderPizzas());
            }
        });
    }

    private static String renderChosenPizza() {
        Map<String, Object> model = new HashMap<>();

        return renderTemplate("velocity/chosenPizza.vm", model);
    }

    private static String renderPizzas() {
        Map<String, Object> model = new HashMap<>();
        model.put("pizzas", new PizzaService(sql2oFromEnvVars()).getAllPizzas());

        return renderTemplate("velocity/pizzaList.vm", model);
    }

    private static Sql2o sql2oFromEnvVars() {
        return new Sql2o("jdbc:postgresql://" + databaseConfig.getHost() + ":" + databaseConfig.getPort() + "/" + databaseConfig.getDatabaseName() + "",
                databaseConfig.getUser(), databaseConfig.getPassword(), new PostgresQuirks() {
            {
                // make sure we use default UUID converter.
                converters.put(UUID.class, new UUIDConverter());            }
        });
    }

    private static String renderTemplate(String template, Map model) {
        model.put("template", template);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "velocity/index.vm"));
    }
}
