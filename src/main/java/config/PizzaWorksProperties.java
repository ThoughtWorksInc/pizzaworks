package config;

import java.util.Properties;

public class PizzaWorksProperties {
    private final boolean loginToggle;
    private final String environment;

    public PizzaWorksProperties(Properties properties) {
        this.environment = properties.getProperty("env");
        this.loginToggle = Boolean.parseBoolean(properties.getProperty("loginToggle"));
    }

    public String getEnvironment() {
        return environment;
    }

    public boolean getLoginToggle() {
        return loginToggle;
    }
}
