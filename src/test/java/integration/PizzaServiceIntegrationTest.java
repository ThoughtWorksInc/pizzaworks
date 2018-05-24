package integration;

import dal.PizzaService;
import model.Pizza;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;
import org.sql2o.converters.UUIDConverter;
import org.sql2o.quirks.PostgresQuirks;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static ru.yandex.qatools.embed.postgresql.distribution.Version.Main.V10;

public class PizzaServiceIntegrationTest {
    private String host = "localhost";
    private String port = "5434";
    private String user = "superpizza";
    private String databaseName = "pizzaworks";
    private String password = "password";

    private EmbeddedPostgres postgres;
    private Connection conn;
    private PizzaService pizzaService;

    @Before
    public void setUp() throws Exception {
        postgres = new EmbeddedPostgres(V10);
        String url = postgres.start(host, Integer.parseInt(port), databaseName, user, password);

        conn = DriverManager.getConnection(url);

        ProcessBuilder pb = new ProcessBuilder("./db-scripts/migrate.sh");
        Map<String, String> env = pb.environment();
        env.put("PGHOST", host);
        env.put("PGPORT", port);
        env.put("PGUSER", user);
        env.put("PGDATABASE", databaseName);
        env.put("PGPW", password);

        File directory = new File(".");
        pb.directory(directory);
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        Process p = pb.start();
        p.waitFor();


        Sql2o sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + "/" + databaseName + "",
                user, password, new PostgresQuirks() {
            {
                // make sure we use default UUID converter.
                converters.put(UUID.class, new UUIDConverter());
            }
        });

        pizzaService = new PizzaService(sql2o);
    }


    @Test
    public void shouldRetrievePizzas() throws Exception {

        List<Pizza> allPizzas = pizzaService.getAllPizzas();
        assertThat(allPizzas.size(), is(4));

        Pizza veggiePizza = getPizzaByName(allPizzas, "Veggie");
        Pizza pepperoniPizza = getPizzaByName(allPizzas, "Pepperoni feast");

        assertThat(veggiePizza.getName(), is("Veggie"));
        assertThat(veggiePizza.getSlug(), is("veggie"));
        assertThat(veggiePizza.getIngredients(), is("Pizza sauce, vegan alternative to cheese, spinach, sweetcorn, mixed peppers, red onion, mushrooms"));
        assertThat(veggiePizza.getPrice(), is(12.99F));

        assertThat(pepperoniPizza.getName(), is("Pepperoni feast"));
        assertThat(pepperoniPizza.getSlug(), is("pepperoni-feast"));
        assertThat(pepperoniPizza.getIngredients(), is("Pizza sauce, mozzarella cheese, pepperoni"));
        assertThat(pepperoniPizza.getPrice(), is(13.99F));
    }

    @Test
    public void shouldRRetrievePizzaBySlug() {
        Pizza veggie = pizzaService.getPizzaBySlug("veggie");
        assertThat((veggie.getName()), is("Veggie"));

    }

    private Pizza getPizzaByName(List<Pizza> allPizzas, String pizzaName) {
        return allPizzas.stream()
                .filter(pizza -> pizza.getName().equals(pizzaName))
                .findFirst().get();
    }

    @After
    public void tearDown() throws Exception {
        // close db connection
        conn.close();
        // stop Postgres
        postgres.stop();
    }
}
