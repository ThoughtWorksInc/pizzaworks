import dal.Sql2oDatabaseModel;
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
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;

public class PizzaController {
    public static void initialize() {
        get("/", (req, res) -> renderPizzas(req));

        post("/pizzas", (req, res) -> {
//            PizzaDao.add(Pizza.create(req.queryParams("pizza-name")));
            return renderPizzas(req);
        });

        delete("/pizzas", (req, res) -> {
//            PizzaDao.clearPizzas();
            return renderPizzas(req);
        });

        delete("/pizzas/:id", (req, res) -> {
//            PizzaDao.remove(req.params("id"));
            return renderPizzas(req);
        });

        after((req, res) -> {
            if (res.body() == null) { // if the route didn't return anything
                res.body(renderPizzas(req));
            }
        });
    }

    private static String renderPizzas(Request req) {
        Map<String, Object> model = new HashMap<>();
        Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/pizzaworks",
                "superpizza", "bob", new PostgresQuirks() {
            {
                // make sure we use default UUID converter.
                converters.put(UUID.class, new UUIDConverter());
            }
        });

        model.put("pizzas", new Sql2oDatabaseModel(sql2o).getAllPizzas());

        return renderTemplate("velocity/index.vm", model);
    }

    private static String renderTemplate(String template, Map model) {
        return new VelocityTemplateEngine().render(new ModelAndView(model, template));
    }
}
