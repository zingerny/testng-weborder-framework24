package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTest extends TestBase{

    @Test
    public void positiveLogin() {
    driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
    String username = "Tester";
    String passcode = "test";
    driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, passcode,Keys.ENTER);

        Assert.assertTrue(driver.getPageSource().contains("Web Orders"));
    }

    @Test
    public void negativeLoginInvalidUsername() {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        String username = "Invalid";
        String passcode = "test";
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, passcode,Keys.ENTER);

        Assert.assertNotEquals(driver.getCurrentUrl(),"http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
    }

    @Test
    public void negativeLoginInvalidPassword() {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        String username = "Tester";
        String passcode = "invalid";
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, passcode,Keys.ENTER);

        Assert.assertNotEquals(driver.getCurrentUrl(),"http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
    }
}
