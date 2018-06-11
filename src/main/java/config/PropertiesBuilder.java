package config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class PropertiesBuilder {

    //    todo default to prod instead when working
    private static final String DEFAULT_ENVIRONMENT = "local";

    private static Properties read(String propertiesFileName) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("./properties/" + propertiesFileName + ".properties"));
        return properties;
    }

    public static PizzaWorksProperties load() {
        try {
            Optional<String> optionalEnvironment = Optional.ofNullable(System.getProperty("env"));
            String propertiesFileName = optionalEnvironment.orElse(DEFAULT_ENVIRONMENT);
            return new PizzaWorksProperties(read(propertiesFileName));
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties file", e);
        }
    }
}
