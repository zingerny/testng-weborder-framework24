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
import utility.Driver;

import java.time.Duration;

public class AllOrdersTest extends TestBase{



    @Test
    public void verifyDeleteSelectedButton() {
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        String username = "Tester";
        String passcode = "test";
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, passcode,Keys.ENTER);
        WebElement element = Driver.getDriver().findElement(By.name("ctl00$MainContent$btnDelete"));
        Assert.assertTrue(element.isDisplayed());
    }

    @Test
    public void verifyCheckAllButton() {
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        String username = "Tester";
        String passcode = "test";
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, passcode,Keys.ENTER);
        WebElement element = Driver.getDriver().findElement(By.id("ctl00_MainContent_btnCheckAll"));
        Assert.assertTrue(element.isDisplayed());

    }

    @Test
    public void verifyUncheckAllButton() {
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        String username = "Tester";
        String passcode = "test";
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, passcode,Keys.ENTER);
        WebElement element = Driver.getDriver().findElement(By.id("ctl00_MainContent_btnUncheckAll"));
        Assert.assertTrue(element.isDisplayed());
    }


}
