package BT_AT04.page;

import liengabi.WebUI;
import liengabi.drivers.DriverManager;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.List;

public class ProductPage {

    By menuDashBoard = By.xpath("//span[normalize-space()='Dashboard']");
    //Add New Product Page
    By buttonAddNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
    By headerAddNewProduct = By.xpath("//h5[normalize-space()='Add New Product']");
    //Product Information
    By inputProductName = By.xpath("//label[contains(normalize-space(),'Product Name')]/following-sibling::div/input");
    By dropdownCategoryProduct = By.xpath("//button[@data-id='category_id']");
    By inputSearchCategoryProduct = By.xpath("//div[@class='bs-searchbox']//input[@aria-controls='bs-select-1']");
    By dropdownBrand = By.xpath("//button[@data-id='brand_id']");
    By inputSearchBrand = By.xpath("//div[@class='bs-searchbox']//input[@aria-controls='bs-select-2']");
    By inputUnit = By.xpath("//input[@name='unit']");
    By inputWeight = By.xpath("//input[@name='weight']");
    By inputMinPurchaseQty = By.xpath("//input[@name='min_qty']");
    By inputTags = By.xpath("//span[@role='textbox']");
    //Product price + stock
    By inputUnitPrice = By.xpath("//input[@name='unit_price']");
    By inputDiscount = By.xpath("//input[@name='discount']");
    By inputQuantity = By.xpath("//input[@name='current_stock']");
    //Button Save
    By buttonSavePublish = By.xpath("//button[normalize-space()='Save & Publish']");
    By msgAddProductSuccess = By.xpath("//div[@role='alert']");
    By errorMessage = By.xpath("//span[@data-notify='message']");
    //search lại sản phẩm vừa tạo
    By inputSearchProduct = By.xpath("//input[@id='search']");
    By firstItemOnProductTable = By.xpath("(//div[@class='col'])[2]//span");

    //Edit sản phẩm vừa tạo
    By buttonAllProducts = By.xpath("//span[normalize-space()='All products']");
    By headerAllProducts = By.xpath("//h1[normalize-space()='All products']");
    By firstIconProductEdit = By.xpath("(//form[@id='sort_products']//div//tr//td//a[@title='Edit'])[1]");
    By selectCategory1 = By.xpath("(//span[@class='text'][normalize-space()='------ TestExcel1'])[1]");
    By buttonUpdateProduct = By.xpath("//button[normalize-space()='Update Product']");
    By msgUpdateProductSuccess = By.xpath("//span[@data-notify='message']");

    //DELETE PRODUCT
    By firstIconProductDelete = By.xpath("(//a[@title='Delete'])[1]");
    By selectDeleteProduct = By.xpath("//a[@id='delete-link']");
    By msgDeleteProductSuccess = By.xpath("//span[@data-notify='message']");

    //icon VIEW PRODUCT
    By firstIconViewProductDetail = By.xpath("(//a[@title='View'])[1]");

    //User Page (View Product)
    By iconXOfPopupWeb = By.xpath("//button[@data-key='website-popup']");
    By productName = By.xpath("//h1[contains(text(),'Áo phông loại 11')]");
    By productPrice = By.xpath("//strong[@class='h2 fw-600 text-primary']");
    By productQuantity = By.xpath("//input[@name='quantity']");

    public void clickMenuDashboard() {
        WebUI.clickElement(menuDashBoard);
    }

    public void clickButtonAddProduct() {
        WebUI.clickElement(buttonAddNewProduct);
    }

    public void clickButtonDeleteProduct() {
        WebUI.sleep(1);
        WebUI.clickElement(firstIconProductDelete);
        WebUI.sleep(1);
        WebUI.clickElement(selectDeleteProduct);
        WebUI.waitForPageLoaded();
    }

    public void clickIconViewProductDetail() {
        WebUI.sleep(1);
        WebUI.clickElement(firstIconViewProductDetail);
        WebUI.sleep(1);
    }

    public void verifyRedirectAddProductPageSuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(headerAddNewProduct).isDisplayed(), "Không tìm thấy Customer header page");
        Assert.assertEquals(WebUI.getElementText(headerAddNewProduct), "Add New Product", "Header màn Customer không đúng");
        WebUI.assertContains(WebUI.getElementText(headerAddNewProduct), "Add New Product", "Header màn Customer không chứa giá trị mong muốn");
    }

    public void inputDataProduct(String productName) {
        WebUI.setText(inputProductName, productName);

        WebUI.clickElement(dropdownCategoryProduct);
        WebUI.setText(inputSearchCategoryProduct, "Áo");
        WebUI.setKey(inputSearchCategoryProduct, Keys.ENTER);

        WebUI.clickElement(dropdownBrand);
        WebUI.setText(inputSearchBrand, "test");
        WebUI.setKey(inputSearchBrand, Keys.ENTER);

        WebUI.setText(inputUnit, "$");

        DriverManager.getDriver().findElement(inputWeight).clear();
        WebUI.setText(inputWeight, "0.8");

        DriverManager.getDriver().findElement(inputMinPurchaseQty).clear();
        WebUI.setText(inputMinPurchaseQty, "100");

        WebUI.setText(inputTags, "S");
        WebUI.setKey(inputTags, Keys.ENTER);

        DriverManager.getDriver().findElement(inputUnitPrice).clear();
        WebUI.setText(inputUnitPrice, "500000");

        DriverManager.getDriver().findElement(inputDiscount).clear();
        WebUI.setText(inputDiscount, "0");

        DriverManager.getDriver().findElement(inputQuantity).clear();
        WebUI.setText(inputQuantity, "30");

        WebUI.clickElement(buttonSavePublish);
    }

    public void verifyAddProductSuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(msgAddProductSuccess).isDisplayed(), "Lỗi, Không thêm được sản phẩm");
        Assert.assertEquals(DriverManager.getDriver().findElement(msgAddProductSuccess).getText(), "Product has been inserted successfully", "Nội dung message không chính xác");
    }

    // Search product
    public void searchProduct(String nameProduct) {
        WebUI.setText(inputSearchProduct, nameProduct);
        WebUI.setKey(inputSearchProduct, Keys.ENTER);
        WebUI.waitForPageLoaded();
    }

    // Check view product details
    public void userViewProductDetails(String nameProduct) {
        WebUI.switchToOtherTab();
        //click để tắt popup website
        WebUI.waitForElementClickable(iconXOfPopupWeb);
        WebUI.clickElement(iconXOfPopupWeb);
        WebUI.sleep(1);
        //so sanh hien thi man product cua nguoi dung voi thong tin minh nhap
        WebUI.assertEquals(WebUI.getElementText(productName), "Áo phông loại 11", "Product name NOT match");
        WebUI.assertEquals(WebUI.getElementText(productPrice), "$500,000.00", "Discount price NOT match");
        //   WebUI.assertEquals(WebUI.getElementText(productQuantity),"100", "Quantity NOT match");
    }

    // Navigate All Product screen
    public void clickButtonAllProducts() {
        WebUI.clickElement(buttonAllProducts);
    }

    public void verifyRedirectAllProductPageSuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(headerAllProducts).isDisplayed(), "Không tìm thấy header page");
        Assert.assertEquals(DriverManager.getDriver().findElement(headerAllProducts).getText(), "All products", "Header màn All Products không đúng");
    }

    // Edit product
    public void clickButtonEditProducts() {
        WebUI.clickElement(firstIconProductEdit);
    }

    public void editProduct(String productName) {
        DriverManager.getDriver().findElement(inputProductName).clear();
        WebUI.setText(inputProductName, productName);

        WebUI.clickElement(dropdownCategoryProduct);
        WebUI.setText(inputSearchCategoryProduct, "Áo");
        WebUI.setKey(inputSearchCategoryProduct, Keys.ENTER);

        WebUI.clickElement(dropdownBrand);
        WebUI.setText(inputSearchBrand, "test1");
        WebUI.setKey(inputSearchBrand, Keys.ENTER);

        DriverManager.getDriver().findElement(inputUnit).clear();
        WebUI.setText(inputUnit, "VNĐ");

        DriverManager.getDriver().findElement(inputWeight).clear();
        WebUI.setText(inputWeight, "1.3");
        WebUI.sleep(2);

        DriverManager.getDriver().findElement(inputMinPurchaseQty).clear();
        WebUI.setText(inputMinPurchaseQty, "100");
        WebUI.sleep(2);

        WebUI.setText(inputTags, "M");
        DriverManager.getDriver().findElement(inputTags).sendKeys(Keys.ENTER);
        WebUI.setKey(inputTags, Keys.ENTER);

        DriverManager.getDriver().findElement(inputUnitPrice).clear();
        WebUI.setText(inputUnitPrice, "200");

        DriverManager.getDriver().findElement(inputDiscount).clear();
        WebUI.setText(inputDiscount, "0");
        WebUI.sleep(2);

        WebUI.clickElement(buttonUpdateProduct);
    }

    public void verifyEditProductSuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(msgUpdateProductSuccess).isDisplayed(), "Lỗi, Không thêm được sản phẩm");
        Assert.assertEquals(DriverManager.getDriver().findElement(msgUpdateProductSuccess).getText(), "Product has been updated successfully", "Nội dung message không chính xác");
    }

    public void verifyDeleteProductSuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(msgDeleteProductSuccess).isDisplayed(), "Lỗi, Không thêm được sản phẩm");
        Assert.assertEquals(DriverManager.getDriver().findElement(msgDeleteProductSuccess).getText(), "Product has been deleted successfully", "Nội dung message không chính xác");
    }

    public void researchProduct(String nameProduct) {
        DriverManager.getDriver().findElement(inputSearchProduct).clear();
        WebUI.setText(inputSearchProduct, nameProduct);
        WebUI.setKey(inputSearchProduct, Keys.ENTER);
    }

    public void verifyAddProductFail() {
        System.out.println("Verify Login Fail");
        Assert.assertTrue(DriverManager.getDriver().findElement(errorMessage).isDisplayed(), "Error Message not displayed");
        Assert.assertEquals(WebUI.getElementText(errorMessage), "Invalid email or password 123", "Content of error message not match");
    }

    //Lấy ra số lượng dữ liệu hợp lệ của mỗi bảng
    public void checkSearchTableByColumn(int column, String value) {
        //Xác định số dòng của table sau khi search
        List<WebElement> paginate = DriverManager.getDriver().findElements(By.xpath("//div[@class='aiz-pagination']//ul/li"));

        int paginateTotal = paginate.size(); //Lấy ra tổng số page
        int totalpage = paginateTotal - 2; //-2 nút là next và back
        int total = 0;
        //Duyệt từng dòng
        if (totalpage <= 1){
            List<WebElement> row = DriverManager.getDriver().findElements(By.xpath("//table//tbody/tr"));
            int rowTotal = row.size(); //Lấy ra số dòng của page đó
            total = total + rowTotal;
        } else {
            for (int i = 1; i <= totalpage; i++) {  //i chạy từ dòng 1 đến dòng cuối cùng, column là cột mà mình chỉ định

                List<WebElement> row = DriverManager.getDriver().findElements(By.xpath("//table//tbody/tr"));
                int rowTotal = row.size(); //Lấy ra số dòng
                WebElement elementCheck = DriverManager.getDriver().findElement(By.xpath("//table//tbody/tr[" + rowTotal + "]/td[" + column + "]"));

                //Đoạn dưới này để scroll xuống từng dòng , true là trên, false là dưới
                JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
                js.executeScript("arguments[0].scrollIntoView(false);", elementCheck);

                total = total + rowTotal;

                WebElement lastElement = DriverManager.getDriver().findElement(By.xpath("//div[@class='aiz-pagination']//ul/li[last()]"));
                lastElement.click();
                WebUI.sleep(2);
            }
        }

        System.out.println("Tổng số sản phẩm hợp lệ: " + total);
    }
}

