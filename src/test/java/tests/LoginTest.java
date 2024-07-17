package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import utility.ConfigReader;
import utility.Driver;

import java.io.IOException;
import java.time.Duration;

public class LoginTest extends TestBase{

    @Test
    public void positiveLogin()    {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    LoginPage loginPage= new LoginPage();
    loginPage.getUsernameField().sendKeys(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Web Orders"));
    }


    @Test
    public void negativeLoginInvalidUsername() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().getUsernameField().sendKeys("",Keys.TAB, ConfigReader.getProperty("password"));
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Web Orders"));
    }


    @Test
    public void negativeLoginInvalidPassword() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        String passcode = "invalid";
        new LoginPage().login(ConfigReader.getProperty("username") , passcode );
        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(),"http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
    }

@Test
public void negativeLoginNoPassword() {

    Driver.getDriver().get(ConfigReader.getProperty("url"));
    new LoginPage().login(ConfigReader.getProperty("username"), "");
    Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(),"http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
    }
}
