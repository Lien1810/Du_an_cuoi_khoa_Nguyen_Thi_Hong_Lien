package BT_AT04.page;

import liengabi.WebUI;
import liengabi.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CategoryPage {
//    private WebDriver driver;

    private By buttonAddNewCategory = By.xpath("//span[normalize-space()='Add New category']");
    private By headerCategory = By.xpath("//h1[normalize-space()='All categories']");
    private By inputSearchCategory = By.xpath("//input[@id='search']");
    private By headerAddNewCategory = By.xpath("//h5[normalize-space()='Category Information']");

    private By inputNameCategory = By.xpath("//input[@id='name']");
    private By dropdownParentCategory = By.xpath("(//div[@class='col-md-9'])[2]//div//button");
    private By searchParentCategory = By.xpath("(//input[@aria-label='Search'])[1]");
    private By inputOrderingNumber = By.xpath("//input[@id='order_level']");
    private By dropdownTypeCategory = By.xpath("(//div[@class='col-md-9'])[4]//div//button");
    private By selectTypeCateGory = By.xpath("//li[@class='selected active']");
    private By chooseBannerImage = By.xpath("(//label[@for='signinSrEmail'])[1]/following-sibling::div//div[@class='input-group']");
    private By selectImage1 = By.xpath("//div[@title='giay.png']");
    private By buttonAddFileImage = By.xpath("//button[normalize-space()='Add Files']");
    private By inputMetaTitle = By.xpath("//input[@placeholder='Meta Title']");
    private By inputMetaDescription = By.xpath("//textarea[@name='meta_description']");
    private By dropdownFilterAttribute = By.xpath("(//div[@class='col-md-9'])[9]//div//button");
    private By dropdownEditFilterAttribute = By.xpath("(//div[@class='col-md-9'])[10]//div//button");
    private By selectValueFilterAttribute = By.xpath("//a[@id='bs-select-3-1']");
    private By buttonSaveCategory = By.xpath("//button[@type='submit']");

    private By messageSuccess = By.xpath("//span[@data-notify='message']");

    private By firstIconEditCategory = By.xpath("//tbody/tr[1]/td[10]/a[1]");
    private By messageEditSuccess = By.xpath("//span[@data-notify='message']");
    private By firstIconDeleteCategory = By.xpath("//tbody//tr[1]//td[10]//a[@title='Delete']");
    private By selectDeleteCategory = By.xpath("//a[@id='delete-link']");
    private By messageDeleteSuccess = By.xpath("//span[@data-notify='message']");
    private By menuDashBoard = By.xpath("//span[normalize-space()='Dashboard']");

    public void clickMenuDashboard(){
        WebUI.clickElement(menuDashBoard);
    }

    public void verifyRedirectCategoryPageSuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(headerCategory).isDisplayed(), "Không tìm thấy  header page");
        Assert.assertEquals(DriverManager.getDriver().findElement(headerCategory).getText(), "All categories", "Header màn Category không đúng");
    }

    public void clickButtonAddNew() {
        WebUI.clickElement(buttonAddNewCategory);
    }
    public void clickButtonEditCategory() {
        WebUI.clickElement(firstIconEditCategory);
    }

    public void clickButtonDelete() {
        WebUI.clickElement(firstIconDeleteCategory);
        WebUI.sleep(1);
        WebUI.clickElement(selectDeleteCategory);
        WebUI.waitForPageLoaded();
    }

    public void verifyRedirectAddCategoryPage() {
        Assert.assertTrue(DriverManager.getDriver().findElement(headerAddNewCategory).isDisplayed(), "Không tìm thấy  header page");
        Assert.assertEquals(DriverManager.getDriver().findElement(headerAddNewCategory).getText(), "Category Information", "Header màn Category không đúng");
    }

    public void inputDataCategory(String categoryName) {
        DriverManager.getDriver().findElement(inputNameCategory).clear();
        WebUI.setText(inputNameCategory,categoryName);

        WebUI.clickElement(dropdownParentCategory);
        WebUI.setText(searchParentCategory,"giày");
        WebUI.setKey(searchParentCategory, Keys.ENTER);

        WebUI.setText(inputOrderingNumber,"00100");

        WebUI.clickElement(dropdownTypeCategory);
        WebUI.clickElement(selectTypeCateGory);

        WebUI.clickElement(chooseBannerImage);
        WebUI.waitForElementVisible(selectImage1);
        WebUI.clickElement(selectImage1);
        WebUI.clickElement(buttonAddFileImage);

        WebUI.setText(inputMetaTitle,"Giày nữ");
        WebUI.setText(inputMetaDescription,"Giày nữ da bóng");

        WebUI.clickElement(dropdownFilterAttribute);
        WebUI.clickElement(selectValueFilterAttribute);

        WebUI.clickElement(buttonSaveCategory);
    }

    public void inputEditDataCategory(String categoryName) {
        DriverManager.getDriver().findElement(inputNameCategory).clear();
        WebUI.setText(inputNameCategory,categoryName);

        WebUI.clickElement(dropdownParentCategory);
        WebUI.setText(searchParentCategory,"giày");
        WebUI.setKey(searchParentCategory, Keys.ENTER);

        DriverManager.getDriver().findElement(inputOrderingNumber).clear();
        WebUI.setText(inputOrderingNumber,"00100");

        WebUI.clickElement(dropdownTypeCategory);
        WebUI.clickElement(selectTypeCateGory);

        WebUI.clickElement(chooseBannerImage);
        WebUI.waitForElementVisible(selectImage1);
        WebUI.clickElement(selectImage1);
        WebUI.clickElement(buttonAddFileImage);

        DriverManager.getDriver().findElement(inputMetaTitle).clear();
        WebUI.setText(inputMetaTitle,"Giày nữ");

        DriverManager.getDriver().findElement(inputMetaDescription).clear();
        WebUI.setText(inputMetaDescription,"Giày nữ da bóng");

        WebUI.clickElement(dropdownEditFilterAttribute);
        WebUI.clickElement(selectValueFilterAttribute);

        WebUI.clickElement(buttonSaveCategory);
    }

    public void verifyAddCategorySuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(messageSuccess).isDisplayed(), "Lỗi, Không thêm được category");
        Assert.assertEquals(DriverManager.getDriver().findElement(messageSuccess).getText(), "Category has been inserted successfully", "Nội dung message không chính xác");
    }

    public void searchCategory(String categoryName){
            WebUI.setText(inputSearchCategory, categoryName);
            WebUI.setKey(inputSearchCategory,Keys.ENTER);
            WebUI.sleep(1);
    }
    public void verifyEditCategorySuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(messageEditSuccess).isDisplayed(), "Lỗi, Không thêm được category");
        Assert.assertEquals(DriverManager.getDriver().findElement(messageEditSuccess).getText(), "Category has been updated successfully", "Nội dung message không chính xác");
    }

    public void verifyDeleteCategory_Success(){
        Assert.assertTrue(DriverManager.getDriver().findElement(messageDeleteSuccess).isDisplayed(), "Lỗi, Không xóa được category");
        Assert.assertEquals(DriverManager.getDriver().findElement(messageDeleteSuccess).getText(), "Category has been deleted successfully", "Nội dung message không chính xác");
    }
}
