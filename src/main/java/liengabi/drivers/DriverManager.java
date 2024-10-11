package liengabi.drivers;

import org.openqa.selenium.WebDriver;

import java.util.HashSet;
import java.util.Set;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    // Lấy tất cả các handle (mã định danh) của các tab đang mở
    private static Set<String> allWindowHandles = new HashSet<>();
    private static String originalWindowHandle = "";
    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    public static void quit() {
        DriverManager.driver.get().quit();
        driver.remove();
    }

    public static void updateWindowHandles() {
        allWindowHandles = driver.get().getWindowHandles(); //// Lấy tất cả các handle (mã định danh) của các tab đang mở
        System.out.println(allWindowHandles);
    }

    public static void updateOriginalWindowHandle() {
        originalWindowHandle = driver.get().getWindowHandle(); //// Lấy handle (mã định danh) của tab gốc

    }

    public static void switchToOtherTab() {
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(originalWindowHandle)) {
                // Chuyển qua tab mới
                driver.get().switchTo().window(windowHandle);
                System.out.println("Switch from " + originalWindowHandle + " to " + windowHandle);
                break;
            }
        }

    }
}