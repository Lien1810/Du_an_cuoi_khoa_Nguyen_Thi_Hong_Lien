package BT_AT04.test;


import BT_AT04.common.BaseTest;
import BT_AT04.page.*;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;
    CategoryPage categoryPage;
    BrandPage brandPage;

    @Test
    public void testOpenAddProductPage() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        productPage = dashboardPage.clickMenuProduct();
        productPage.clickButtonAddProduct();
        productPage.verifyRedirectAddProductPageSuccess();
    }

    @Test
    public void testOpenCategoryPage() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        categoryPage = dashboardPage.clickMenuCategory();
        categoryPage.verifyRedirectCategoryPageSuccess();
    }
    @Test
    public void testOpenBrandPage() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        brandPage = dashboardPage.clickMenuBrand();
        brandPage.verifyRedirectBrandPageSuccess();
    }

    @Test
    public void logout() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        loginPage = dashboardPage.clickLogout();
        loginPage.verifyRedirectLoginPage();
    }
}
