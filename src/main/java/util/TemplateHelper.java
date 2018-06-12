package util;

import config.PropertiesBuilder;
import domain.PizzaWorksRequest;
import spark.ModelAndView;
import spark.Request;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Map;

public class TemplateHelper {
    public static String renderTemplate(String template, Map model, Request request) {
        PizzaWorksRequest pizzaWorksRequest = new PizzaWorksRequest(request);

        model.put("template", template);
        model.put("loggedIn", pizzaWorksRequest.isLoggedIn());
        model.put("properties", PropertiesBuilder.load());

        return new VelocityTemplateEngine().render(new ModelAndView(model, "velocity/index.vm"));
    }
}
