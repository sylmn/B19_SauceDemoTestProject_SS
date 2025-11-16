package com.sauceDemo.test.E2E_Tests;

import com.sauceDemo.pages.*;
import com.sauceDemo.test.TestBase;
import com.sauceDemo.utilities.BrowserUtils;
import com.sauceDemo.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C_1_SuccessShoppingTest extends TestBase {

    @Test
    public void successShopping_TC_0125() {
        /**
         * Kullanici login sayfasina gider : https://www.saucedemo.com/
         * Kullanici gecerli kullanici adi: "standard_user" ve sifreyi: "secret_sauce" girer
         * Kullanici acilan sayafanin basligini gorur: "Products"
         * Kullanici urunleri verilen kritere gore siralar: "Price (high to low)"
         * Kullanici en pahali urunu ilk sirada gorur: "Sauce Labs Fleece Jacket"
         * Kullanici urun adi ile sepete urun ekler : "Sauce Labs Fleece Jacket"
         * Kullanici urun adi ile sepete urun ekler : "Sauce Labs Onesie"
         * Kullanici urun adi ile sepete urun ekler : "Sauce Labs Bolt T-Shirt"
         * Kullanici ekledigi urun sayisini sepetin ustunde gorur
         * Kullanici your cart sayfasina gider
         * Kullanici acilan sayafanin basligini gorur: "Your Cart"
         * Kullanici ekledigi urunleri your cart sayfasinda dogrular
         * Kullanici sonraki sayfaya gecer
         * Kullanici acilan sayafanin basligini gorur: "Checkout: Your Information"
         * Kullanici formu ilgili bilgilerle doldurur : "Ali", "Aykaç", "35920"
         * Kullanici sonraki sayfaya gecer
         * Kullanici acilan sayafanin basligini gorur: "Checkout: Overview"
         * Kullanici sonraki isimli sayfaya gecer
         * Kullanici acilan sayafanin basligini gorur: "Checkout: Complete!"
         * Kullanici tesekkur mesajini gorur: "Thank you for your order!"
         */

        extentLogger = report.createTest("TC0125- Success Shopping E2E Test");

        extentLogger.info("Kullanici login sayfasina gider : " + ConfigurationReader.get("url"));
        extentLogger.info("Kullanici gecerli kullanici adi: 'standard_user' ve sifreyi: 'secret_sauce' girer");
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        extentLogger.info("Kullanici acilan sayafanin basligini gorur: 'Products'");
        ProductsPage productsPage = new ProductsPage();
        String actualTitle = productsPage.productsPageTitle.getText();
        String expectedTitle = "Products";
        Assert.assertEquals(actualTitle, expectedTitle);

        extentLogger.info("Kullanici urunleri verilen kritere gore siralar: 'Price (high to low)'");
        productsPage.sortProducts("Price (high to low)");

        extentLogger.info("Kullanici en pahali urunu ilk sirada gorur:'Sauce Labs Fleece Jacket'");
        String actualFirstProduct = productsPage.getFirstProductName();
        String expectedFirstProduct = "Sauce Labs Fleece Jacket";
        Assert.assertEquals(actualFirstProduct, expectedFirstProduct);

        extentLogger.info("Kullanici urun adi ile sepete urun ekler : 'Sauce Labs Fleece Jacket'");
        productsPage.selectProductByName("Sauce Labs Fleece Jacket");
        extentLogger.info("Kullanici urun adi ile sepete urun ekler : 'Sauce Labs Onesie'");
        productsPage.selectProductByName("Sauce Labs Onesie");
        extentLogger.info("Kullanici urun adi ile sepete urun ekler : 'Sauce Labs Bolt T-Shirt'");
        productsPage.selectProductByName("Sauce Labs Bolt T-Shirt");

        extentLogger.info("Kullanici ekledigi urun sayisini sepetin ustunde gorur");
        String basketNumber = productsPage.basketNumber.getText();
        String actualBasketNumber = String.valueOf(ProductsPage.addedProductNumber);
        Assert.assertEquals(actualBasketNumber, basketNumber);
        System.out.println("basketNumber = " + basketNumber);
        System.out.println("actualBasketNumber = " + actualBasketNumber);

        extentLogger.info("Kullanici your cart sayfasina gider");
        productsPage.shoppingCartLink.click();

        extentLogger.info("Kullanici acilan sayafanin basligini gorur: 'Your Cart'");
        YourCartPage yourCartPage = new YourCartPage();
        Assert.assertTrue(yourCartPage.yourCartPageTitle.isDisplayed());

        extentLogger.info("Kullanici ekledigi urunleri your cart sayfasinda dogrular");
        List<String> expectedAddedItems = new ArrayList<>(Arrays.asList("Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Sauce Labs Bolt T-Shirt"));
        List<String> actualAddedItems = BrowserUtils.getElementsText(yourCartPage.addedItemsToTheBasket);
        Assert.assertEquals(actualAddedItems, expectedAddedItems);

        extentLogger.info("Kullanici sonraki sayfaya gecer");
        yourCartPage.checkoutBtn.click();

        extentLogger.info("Kullanici acilan sayafanin basligini gorur: 'Checkout: Your Information'");
        CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage();
        Assert.assertTrue(checkoutYourInformationPage.checkoutYourInfoPageTitle.isDisplayed());

        extentLogger.info("Kullanici formu ilgili bilgilerle doldurur : 'Ali', 'Aykac', '35920'");
        checkoutYourInformationPage.fillingCheckoutInfoForm("Ali", "Aykac", "35920");

        extentLogger.info("Kullanici checkout sayfasina gecer");
        checkoutYourInformationPage.continueBtn.click();

        extentLogger.info("Kullanici acilan sayafanin basligini gorur: 'Checkout: Overview'");
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        Assert.assertTrue(checkoutOverviewPage.checkoutOverviewPageTitle.isDisplayed());

        extentLogger.info("Kullanici finish sayfasina gecer");
        checkoutOverviewPage.finishBtn.click();

        extentLogger.info("Kullanici acilan sayafanin basligini gorur: 'Checkout: Complete!'");
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
        Assert.assertTrue(checkoutCompletePage.checkoutCompletePageTitle.isDisplayed());

        extentLogger.info("Kullanici tesekkur mesajini gorur: 'Thank you for your order!'");
        String actualMessage = checkoutCompletePage.thankYouMessage.getText();
        String expectedMessage = "Thank you for your order!";
        Assert.assertEquals(actualMessage, expectedMessage);
        extentLogger.pass("Passed");
    }
}
