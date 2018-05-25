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

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static ru.yandex.qatools.embed.postgresql.distribution.Version.Main.V10;

public class LoginPageTest {

    private static EmbeddedPostgres postgres;
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "./lib/geckodriver");
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:4568");
    }

    @ClassRule
    public static SparkServer<TestPizzaApplication> testServer = new SparkServer<>(TestPizzaApplication.class, 4568);


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


    @AfterClass
    public static void afterAll() {
        postgres.stop();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void shouldBeAbleToNavigateToLoginPage() {
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/"));
        driver.findElement(By.linkText("Login")).click();
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/login"));

    }
}
