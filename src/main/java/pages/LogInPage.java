package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Cinthya on 27-7-2017.
 */
public class LogInPage {

    private WebDriver driver;

    @FindBy(css = "#email")
    private WebElement emailTextField;

    @FindBy(css = "#passwd")
    private WebElement passwordTextField;

    @FindBy(css = "button#SubmitLogin")
    private WebElement sendButton;

    @FindBy(className = "page-heading")
    private WebElement succesMessage;

    public LogInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logIn(String email, String passwd){
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(passwd);
        sendButton.click();
    }
    public String getAlertMessage(){
        return succesMessage.getText();
    }
}

