package chapterSix;

import org.testng.annotations.Test;
import General.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

/**
 * Created by Cinthya on 24-7-2017.
 */
public class AdjustPersonalInfoTest extends TestShopScenario {

    @Test
    public void changePersonalInfo() {

        //Check if a user is logged in
        //if no user is logged in, log in a user
        if (driver.findElement(By.className("login")).isDisplayed()) {
            driver.findElement(By.className("login")).click();
            driver.findElement(By.id("email")).sendKeys("cinthya.poulina@polteq.com");
            driver.findElement(By.id("passwd")).sendKeys("maestrodiamor");
            driver.findElement(By.id("SubmitLogin")).click();
            //Click on the my personal info icon
            driver.findElement(By.className("icon-user")).click();
        } else {
            //Go to the users customer account
            //Click on the my personal info icon
            driver.findElement(By.className("account")).click();
            driver.findElement(By.className("icon-user")).click();
        }
        //go to my personal informatiom
        driver.findElement(By.className("account")).click();
        driver.findElement(By.className("icon-user")).click();

        //change current name
        String currentFirstname = driver.findElement(By.id("firstname")).getAttribute("value");
        System.out.println(currentFirstname);
        String changedName;
        if (currentFirstname.equals("Cinthya")) {
            driver.findElement(By.id("firstname")).clear();
            driver.findElement(By.id("firstname")).sendKeys("Cici");
            changedName = "Cici";
        } else if (currentFirstname.equals("Cici")) {
            driver.findElement(By.id("firstname")).clear();
            driver.findElement(By.id("firstname")).sendKeys("Cinthya");
            changedName = "Cinthya";
        } else {
            driver.findElement(By.id("firstname")).clear();
            driver.findElement(By.id("firstname")).sendKeys("Cinthya");
            changedName = "Cinthya";
        }

        driver.findElement(By.id("old_passwd")).sendKeys("maestrodiamor");
        driver.findElement(By.cssSelector("button[name='submitIdentity']")).click();

        //Check if succesmessage pesonal info appears
        Assertions.assertThat(driver.findElement(By.xpath(".//*[@id='center_column']/div/p")).getText()).
                as("Validate if succes message apears").
                isEqualTo("Your personal information has been successfully updated.");

        driver.findElement(By.cssSelector(".account>span")).click();

        //Click the personal info Icon
        driver.findElement(By.className("icon-user")).click();

        //Check the new name
        System.out.println(driver.findElement(By.id("firstname")).getAttribute("Value"));

        Assertions.assertThat(driver.findElement(By.id("firstname")).getAttribute("Value")).as
                ("Validate name change").isEqualTo(changedName);
    }
}