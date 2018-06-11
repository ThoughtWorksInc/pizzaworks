package functional;

import functional.helpers.FunctionalTestSetup;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class OrderPizzaJourneyTest extends FunctionalTestSetup {

    @Test
    public void shouldBeAbleToOrderAPizzaAndSeeConfirmation() throws InterruptedException {
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/"));
        WebElement veggieOrderButton = driver.findElement(By.id("order-veggie"));
        veggieOrderButton.click();
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/checkout/veggie"));
        assertThat(driver.findElement(By.id("name")).getText(), is("Veggie"));
        assertThat(driver.findElement(By.id("price")).getText(), is("£12.99"));

        WebElement submitOrderButton = driver.findElement(By.id("submit-order-button"));
        submitOrderButton.click();
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/confirmation"));
        assertThat(driver.findElement(By.id("confirmed-pizza-name")).getText(), is("Veggie"));
        assertThat(driver.findElement(By.id("confirmed-pizza-price")).getText(), is("£12.99"));
    }

    @Test
    public void shouldBeAbleToNavigateToHomePageIfWeCancelAtCheckout() throws InterruptedException {
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/"));
        WebElement veggieOrderButton = driver.findElement(By.id("order-veggie"));
        veggieOrderButton.click();
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/checkout/veggie"));
        WebElement cancelOrderButton = driver.findElement(By.id("cancel-order-button"));
        cancelOrderButton.click();
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/"));

        List<WebElement> pizzaElements = driver.findElements(By.className("pizza"));
        Optional<WebElement> margheritaListElement = pizzaElements.stream()
                .filter(pizzaElement -> pizzaElement.findElement(By.cssSelector("a")).getText().equals("Margherita"))
                .findFirst();
        assertTrue(margheritaListElement.isPresent());

    }


}
