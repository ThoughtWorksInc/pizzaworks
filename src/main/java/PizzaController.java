import model.Pizza;
import model.PizzaDao;
import spark.ModelAndView;
import spark.Request;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.after;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;

public class PizzaController {
    public static void initialize() {
        get("/", (req, res) -> renderPizzas(req));

        post("/pizzas", (req, res) -> {
            PizzaDao.add(Pizza.create(req.queryParams("pizza-name")));
            return renderPizzas(req);
        });

        delete("/pizzas", (req, res) -> {
            PizzaDao.clearPizzas();
            return renderPizzas(req);
        });

        delete("/pizzas/:id", (req, res) -> {
            PizzaDao.remove(req.params("id"));
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
        model.put("pizzas", PizzaDao.all());
        model.put("count", PizzaDao.count());
        if ("true".equals(req.queryParams("ic-request"))) {
            return renderTemplate("velocity/pizzaList.vm", model);
        }
        return renderTemplate("velocity/index.vm", model);
    }

    private static String renderTemplate(String template, Map model) {
        return new VelocityTemplateEngine().render(new ModelAndView(model, template));
    }
}
