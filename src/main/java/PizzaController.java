import dal.PizzaService;
import org.sql2o.Sql2o;
import org.sql2o.converters.UUIDConverter;
import org.sql2o.quirks.PostgresQuirks;
import spark.ModelAndView;
import spark.Request;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static spark.Spark.after;
import static spark.Spark.get;

public class PizzaController {
    public static void initialize() {
        get("/", (req, res) -> renderPizzas(req));

        after((req, res) -> {
            if (res.body() == null) { // if the route didn't return anything
                res.body(renderPizzas(req));
            }
        });
    }

    private static String renderPizzas(Request req) {
        Map<String, Object> model = new HashMap<>();
        String host = System.getenv("PGHOST");
        String port = System.getenv("PGPORT");
        String user = System.getenv("PGUSER");
        String databaseName = System.getenv("PGDATABASE");
        String password = System.getenv("PGPW");

        Sql2o sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + "/" + databaseName + "",
                user, password, new PostgresQuirks() {
            {
                // make sure we use default UUID converter.
                converters.put(UUID.class, new UUIDConverter());
            }
        });

        model.put("pizzas", new PizzaService(sql2o).getAllPizzas());

        return renderTemplate("velocity/index.vm", model);
    }

    private static String renderTemplate(String template, Map model) {
        return new VelocityTemplateEngine().render(new ModelAndView(model, template));
    }
}
