package liengabi.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import liengabi.drivers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager { //đây là file đầu vào của mình
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = ExtentReportManager.getExtentReports();

    public static ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized ExtentTest saveToReport(String testName, String desc) { // hàm này để lưu những cái step- bước
        ExtentTest test = extent.createTest(testName, desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }

    public static void addScreenshot(String message) { // đính kem  hình ảnh vào từng bước
        String base64Image = "data:image/png;base64,"
                + ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64); // takescreenshot của selenium

        getTest().log(Status.INFO, message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
    }

    public static void addScreenshot(Status status, String message) {
        String base64Image = "data:image/png;base64,"
                + ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

        getTest().log(status, message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
    }

    public static void logMessage(String message) {
        getTest().log(Status.INFO, message);
    } // Ghi log - ghi mô tả

    public static void logMessage(Status status, String message) {
        getTest().log(status, message);
    }
}
