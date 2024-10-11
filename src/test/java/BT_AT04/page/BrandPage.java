package BT_AT04.page;

import liengabi.WebUI;
import liengabi.drivers.DriverManager;
import liengabi.until.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BrandPage {
    private By headerBrand = By.xpath("//h1[normalize-space()='All Brands']");
    private By inputSearchBrand = By.xpath("//input[@id='search']");
    private By inputNameBrand = By.xpath("//input[@name='name']");
    private By chooseImageLogo = By.xpath("//label[contains(.,'Logo')]/following-sibling::div[@data-type='image']");
    private By editImageLogo = By.xpath("//div[@class='input-group']");
    private By inputMetaTitle = By.xpath("//input[@name='meta_title']");
    private By inputMetaDescription = By.xpath("//textarea[@name='meta_description']");
    private By buttonSaveBrand = By.xpath("//button[normalize-space()='Save']");
    private By firstItemListBrand = By.xpath("(//div[@class='card-body'])[1]//tr[1]//td[2]");
    private By optionEditBrand = By.xpath("(//a[@title='Edit'])[1]");
    private By optionDeleteBrand = By.xpath("(//a[@title='Delete'])[1]");
    private By confirmDeleteBrand = By.xpath("//a[@id='delete-link']");
    private By messageDeleteBrandSuccess = By.xpath("//span[@data-notify='message']");//Brand has been deleted successfully
    private By messageAddBrandSuccess = By.xpath("//span[@data-notify='message']"); //Brand has been inserted successfully
    private By messageEditBrandSuccess = By.xpath("//span[@data-notify='message']"); //Brand has been updated successfully
    private By menuDashBoard = By.xpath("//span[normalize-space()='Dashboard']");

    public  void clickMenuDashboard(){
        WebUI.clickElement(menuDashBoard);
        WebUI.sleep(1);
    }


    public void verifyRedirectBrandPageSuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(headerBrand).isDisplayed(), "Không tìm thấy  header page");
        Assert.assertEquals(DriverManager.getDriver().findElement(headerBrand).getText(), "All Brands", "Header màn Category không đúng");
    }

    public DashboardPage inputDataBrand(String brandName, String titleBrand,String descriptionBrand) {
        WebUI.setText(inputNameBrand, brandName);

        WebUI.clickElement(chooseImageLogo);
        WebUI.clickElement(By.xpath("//div[@title='Profile AnhTester 512px.jpg']"));
        WebUI.clickElement(By.xpath("//button[normalize-space()='Add Files']"));

        WebUI.setText(inputMetaTitle, titleBrand);
        WebUI.setText(inputMetaDescription, descriptionBrand);
        WebUI.sleep(2);
        WebUI.clickElement(buttonSaveBrand);
        return new DashboardPage();
    }
    public void verify_AddBrand_Success() {
        Assert.assertTrue(DriverManager.getDriver().findElement(messageAddBrandSuccess).isDisplayed(), "Lỗi, Không thêm được category");
        Assert.assertEquals(DriverManager.getDriver().findElement(messageAddBrandSuccess).getText(), "Brand has been inserted successfully", "Nội dung message không chính xác");
    }

    public void verifyAddBrandFail_WithNullNameField() {
        WebElement inputElement = DriverManager.getDriver().findElement(inputNameBrand);
        String validationMessage = inputElement.getAttribute("validationMessage");
        System.out.println(validationMessage);
        Assert.assertEquals(validationMessage, "Please fill out this field.", "The validation message of Email field not match.");
    }

    public void searchBrand(String nameBrand) {
        WebUI.setText(inputSearchBrand, nameBrand);
        WebUI.setKey(inputSearchBrand, Keys.ENTER);
        // WebUI.clickElement(firstItemListBrand);
    }

    public void editBrand() {
        WebUI.clickElement(optionEditBrand);
    }
    public void editDataBrand(String brandName, String titleBrand,String descriptionBrand) {
        DriverManager.getDriver().findElement(inputNameBrand).clear();
        WebUI.setText(inputNameBrand, brandName);

        WebUI.clickElement(editImageLogo);
//        WebUI.clickElement(By.xpath("//div[@title='Profile AnhTester 512px.jpg']"));
        WebUI.clickElement(By.xpath("//div[@class='modal-dialog modal-adaptive']//div[@title='Profile AnhTester 512px.jpg']"));
        WebUI.clickElement(By.xpath("//div[@class='modal-dialog modal-adaptive']//button[normalize-space()='Add Files']"));
        WebUI.sleep(2);
        DriverManager.getDriver().findElement(inputMetaTitle).clear();
        WebUI.setText(inputMetaTitle, titleBrand);

        DriverManager.getDriver().findElement(inputMetaDescription).clear();
        WebUI.setText(inputMetaDescription, descriptionBrand);

        WebUI.clickElement(buttonSaveBrand);
    }
    public void deleteBrand() {
        WebUI.clickElement(optionDeleteBrand);
        WebUI.clickElement(confirmDeleteBrand);
    }

    public void verify_EditBrand_Success() {
        Assert.assertTrue(DriverManager.getDriver().findElement(messageEditBrandSuccess).isDisplayed(), "Lỗi, Không thêm được category");
        Assert.assertEquals(DriverManager.getDriver().findElement(messageEditBrandSuccess).getText(), "Brand has been updated successfully", "Nội dung message không chính xác");
    }

    public void verify_DeleteBrand_Success() {
        Assert.assertTrue(DriverManager.getDriver().findElement(messageDeleteBrandSuccess).isDisplayed(), "Lỗi, Không thêm được category");
        Assert.assertEquals(DriverManager.getDriver().findElement(messageDeleteBrandSuccess).getText(), "Brand has been deleted successfully", "Nội dung message không chính xác");
    }
}
