package browser;

import examples.EnumExample;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Cinthya on 27-7-2017.
 */
public class BrowserFactoryAdvanced {

    public enum BrowserType {
        FIREFOX, CHROME, INTERNETEXPLORER;

    }

    public static WebDriver getDriver(BrowserType browserType) {
        switch (browserType) {
            case FIREFOX:
                return createFireFoxDriver();
            case CHROME:
                return createChromeDriver();
            case INTERNETEXPLORER:
                return createInternetExplorerDriver();
            default:
                return createDefaultDriver();
        }
    }


    private static WebDriver createFireFoxDriver() {
        FirefoxDriverManager.getInstance().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    private static WebDriver createInternetExplorerDriver() {
        InternetExplorerDriverManager.getInstance().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    private static WebDriver createChromeDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //Chrome options are specific
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("Ignore-certificate-errors");
        //Capabilities can used for WebDriver capabilities ie: proxy
        capabilities.setCapability("chrome.switches", "--verbose");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver(capabilities);
    }

    private static WebDriver createDefaultDriver() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}

