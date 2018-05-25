package functional;

import com.despegar.sparkjava.test.SparkServer;
import config.DatabaseConfig;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static ru.yandex.qatools.embed.postgresql.distribution.Version.Main.V10;

public class PizzaPageTest {

    private WebDriver driver;
    private static EmbeddedPostgres postgres;

    @BeforeClass
    public static void beforeAll() throws InterruptedException, IOException {
        postgres = new EmbeddedPostgres(V10);
        DatabaseConfig pizzaTestConfig = TestPizzaApplication.getPizzaTestConfig();
        postgres.start(pizzaTestConfig.getHost(), Integer.parseInt(pizzaTestConfig.getPort()), pizzaTestConfig.getDatabaseName(), pizzaTestConfig.getUser(), pizzaTestConfig.getPassword());

        ProcessBuilder pb = new ProcessBuilder("./db-scripts/migrate.sh");
        Map<String, String> env = pb.environment();
        env.put("PGHOST", pizzaTestConfig.getHost());
        env.put("PGPORT", pizzaTestConfig.getPort());
        env.put("PGUSER", pizzaTestConfig.getUser());
        env.put("PGDATABASE", pizzaTestConfig.getDatabaseName());
        env.put("PGPW", pizzaTestConfig.getPassword());

        File directory = new File(".");
        pb.directory(directory);
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        Process p = pb.start();
        p.waitFor();

    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "./lib/geckodriver");
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:4568");
    }


    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @AfterClass
    public static void afterAll() {
        postgres.stop();
    }

    @ClassRule
    public static SparkServer<TestPizzaApplication> testServer = new SparkServer<>(TestPizzaApplication.class, 4568);


    @Test
    public void shouldBeAbleToNavigateToIndividualPizzaPage() {
        List<WebElement> pizzaElements = driver.findElements(By.className("pizza"));
        assertThat(pizzaElements.size(), is(4));
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/"));
        driver.findElement(By.linkText("Veggie")).click();
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/pizza/veggie"));

        assertThat(driver.findElement(By.className("pizza-title")).getText(), is("Veggie"));
        assertThat(driver.findElement(By.className("pizza-price")).getText(), is("£12.99"));
    }

    @Test
    public void shouldReturnPriceAndIngredientsForPizza() {
        List<WebElement> pizzaElements = driver.findElements(By.className("pizza"));
        Optional<WebElement> margheritaListElement = pizzaElements.stream()
                .filter(pizzaElement -> pizzaElement.findElement(By.cssSelector("a")).getText().equals("Margherita"))
                .findFirst();
        assertTrue(margheritaListElement.isPresent());

        WebElement ingredientsElement = margheritaListElement.get().findElement(By.className("ingredients"));
        assertEquals("Pizza sauce, mozzarella cheese", ingredientsElement.getText());

        WebElement priceElement = margheritaListElement.get().findElement(By.className("price"));
        assertEquals("£14.49", priceElement.getText());


    }

    @Test
    public void shouldShow404IfTriesToNavigateToPizzaThatDoesntExist() {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:4568/pizza/pizzathatdoesntexist");
        assertThat(driver.findElement(By.tagName("body")).getText(), is("Not found"));
    }

}
