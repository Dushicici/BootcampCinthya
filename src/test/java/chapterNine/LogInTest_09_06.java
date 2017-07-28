package chapterNine;

import General.TestShopScenario;
import browserDriven.TestShopScenarioBrowserDriven;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

/**
 * Created by Cinthya on 27-7-2017.
 */
public class LogInTest_09_06 extends TestShopScenarioBrowserDriven {

    @Parameters({"email", "passwd"})
    @Test
    public void logIn(String email, String passwd){
        //driver.findElement(By.className("login")).click();
        HomePage homePage = new HomePage(driver);
        if (!homePage.logInButtonDisplayed()){
            homePage.clickLogOut();
        }
        homePage.clickLogIn();

        LogInPage loginPage = new LogInPage(driver);
        loginPage.logIn(email, passwd);

        Assertions.assertThat(loginPage.getAlertMessage()).as("Header when logged in").
                isEqualTo("MY ACCOUNT");
    }
}