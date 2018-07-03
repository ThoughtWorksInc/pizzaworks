package functional;

import functional.helpers.FunctionalTestSetup;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LoginPageTest extends FunctionalTestSetup {

    @Test
    public void shouldBeAbleToLoginAndNavigateToAdminPage() {
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/"));
        driver.findElement(By.linkText("Login")).click();
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/login"));

        driver.findElement(By.name("username")).sendKeys("Admin1");
        driver.findElement(By.name("password")).sendKeys("pass123");
        driver.findElement(By.id("login-button")).click();

        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/admin"));
        assertThat(driver.findElement(By.className("title")).getText(), is("Welcome Admin!"));
    }

    @Test
    public void shouldReturnToLoginPageIfNotLoggedIn() throws InterruptedException {
        driver.get("http://localhost:4568/admin");
        sleep(2000);
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/login"));

    }

    @Test
    public void shouldNotLoginIfPasswordOrUsernameIsIncorrect() {
        driver.findElement(By.linkText("Login")).click();
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/login"));
        driver.findElement(By.name("username")).sendKeys("username");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.id("login-button")).click();
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/login"));
        assertThat(driver.findElement(By.className("errorMessage")).getText(), is("Please enter a correct username and password"));

    }
    @Test
    public void shouldBeAbleToNavigateToAdminPageWithCreatePizzaForm() {
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/"));
        driver.findElement(By.linkText("Login")).click();
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/login"));

        driver.findElement(By.name("username")).sendKeys("Admin1");
        driver.findElement(By.name("password")).sendKeys("pass123");
        driver.findElement(By.id("login-button")).click();

        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/admin"));
        WebElement createButton = driver.findElement(By.id("addPizza"));
        createButton.click();
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/admin"));
        assertThat(driver.findElement(By.className("createpizza")).getText(), is("Create a pizza:"));

    }


}
