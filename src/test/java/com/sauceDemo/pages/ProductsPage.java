package com.sauceDemo.pages;

import com.sauceDemo.utilities.BrowserUtils;
import com.sauceDemo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends BasePage {

    public static int addedProductNumber;

    @FindBy(xpath = "//span[text()='Products']")
    public WebElement productsPageTitle;

    @FindBy(css = ".product_sort_container")
    public WebElement productsSortDropdown;

    @FindBy(css = ".inventory_item_name ")
    public List<WebElement> allProducts;


    public void sortProducts(String sortType) {
        Select select = new Select(productsSortDropdown);
        select.selectByVisibleText(sortType);
    }

    public String getFirstProductName() {
        return allProducts.get(0).getText();
    }

    public void selectProductByName(String productName) {
        BrowserUtils.waitFor(3);
        Driver.get().findElement(By.xpath("//div[text()='" + productName + "']/../../..//button")).click();
        addedProductNumber++;
    }
}
