package chapterNine;

import General.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

/**
 * Created by Cinthya on 27-7-2017.
 */
public class NOK2_FillInContactFormTest extends TestShopScenario {
    @Test
    public void nok2ContactForm() {
        //driver.findElement(By.className("login")).click();
        HomePage homePage = new HomePage(driver);
        if (!homePage.logInButtonDisplayed()) {
            homePage.clickLogOut();

            //driver.findElement(By.cssSelector("li#header_link_contact > a")).click();
            homePage.clickContactUs();

            ContactUsPage contactUsPage = new ContactUsPage(driver);
            contactUsPage.fillInContactForm("nope", "4321234", "HELP!");

            //Assert e-mail format is not correct
            Assertions.assertThat(contactUsPage.getAlertMessage()).as("Error Message").
                    isEqualTo("Invalid email address.");
        }
    }
}
