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
        driver.get("http://localhost:4568/checkout");
        assertThat(driver.getCurrentUrl(), is("http://localhost:4568/checkout"));
        assertThat(driver.findElement(By.className("order-details")).getText(), is("Veggie"));
    }


}
