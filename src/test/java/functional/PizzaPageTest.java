package functional;

import functional.helpers.FunctionalTestSetup;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PizzaPageTest extends FunctionalTestSetup {

    @Test
    public void shouldBeAbleToNavigateToIndividualPizzaPage() {
        List<WebElement> pizzaElements = driver.findElements(By.className("pizza"));
        assertThat(pizzaElements.size(), is(4));
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/"));
        driver.findElement(By.linkText("Veggie")).click();
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/pizza/veggie"));

        assertThat(driver.findElement(By.className("pizza-title")).getText(), is("Veggie"));
        assertThat(driver.findElement(By.className("pizza-num-slices")).getText(), is("6 slices"));
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
