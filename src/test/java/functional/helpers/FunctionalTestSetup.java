package functional.helpers;

import com.despegar.sparkjava.test.SparkServer;
import functional.TestPizzaApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class FunctionalTestSetup {

    public WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "./lib/geckodriver");
        System.setProperty("env", "test");
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:4568");
    }

    @ClassRule
    public static SparkServer<TestPizzaApplication> testServer = new SparkServer<>(TestPizzaApplication.class, 4568);

    @ClassRule
    public static DatabaseSetupRule databaseSetupRule = new DatabaseSetupRule();

    @After
    public void tearDown() throws Exception {
        driver.close();

    }




}
