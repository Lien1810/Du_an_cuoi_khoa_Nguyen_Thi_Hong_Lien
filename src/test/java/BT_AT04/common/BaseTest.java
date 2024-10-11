package BT_AT04.common;

import BT_AT04.listeners.TestListener;
import liengabi.drivers.DriverManager;
import liengabi.helpers.CaptureHelper;
import liengabi.until.LogUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {
    @BeforeMethod
    @Parameters({"browser"})
    public void createBrowser(@Optional("chrome") String browserName) {
        WebDriver driver = setBrowser(browserName);
        DriverManager.setDriver(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    public WebDriver setBrowser(String browserName) {
        WebDriver driver = null;
        if (browserName.trim().toLowerCase().equals("chrome")) {
            driver = new ChromeDriver();
        }
        if (browserName.trim().toLowerCase().equals("firefox")) {
            driver = new FirefoxDriver();
        }
        if (browserName.trim().toLowerCase().equals("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public void closeBrowser(ITestResult iTestResult) {
        LogUtils.info(iTestResult.getName()); //Ghi log lai sau khi chạy mỗi method
        //chụp màn hình khi testcase bị fail, ngược lại không chụp
        if (ITestResult.FAILURE == iTestResult.getStatus()) {
            CaptureHelper.takeScreenshot((iTestResult.getName())); // getName lấy tên của testcase
        }
        // CaptureHelper.stopRecord(); //Stop record video
        DriverManager.quit();
    }
}


