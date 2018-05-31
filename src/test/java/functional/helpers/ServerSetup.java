package functional.helpers;

import com.despegar.sparkjava.test.SparkServer;
import config.DatabaseConfig;
import functional.TestPizzaApplication;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static ru.yandex.qatools.embed.postgresql.distribution.Version.Main.V10;

public class ServerSetup {

    public WebDriver driver;
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


    @ClassRule
    public static SparkServer<TestPizzaApplication> testServer = new SparkServer<>(TestPizzaApplication.class, 4568);

    @AfterClass
    public static void afterAll() {
        postgres.stop();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();

    }




}
