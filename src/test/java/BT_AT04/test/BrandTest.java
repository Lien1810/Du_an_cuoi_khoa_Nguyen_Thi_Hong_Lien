package BT_AT04.test;

import BT_AT04.common.BaseTest;
import BT_AT04.page.BrandPage;
import BT_AT04.page.DashboardPage;
import BT_AT04.page.LoginPage;
import BT_AT04.page.ProductPage;
import liengabi.WebUI;
import liengabi.constants.ConfigData;
import liengabi.drivers.DriverManager;
import liengabi.helpers.CaptureHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BrandTest extends BaseTest {
    WebDriver driver;

    LoginPage loginPage;
    DashboardPage dashboardPage;
    BrandPage brandPage;

    private String BRAND_NAME = "Chris dior ";
    private String BRAND_TITLE = "Thương hiệu xa xỉ bậc nhất";
    private String BRAND_DESCRIPTION = "Hàng cao cấp tỉ mỉ trong từng đường kim mũi chỉ ";

    private String BRAND_NAME1 = "Meomeo";
    private String BRAND_TITLE1 = "Thương hiệu của Ý";
    private String BRAND_DESCRIPTION1 = "Hàng hiệu cao cấp giá bình dân";

    @Test(priority = 1)
    public void testAddBrand_Success() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        brandPage = dashboardPage.clickMenuBrand();
        WebUI.waitForPageLoaded();
        CaptureHelper.takeScreenshot("Brand screen");//chụp ảnh màn hình Brand
        brandPage.verifyRedirectBrandPageSuccess();
        brandPage.inputDataBrand(BRAND_NAME,BRAND_TITLE,BRAND_DESCRIPTION);
        brandPage.verify_AddBrand_Success();
    }

    @Test(priority = 2)
    public void testEditBrand_Success() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        brandPage = dashboardPage.clickMenuBrand();
        brandPage.verifyRedirectBrandPageSuccess();

        brandPage.searchBrand(BRAND_NAME);
        DriverManager.getDriver().findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        WebUI.sleep(1);

        brandPage.editBrand();
        brandPage.editDataBrand(BRAND_NAME1,BRAND_TITLE1,BRAND_DESCRIPTION1);
        brandPage.verify_EditBrand_Success();
        brandPage.clickMenuDashboard();
        brandPage = dashboardPage.clickMenuBrand();
        brandPage.searchBrand(BRAND_NAME1);
        DriverManager.getDriver().findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        WebUI.sleep(1);
    }
    @Test(priority = 3)
    public void testDeleteBrand_Success() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        brandPage = dashboardPage.clickMenuBrand();
        brandPage.verifyRedirectBrandPageSuccess();
        brandPage.searchBrand(BRAND_NAME);
        DriverManager.getDriver().findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        WebUI.sleep(1);
        brandPage.deleteBrand();
        brandPage.verify_DeleteBrand_Success();
    }
}
