package chapterNine;

import General.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.ContactUsPage;
import pages.HomePage;

/**
 * Created by Cinthya on 21-7-2017.
 */
public class FillInContactFomTest extends TestShopScenario {

    @Test
    public void fillInContactForm(){
        //driver.findElement(By.cssSelector("li#header_link_contact > a")).click();
        HomePage homePage = new HomePage(driver);
        homePage.clickContactUs();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInContactForm("cinthya.poulina@polteq.com", "123564",
                "Doet het niet");

        Assertions.assertThat(contactUsPage.getAlertMessage()).as("Succesmessage contact form").
                isEqualTo("Your message has been successfully sent to our team.");
    }
}
