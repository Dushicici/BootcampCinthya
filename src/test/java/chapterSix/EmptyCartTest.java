package chapterSix;

import General.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by Cinthya on 24-7-2017.
 */
public class EmptyCartTest extends TestShopScenario {

    @Test
    public void fillCart () {
        WebDriverWait myWaitVar = new WebDriverWait((driver),20);

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("tester@test.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();

        //Verify cart is empty if so add product to cart
        if  (driver.findElement(By.className("ajax_cart_no_product")).isDisplayed()){
            //Click on Ipodtag
            driver.findElement(By.cssSelector("#tags_block_left > div > a.tag_level3.first_item")).click();
            //Click on Ipod shuffle
            driver.findElement(By.xpath("//a[contains(text(), 'iPod shuffle')]")).click();
            //Click on add to cart
            driver.findElement(By.id("add_to_cart")).click();
            //wait
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[title='Continue shopping']")));
            //Continue Shopping Button
            By.xpath("//span[contains(@title, 'Continue shopping')]").findElement(driver).click();
            //Verify card has 1 order
            String cardAmount = driver.findElement(By.cssSelector("span.ajax_cart_quantity")).
                    getText();
            Assertions.assertThat(cardAmount).as("Quantity of Card").isEqualTo("1");
        }
        //click the cartButton
        //Overlay is blocking the cart button
        myWaitVar.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".shopping_cart>a"))).click();

        //click the trash icon
        driver.findElement(By.className("icon-trash")).click();

        //after clicking trash icon site needs time to delete wetable and show empty card message
        String emptyCardMessage = myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                (".alert.alert-warning"))).getText();

        //assert card is empty
        Assertions.assertThat(emptyCardMessage).as("Validate empty card message appears").
                isEqualTo("Your shopping cart is empty.");


    }
}
