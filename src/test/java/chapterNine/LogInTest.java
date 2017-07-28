package chapterNine;

import General.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

/**
 * Created by Cinthya on 27-7-2017.
 */
public class LogInTest extends TestShopScenario {

    @Test
    public void logIn(){
        //driver.findElement(By.className("login")).click();
        HomePage homePage = new HomePage(driver);
        if (!homePage.logInButtonDisplayed()){
            homePage.clickLogOut();
        }
        homePage.clickLogIn();

        LogInPage loginPage = new LogInPage(driver);
        loginPage.logIn("bootcamper@feelthepain.com", "1qazxsw2");

        Assertions.assertThat(loginPage.getAlertMessage()).as("Header when logged in").
                isEqualTo("MY ACCOUNT");
    }
}