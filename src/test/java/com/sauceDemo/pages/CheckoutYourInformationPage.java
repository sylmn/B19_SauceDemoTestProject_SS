package com.sauceDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutYourInformationPage extends BasePage {

    @FindBy(xpath = "//span[text()='Checkout: Your Information']")
    public WebElement checkoutYourInfoPageTitle;

    @FindBy(id = "first-name")
    public WebElement firstnameBox;

    @FindBy(id = "last-name")
    public WebElement lastnameBox;

    @FindBy(id = "postal-code")
    public WebElement zip_postalCodeBox;

    @FindBy(id = "continue")
    public WebElement continueBtn;

    public void fillingCheckoutInfoForm(String firstname, String lastname, String zipPostalCode) {
        firstnameBox.sendKeys(firstname);
        lastnameBox.sendKeys(lastname);
        zip_postalCodeBox.sendKeys(zipPostalCode);
    }
}
