package examples;

import General.TestShopScenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by Cinthya on 19-7-2017.
 */
public class FirstSeleniumTest extends TestShopScenario {

    @Test
    public void logInSuccesFull() {

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("tester@test.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();
        WebElement el = driver.findElement(By.className("info-account"));

        el.getText();
        Assertions.assertThat(el.getText()).as("welcome text").isEqualTo("Welcome to your account. Here you can " +
                "manage all of your personal information and orders.");
    }
}
