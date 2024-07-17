package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utility.ConfigReader;
import utility.Driver;
import utility.SeleniumUtils;

import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase {

    // TestBase class is a super of all test classes that offers benefits such as maintainability, readability
    protected  WebDriver driver;

    protected static ExtentReports extentReports; // report manager
    protected static ExtentSparkReporter htmlReport; // manages html reports
    protected static ExtentTest logger;// logs the test steps

@BeforeSuite(alwaysRun = true)
public void setUpSuite(){
    extentReports = new ExtentReports();
    htmlReport = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/extentReport/report.html");
    extentReports.attachReporter(htmlReport);

    extentReports.setSystemInfo("Project Name ", "Web orders test Automation");
    extentReports.setSystemInfo("SDETs ", "John Doe, Jan Smith");
    extentReports.setSystemInfo("OS", System.getProperty("os.name"));
    extentReports.setSystemInfo("Browser", System.getProperty("browser")==null ? ConfigReader.getProperty("browser"):System.getProperty("browser"));
    extentReports.setSystemInfo("Homepage", ConfigReader.getProperty("url"));
}


@AfterSuite(alwaysRun = true)
public void tearDownSuite(){
extentReports.flush();
}


    @BeforeMethod( alwaysRun = true)
    public void setUp(Method method){
        Driver.getDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().manage().window().maximize();
        logger=extentReports.createTest( "Test "+method.getName());
        logger.info("Test Started "+ method.getName());
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult){
      //  SeleniumUtils.takeScreenshot("target/sceenshots/failure.png");

        if(testResult.getStatus() == ITestResult.SUCCESS){
        logger.pass("Test PASSED"+ testResult.getName());
        }

        else if (testResult.getStatus() == ITestResult.SKIP) {
            logger.skip("Test SKIPPED"+testResult.getName());
        }
        else if (testResult.getStatus() == ITestResult.FAILURE){
        logger.fail("Test FAILED" +testResult.getName());
            logger.fail(testResult.getThrowable());
            //take screenshot
        String pathOfTheScreenShotFile = SeleniumUtils.getScreenshot("target/sceenshots/failure.png");
        logger.addScreenCaptureFromPath(pathOfTheScreenShotFile);
        }


        Driver.quitDriver();
    }

}
