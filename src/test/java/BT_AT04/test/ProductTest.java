package BT_AT04.test;

import BT_AT04.common.BaseTest;
import BT_AT04.page.ProductPage;
import BT_AT04.page.DashboardPage;
import BT_AT04.page.LoginPage;
import liengabi.constants.ConfigData;
import liengabi.drivers.DriverManager;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;

    private String PRODUCT_NAME = "Áo phông loại 11";
    private String PRODUCT_NAME1 = "Áo phông MẪU MỚI";
    private String PRODUCT_NAME2 ="";
    @Test
    public void testAddNewProduct_Success() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();
        productPage = dashboardPage.clickMenuProduct();
        productPage.clickButtonAddProduct();
        productPage.verifyRedirectAddProductPageSuccess();
        productPage.inputDataProduct(PRODUCT_NAME);
        productPage.verifyAddProductSuccess();
       // productPage.clickButtonAllProducts();
        //search lại sp vừa tạo
        productPage.searchProduct(PRODUCT_NAME);
        //vào màn product detail user
        productPage.clickIconViewProductDetail();
        productPage.userViewProductDetails(PRODUCT_NAME);
    }

    @Test
    public void testAddNewProductFail_withNullProductName() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();
        productPage = dashboardPage.clickMenuProduct();
        productPage.clickButtonAddProduct();
        productPage.verifyRedirectAddProductPageSuccess();
        productPage.inputDataProduct(PRODUCT_NAME2);
        productPage.verifyAddProductFail();
    }

    @Test
    public void testEditProduct_Success() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        productPage = dashboardPage.clickMenuProduct();
        productPage.clickButtonAllProducts();
        productPage.verifyRedirectAllProductPageSuccess();

        productPage.searchProduct(PRODUCT_NAME);
        productPage.clickButtonEditProducts();
        productPage.editProduct(PRODUCT_NAME1);
        productPage.verifyEditProductSuccess();
    }

    @Test
    public void testDeleteProduct_Success() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        productPage = dashboardPage.clickMenuProduct();
        productPage.clickButtonAllProducts();
        productPage.verifyRedirectAllProductPageSuccess();

        productPage.searchProduct(PRODUCT_NAME);
        productPage.clickButtonDeleteProduct();
        productPage.verifyDeleteProductSuccess();
        // research lại tên sp cua delete
        productPage.researchProduct(PRODUCT_NAME);
    }

    @Test
    public void testCheckDataOnProductTable() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        productPage = dashboardPage.clickMenuProduct();
        productPage.clickButtonAllProducts();
        productPage.searchProduct("táo");
        productPage.checkSearchTableByColumn(2, "táo"); // so sanh chứa
    }
}
