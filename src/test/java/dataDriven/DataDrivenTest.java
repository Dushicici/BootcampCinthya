package dataDriven;

import General.TestShopScenario;
import browserDriven.TestShopScenarioBrowserDriven;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

/**
 * Created by Cinthya on 21-7-2017.
 */
public class DataDrivenTest extends TestShopScenarioBrowserDriven {

    @Parameters({"email", "orderID", "message"})
    @Test
    public void fillInContactForm(String email, String orderID, String message){
        //driver.findElement(By.cssSelector("li#header_link_contact > a")).click();
        HomePage homePage = new HomePage(driver);
        homePage.clickContactUs();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInContactForm(email, orderID, message);

        Assertions.assertThat(contactUsPage.getAlertMessage()).as("Succes message contact form").
                isEqualTo("Your message has been successfully sent to our team.");
    }
}
