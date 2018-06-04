package functional;

import functional.helpers.FunctionalTestSetup;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        assertThat(driver.findElement(By.id("price")).getText(), is("12.99"));
    }


}
