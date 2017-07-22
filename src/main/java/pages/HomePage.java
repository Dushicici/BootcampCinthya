package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Cinthya on 21-7-2017.
 */
public class HomePage {

    private WebDriver driver;

    @FindBy(css = "#contact-link")
    private WebElement contactUsButton;

    public HomePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickContactUs(){

        contactUsButton.click();
    }
}
