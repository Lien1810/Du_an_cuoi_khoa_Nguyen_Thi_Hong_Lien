package BT_AT04.test;

import BT_AT04.common.BaseTest;
import BT_AT04.page.CategoryPage;
import BT_AT04.page.DashboardPage;
import BT_AT04.page.LoginPage;
import liengabi.constants.ConfigData;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {
    //Khai bao đối tượng
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CategoryPage categoryPage;
    private String CATEGORY_NAME = "Giay cao got";

    @Test
    public void testAddCategory_Success(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        categoryPage= dashboardPage.clickMenuCategory();
        categoryPage.verifyRedirectCategoryPageSuccess();

        categoryPage.clickButtonAddNew();
        categoryPage.inputDataCategory(CATEGORY_NAME);
        categoryPage.verifyAddCategorySuccess();
        categoryPage.searchCategory(CATEGORY_NAME);
    }
    @Test
    public void testEditCategory_Success(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        categoryPage= dashboardPage.clickMenuCategory();
        categoryPage.verifyRedirectCategoryPageSuccess();

        categoryPage.clickButtonEditCategory();
        categoryPage.inputEditDataCategory(CATEGORY_NAME);
        categoryPage.verifyEditCategorySuccess();
        categoryPage.clickMenuDashboard();
        dashboardPage.clickMenuCategory();
        categoryPage.searchCategory(CATEGORY_NAME);
    }
    @Test
    public void testDeleteCategory_Success(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        categoryPage= dashboardPage.clickMenuCategory();
        categoryPage.verifyRedirectCategoryPageSuccess();
        categoryPage.searchCategory(CATEGORY_NAME);
        categoryPage.clickButtonDelete();
        categoryPage.verifyDeleteCategory_Success();
        categoryPage.searchCategory(CATEGORY_NAME);
    }

}
