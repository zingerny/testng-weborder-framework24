package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utility.Driver;

import java.time.Duration;

public class TestBase {

    // TestBase class is a super of all test classes that offers benefits such as maintainability, readability
  protected  WebDriver driver;


    @BeforeMethod( alwaysRun = true)
    public void setUp(){
        Driver.getDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().manage().window().maximize();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        Driver.quitDriver();
    }
}
