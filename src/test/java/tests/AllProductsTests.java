package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AllProductsTests extends TestBase {

    @Test
    public void verifyTitle() {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        String username = "Tester";
        String passcode = "test";
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, passcode,Keys.ENTER);

        driver.findElement(By.linkText("View all products")).click();
        WebElement element = driver.findElement(By.tagName("h2"));
        Assert.assertTrue(element.isDisplayed());
    }




}
