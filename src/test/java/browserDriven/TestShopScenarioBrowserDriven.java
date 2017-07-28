package browserDriven;

import browser.BrowserFactoryAdvanced;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * Created by Cinthya on 20-7-2017.
 */
public class TestShopScenarioBrowserDriven {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Parameters ("browser")
    @BeforeMethod
    public void setUp(BrowserFactoryAdvanced.BrowserType browser){

        //driver = BrowserFactoryBasic.getDriver("firefox");
        //driver = BrowserFactoryAdvanced.getDriver(BrowserFactoryAdvanced.BrowserType.CHROME);
        driver = BrowserFactoryAdvanced.getDriver(browser);
        wait = new WebDriverWait(driver, 20);

        //open the website
        //driver.manage().window().maximize();
        driver.get("https://techblog.polteq.com/testshop/index.php");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
