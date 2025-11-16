package com.sauceDemo.pages;

import com.sauceDemo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = ".shopping_cart_badge")
    public WebElement basketNumber;

    @FindBy(css = ".shopping_cart_link")
    public WebElement shoppingCartLink;
}
