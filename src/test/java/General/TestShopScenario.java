package General;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Cinthya on 20-7-2017.
 */
public class TestShopScenario {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp(){


        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        //open the website
        driver.manage().window().maximize();
        driver.get("https://techblog.polteq.com/testshop/index.php");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
