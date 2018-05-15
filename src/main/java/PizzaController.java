import dal.PizzaService;
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
    public static void initialize() {
        get("/", (req, res) -> renderPizzas());

        after((req, res) -> {
            if (res.body() == null) { // if the route didn't return anything
                res.body(renderPizzas());
            }
        });
    }

    private static String renderPizzas() {
        Map<String, Object> model = new HashMap<>();
        model.put("pizzas", new PizzaService(sql2oFromEnvVars()).getAllPizzas());

        return renderTemplate("velocity/index.vm", model);
    }

    private static Sql2o sql2oFromEnvVars() {
        String host = System.getenv("PGHOST");
        String port = System.getenv("PGPORT");
        String user = System.getenv("PGUSER");
        String databaseName = System.getenv("PGDATABASE");
        String password = System.getenv("PGPW");

        return new Sql2o("jdbc:postgresql://" + host + ":" + port + "/" + databaseName + "",
                user, password, new PostgresQuirks() {
            {
                // make sure we use default UUID converter.
                converters.put(UUID.class, new UUIDConverter());
            }
        });
    }

    private static String renderTemplate(String template, Map model) {
        return new VelocityTemplateEngine().render(new ModelAndView(model, template));
    }
}
