package chapterSix;

import General.TestShopScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import General.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * Created by Cinthya on 24-7-2017.
 */
public class ValidateSupplierProductTest extends TestShopScenario {

    @Test
    public void validateSupplierProduct() {

        Select dropdown = new Select(driver.findElement(By.cssSelector("select[name='supplier_list']")));
        dropdown.selectByVisibleText("AppleStore");

        List<WebElement> supplierProducts = driver.findElements(By.cssSelector("h5[itemprop='name']>a"));

        //option
        Boolean macBookFound = false;
        for (int i = 0; i < supplierProducts.size(); i++) {
            if (supplierProducts.get(i).getText().equals("MacBook Air"))
            {
                macBookFound = true;
                break;
            }
        }
        Assertions.assertThat(macBookFound).as("Check if MacBook Air is in the list").isTrue();
    }
}
