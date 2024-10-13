package BT_AT04.test;

import BT_AT04.common.BaseTest;
import BT_AT04.page.*;
import liengabi.WebUI;
import liengabi.constants.ConfigData;
import liengabi.helpers.ExcelHelper;
import liengabi.helpers.PropertiesHelper;
import org.testng.annotations.Test;

public class FlowTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    BrandPage brandPage = new BrandPage();
    CategoryPage categoryPage = new CategoryPage();
    ProductPage productPage = new ProductPage();
    ExcelHelper excelHelper = new ExcelHelper();

    @Test(description ="Chạy flow: Login -> Add brand -> Add category -> Add product")
    public void testFlow() {
        System.out.println("-----Login ------ ");
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        System.out.println("------Add Brand ------ ");
        brandPage = dashboardPage.clickMenuBrand();
        brandPage.inputDataBrand("MiuMiu", "Thuơng hiệu Ý cao cấp", "Tinh tế trong từng đường kim");
        brandPage.searchBrand("Miumiu");
        WebUI.waitForPageLoaded();

        categoryPage.clickMenuDashboard();
        System.out.println("------Add Category ------ ");
        categoryPage = dashboardPage.clickMenuCategory();
        categoryPage.clickButtonAddNew();
        categoryPage.inputDataCategory("Áo thun kiểu đẹp");
        categoryPage.searchCategory("Áo thun kiểu đẹp");
        WebUI.waitForPageLoaded();

        productPage.clickMenuDashboard();
        System.out.println("-------Add Product ------ ");
        productPage = dashboardPage.clickMenuProduct();
        productPage.clickButtonAddProduct();
        productPage.inputDataProduct("Áo thun tay lỡ");
        productPage.searchProduct("Áo thun tay lỡ");
        WebUI.sleep(3);
    }
}
