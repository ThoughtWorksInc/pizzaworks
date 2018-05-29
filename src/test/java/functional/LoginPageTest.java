package functional;

import functional.helpers.ServerSetup;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LoginPageTest extends ServerSetup {

    @Test
    public void shouldBeAbleToLoginAndNavigateToAdminPage() {
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/"));
        driver.findElement(By.linkText("Login")).click();
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/login"));

        driver.findElement(By.name("username")).sendKeys("username");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.id("login-button")).click();
        assertThat(driver.findElement(By.className("title")).getText(), is("Welcome Admin!"));
    }




};
