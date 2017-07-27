package homework;

import General.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Cinthya on 22-7-2017.
 */
public class DeleteWishListTest extends TestShopScenario {

    @Test
    public void DeleteWish() {
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("cinthya@poulina.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();

        //Go to wishlist and ssert your are on the right page
        driver.findElement(By.xpath(".//*[@id='wishlist_block']/h4/a")).click();
        Assertions.assertThat(driver.findElement(By.className("page-heading")).getText()).isEqualTo("MY WISHLISTS");

        //Define how many rows by being dynamic
        WebElement table = driver.findElement(By.xpath(".//*[@id='block-history']/table/tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));


        //First loop will find the 'Feel the pain' in the first column and delete it
        for (WebElement row : rows) {
            if (row.getText().contains("Feel the pain")) {
                System.out.println("Feel the pain is found");
                row.findElement(By.cssSelector(".wishlist_delete i")).click();
                break;
            }
        }
        //Accept the alert pop up
        try {
            //wait 10 seconds till alert is present
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Accepted the alert succesfully");
        }
        catch (Throwable e){
            System.err.println("Error came while waiting for the alert pop-up ." + e.getMessage());
        }

            String listToDelete = "Feel the pain";
            wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement
                    (table, listToDelete)));
              table = driver.findElement(By.xpath(".//*[@id='block-history']/table/tbody"));
//            wishListTable = driver.findElement(By.cssSelector(".table.table-bordered"));
//            rowsInTable = wishListTable.findelements(By.tagName("tr"));

            //Assertion that feel the pain is no longer in the Wishlist
            //Assertions.assertThat(row.getText()).doesNotContain("Feel the pain");
            Assertions.assertThat(driver.findElements(By.xpath("//tbody//td//a[contains(text(),'Feel the pain')]"))).
                    size().isEqualTo(0);
//
            // Insert Feel the pain back into the wishlist
            driver.findElement(By.id("name")).sendKeys("Feel the pain");
            driver.findElement(By.id("submitWishlist")).click();

            //Assertion that feel the pain is in the Wishlist
//            Assertions.assertThat(row.getText()).contains("Feel the pain");
              Assertions.assertThat(driver.findElements(By.xpath("//tbody//td//a[contains(text(),'Feel the pain')]"))).
                      size().isEqualTo(1);



    }
}

