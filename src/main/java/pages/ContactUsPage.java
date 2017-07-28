package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Cinthya on 21-7-2017.
 */
public class ContactUsPage {

    private WebDriver driver;

    @FindBy(css = "#email")
    private WebElement emailTextField;

    @FindBy(css = "#id_order")
    private WebElement orderReferenceTextField;

    @FindBy(css = "#message")
    private WebElement messageTextField;

    @FindBy(css = "button#submitMessage")
    private WebElement sendButton;

    @FindBy(xpath = ".//p[@class='alert alert-succes']")
    private WebElement succesMessage;

    @FindBy(css = ".alert.alert-danger>ol>li")
    private WebElement notSuccesMessage;


        public ContactUsPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillInContactForm(String email, String orderReference, String message){
        Select subjectHeading = new Select (driver.findElement(By.cssSelector("select#id_contact")));
        subjectHeading.selectByVisibleText("Customer service");

        emailTextField.sendKeys(email);
        orderReferenceTextField.sendKeys(orderReference);
        messageTextField.sendKeys(message);
        sendButton.click();
    }
    public String getAlertMessage(){
        return succesMessage.getText();
    }
    public String getAlertNotSuccesMessage(){
        return notSuccesMessage.getText();
    }
}
