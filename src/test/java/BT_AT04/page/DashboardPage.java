package BT_AT04.page;

import liengabi.WebUI;
import liengabi.until.LogUtils;
import org.openqa.selenium.By;

public class DashboardPage {

    private By menuProduct = By.xpath("//span[normalize-space()='Products']");
    private By menuCategory = By.xpath("//span[normalize-space()='Category']");
    private By menuBrand = By.xpath("//span[normalize-space()='Brand']");
    private By dropdownProfile = By.xpath("//a[@class='dropdown-toggle no-arrow text-dark']");
    private By optionLogout = By.xpath("//span[normalize-space()='Logout']");

    public ProductPage clickMenuProduct() {
        WebUI.clickElement(menuProduct);
        LogUtils.info("Click on menu Customers");
        return new ProductPage();
    }

    public CategoryPage clickMenuCategory() {
        WebUI.clickElement(menuProduct);
        LogUtils.info("Click on menu Customers");
        WebUI.clickElement(menuCategory);
        LogUtils.info("Click on menu Customers");
        return new CategoryPage();
    }

    public BrandPage clickMenuBrand() {
        WebUI.clickElement(menuProduct);
        LogUtils.info("Click on menu Customers");
        WebUI.clickElement(menuBrand);
        LogUtils.info("Click on menu Customers");
        return new BrandPage();
    }

    public LoginPage clickLogout() {
        WebUI.clickElement(dropdownProfile);
        LogUtils.info("Click on dropdownProfile");
        WebUI.sleep(1);
        WebUI.clickElement(optionLogout);
        LogUtils.info("Click on option Logout");
        return new LoginPage();
    }


}
