package chapterSix;

import General.TestShopScenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

/**
 * Created by Cinthya on 20-7-2017.
 */
public class FillCartTest extends TestShopScenario {

    @Test
    public void fillCart (){
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("tester@test.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();

        //Verify cart is empty
        Assertions.assertThat(driver.findElement(By.className("ajax_cart_no_product")).isDisplayed()).
                as("Text empty should be displayed").isTrue();

        //Click on Ipod
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

        //Verify cart is empty
        Assertions.assertThat(driver.findElement(By.className("ajax_cart_no_product")).isDisplayed()).
                as("Text empty should be displayed").isTrue();
    }
}

