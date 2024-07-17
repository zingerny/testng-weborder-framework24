package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class Driver {



    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            //read the browser from config file

            String browserType =  System.getProperty("browser"); // pass thru command line your browser
         if(browserType == null){ // checks if the browser was set thru command line, if not then reads from config file.
             browserType = ConfigReader.getProperty("browser").toLowerCase();
         }


            switch(browserType){
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "chrome-headless":

                    driver = new ChromeDriver(new ChromeOptions().addArguments("--headless").addArguments("window-size=1920x1080"));
                    break;
                case "firefox-headless":
                    driver = new FirefoxDriver(new FirefoxOptions().addArguments("--headless"));
                    break;
                default:
                    throw new IllegalArgumentException(browserType + " ->This Browser is not supported or invalid");
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
