package BT_AT04.test;

import BT_AT04.common.BaseTest;
import BT_AT04.page.LoginPage;
import liengabi.constants.ConfigData;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //khai bao đối tượng class LoginPage toàn cục
    LoginPage loginPage;

    @Test
    public void testLoginCRM_LoginSuccess() {
        //Khởi tạo đối tượng class
        System.out.println("===testLoginCRM_LoginSuccess===");
        loginPage = new LoginPage();
        loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginCRM_emailInvalid() {
        System.out.println("===testLoginCRM_emailInvalid===");
        loginPage = new LoginPage();
        loginPage.loginCMS("admin1@example.com", "123456");
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCRM_passwordInvalid() {
        System.out.println("===testLoginCRM_passwordInvalid===");
        loginPage = new LoginPage();
        loginPage.loginCMS("admin@example.com", "1236");
        loginPage.verifyLoginFail();
    }
}
