package util;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Map;

public class TemplateHelper {
    public static String renderTemplate(String template, Map model) {
        model.put("template", template);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "velocity/index.vm"));
    }
}
