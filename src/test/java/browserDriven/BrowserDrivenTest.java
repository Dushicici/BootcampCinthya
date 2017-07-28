package browserDriven;

import General.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

/**
 * Created by Cinthya on 21-7-2017.
 */
public class BrowserDrivenTest extends TestShopScenarioBrowserDriven {

    @Test
    public void fillInContactForm(){
        //driver.findElement(By.cssSelector("li#header_link_contact > a")).click();
        HomePage homePage = new HomePage(driver);
        homePage.clickContactUs();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInContactForm("cinthya.poulina@polteq.com", "123564",
                "Doet het niet");

        Assertions.assertThat(contactUsPage.getAlertMessage()).as("Succes message contact form").
                isEqualTo("Your message has been successfully sent to our team.");
    }
}
