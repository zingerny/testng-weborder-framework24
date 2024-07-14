package zmisc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import tests.TestBase;
import utility.CSVReader;
import utility.Driver;
import utility.SeleniumUtils;

import java.util.Arrays;

public class TestSeleniumUtils extends TestBase{

@Test
  public void testUtil01(){


        Driver.getDriver().get("https://www.amazon.com/");
        SeleniumUtils.scroll(2500,1000);
        SeleniumUtils.jsClick(Driver.getDriver().findElement(By.xpath("//a[@href='https://music.amazon.com?ref=nav_youraccount_cldplyr']")));
        SeleniumUtils.takeScreenshot("target/sceenshots/screenshotOfFailure.png");
    }

    public static void main(String[] args) {
        Object[][] objects = CSVReader.readData("src/test/resources/customers.csv");
        System.out.println(Arrays.deepToString(objects));
    }
}
