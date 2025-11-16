SauceDemo End-to-End Checkout Automation

Overview

  This project contains an automated end-to-end (E2E) UI test scenario for the SauceDemo web application using Selenium WebDriver.
  The main objective is to validate the complete purchase workflow, starting from login and ending with a successful order confirmation message.

Test Scope / Scenario Summary

  The test covers the following actions and verifications: Open the application URL: https://www.saucedemo.com/
  Login using valid credentials: Username: standard_user Password: secret_sauce
  Validate successful login by asserting the page title: "Products". Sort products by "Price (high to low)".
  Assert that the first listed product is: "Sauce Labs Fleece Jacket". Add the following items to the shopping cart:
  Sauce Labs Fleece Jacket. -> Sauce Labs Onesie. -> Sauce Labs Bolt T-Shirt.
  Validate that the cart badge displays the correct item count. Navigate to Your Cart page and verify all items.
  Proceed to checkout and validate page titles at each step: 
  
  Checkout: Your Information

  Checkout: Overview

  Checkout: Complete!

  Fill out the checkout form with: Ali, Aykaç, 35920

  Validate final confirmation message: "Thank you for your order!"

  Expected Result

  The user should be able to successfully complete the checkout process and view a final confirmation message indicating a completed order.

Test Type

- Functional
- UI (Selenium Web UI)
- Positive Test
- End-to-End Scenario

Tools & Technologies

Java

Selenium WebDriver
