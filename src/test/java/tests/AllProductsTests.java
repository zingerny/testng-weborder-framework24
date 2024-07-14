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
import pages.AllProductsPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ConfigReader;
import utility.Driver;
import utility.SeleniumUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AllProductsTests extends TestBase {

    @Test
    public void verifyTitle() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"), Keys.TAB,ConfigReader.getProperty("password"),Keys.ENTER);

        Driver.getDriver().findElement(By.linkText("View all products")).click();
        WebElement element = Driver.getDriver().findElement(By.tagName("h2"));
        Assert.assertTrue(element.isDisplayed());
    }


    @Test
    public void verifyColumns() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new LoginPage().login();
        new HomePage().clickOnLink("View all products");
        List <String> actualHeadersText = new AllProductsPage().extractHeadersText();
        Assert.assertEquals(actualHeadersText, List.of("Product name", "Price", "Discount"));


    }

}
