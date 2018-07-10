package functional;

import functional.helpers.FunctionalTestSetup;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AdminPageTest  extends FunctionalTestSetup {

    @Test
    public void shouldBeAbleToNavigateToAdminPage() {
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/"));
        driver.findElement(By.linkText("Login")).click();
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/login"));

        driver.findElement(By.name("username")).sendKeys("Admin1");
        driver.findElement(By.name("password")).sendKeys("pass123");
        driver.findElement(By.id("login-button")).click();

        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/admin"));
        WebElement createButton = driver.findElement(By.id("addPizza"));
        createButton.click();
        driver.findElement(By.name("pizzaname")).sendKeys("dsada");
        driver.findElement(By.name("pizzaprice")).sendKeys("8.00");
        driver.findElement(By.name("pizzaingredients")).sendKeys("xyz");
        driver.findElement(By.name("pizzaslug")).sendKeys("xyz");
        driver.findElement(By.name("pizzaweight")).sendKeys("125");
        driver.findElement(By.name("pizzaslice")).sendKeys("6");
        driver.findElement(By.name("energy")).sendKeys("1");
        driver.findElement(By.name("protein")).sendKeys("1");
        driver.findElement(By.name("carbs")).sendKeys("1");
        driver.findElement(By.name("sugars")).sendKeys("1");
        driver.findElement(By.name("fat")).sendKeys("1");
        driver.findElement(By.name("saturatedfat")).sendKeys("1");
        driver.findElement(By.name("salt")).sendKeys("1");
        driver.findElement(By.name("energy100")).sendKeys("1");
        driver.findElement(By.name("protein100")).sendKeys("1");
        driver.findElement(By.name("carbs100")).sendKeys("1");
        driver.findElement(By.name("sugars100")).sendKeys("1");
        driver.findElement(By.name("fat100")).sendKeys("1");
        driver.findElement(By.name("saturatedfat100")).sendKeys("1");
        driver.findElement(By.name("salt100")).sendKeys("1");



        WebElement checkbox = driver.findElement(By.id("gluten"));
        checkbox.click();
        WebElement checkbox1 = driver.findElement(By.id("mollsc"));
        checkbox1.click();
        assertTrue(checkbox.isSelected());
        assertTrue(checkbox1.isSelected());
        WebElement vegetarian = driver.findElement(By.id("myonoffswitch"));
        WebElement vegan = driver.findElement(By.id("myonoffswitch1"));
        vegetarian.click();
        vegan.click();
        assertTrue(vegan.isSelected());
        assertTrue(vegetarian.isSelected());
        WebElement saveButton =  driver.findElement(By.id("submit-pizza-button"));
        saveButton.click();
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/admin"));
        driver.findElement(By.linkText("Veggie")).click();
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/pizza/veggie"));

    }

}
