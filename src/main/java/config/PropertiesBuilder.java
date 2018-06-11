package config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesBuilder {

    private static Properties read(String environment) throws IOException {
//        todo throw properties missing exception?
        Properties properties = new Properties();
        properties.load(new FileReader("./properties/" + environment + ".properties"));
        return properties;
    }

    public static PizzaWorksProperties load() {
        try {
            return new PizzaWorksProperties(read(System.getProperty("env")));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load properties file");
        }
    }
}
