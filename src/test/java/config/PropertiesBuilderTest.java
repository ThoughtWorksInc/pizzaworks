package config;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PropertiesBuilderTest {

    @Test
    public void shouldReadPropertiesFileForDevEnvironment() throws Exception {
        System.setProperty("env", "local");

        PizzaWorksProperties properties = PropertiesBuilder.load();

        assertThat(properties.getEnvironment(), is("local"));
    }

    @Test
    public void shouldReadPropertiesFileForProdEnvironment() throws Exception {
        System.setProperty("env", "prod");

        PizzaWorksProperties properties = PropertiesBuilder.load();

        assertThat(properties.getEnvironment(), is("prod"));
    }

}