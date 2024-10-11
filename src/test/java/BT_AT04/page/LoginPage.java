package BT_AT04.page;

import liengabi.WebUI;
import liengabi.constants.ConfigData;
import liengabi.drivers.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {

   // private String url = "https://cms.anhtester.com/login";

    //khai bao tat ca cac object(element) tren page nay
    //Thuoc kieu doi tuong By(thuoc cua Selenium)
    By headerLoginPage = By.xpath("//h1[@class='h3 text-primary mb-0']");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By errorMessage = By.xpath("//span[@data-notify='message']");
    By menuDashBoard = By.xpath("//span[normalize-space()='Dashboard']");
    //XD các hàm xử lý chính trên page này
    private void setEmailInput(String email) {
        WebUI.setText(inputEmail, email);
    }

    private void setPasswordInput(String password) {
        WebUI.setText(inputPassword, password);
    }

    private void clickButtonLogin() {
        WebUI.clickElement(buttonLogin);
    }

    public DashboardPage loginCMS(String email, String password) { //thay void = trang liên kểt
        WebUI.openURL(ConfigData.URL);
        WebUI.waitForPageLoaded();
        System.out.println("Navigate to url: " + ConfigData.URL);
        setEmailInput(email);
        setPasswordInput(password);
        clickButtonLogin();
        WebUI.waitForPageLoaded();
        return new DashboardPage();

    }

    public void verifyLoginSuccess() {
        System.out.println("Verify Login Success");
        Assert.assertTrue(DriverManager.getDriver().findElement(menuDashBoard).isDisplayed(), "Menu dashboard not displayed");
    }

    public void verifyLoginFail() {
        System.out.println("Verify Login Fail");
        Assert.assertTrue(DriverManager.getDriver().findElement(errorMessage).isDisplayed(), "Error Message not displayed");
        Assert.assertEquals(WebUI.getElementText(errorMessage), "Invalid login credentials", "Content of error message not match");
    }

    public void verifyRedirectLoginPage() {
        System.out.println("Verify Redirect Login Page");
        Assert.assertTrue(DriverManager.getDriver().findElement(headerLoginPage).isDisplayed(), "Error: Header login page not displayed");
        Assert.assertEquals(WebUI.getElementText(headerLoginPage), "Welcome to Active eCommerce CMS", "Content of header for login page not match");
    }

}
