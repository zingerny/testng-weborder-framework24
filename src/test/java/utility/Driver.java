package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            //read the browser from config file
            String browser = ConfigReader.getProperty("browser");
            switch(browser){
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException(browser + " ->This Browser is not supported or invalid");
            }

        }
        return driver;
    }

    public static void  quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
