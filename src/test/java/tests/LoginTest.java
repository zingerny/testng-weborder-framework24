package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.ConfigReader;
import utility.Driver;

import java.io.IOException;
import java.time.Duration;

public class LoginTest extends TestBase{

    @Test
    public void positiveLogin()    {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"), Keys.TAB,ConfigReader.getProperty("password"),Keys.ENTER);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Web Orders"));
    }

    @Test
    public void negativeLoginInvalidUsername() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        String username = "Invalid";

        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, ConfigReader.getProperty("password"),Keys.ENTER);

        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(),"http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
    }

    @Test
    public void negativeLoginInvalidPassword() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        String passcode = "invalid";
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"), Keys.TAB, passcode,Keys.ENTER);

        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(),"http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
    }

@Test
public void negativeLoginNoPassword() {

    Driver.getDriver().get(ConfigReader.getProperty("url"));
    Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"), Keys.TAB, "",Keys.ENTER);

        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(),"http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
    }
}
