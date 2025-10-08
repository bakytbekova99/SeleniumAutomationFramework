package com.qa.blaze.tests;

import com.qa.blaze.pages.*;
import org.testng.annotations.Test;
import utils.ConfigReader;

import static utils.DriverHelper.driver;

public class BlazeOrderTest extends BlazeTestBase{
    @Test
    public void validateOrderFunctionality() throws InterruptedException {
        BlazeHomePage blazeHomePage = new BlazeHomePage(driver);
        blazeHomePage.logInButton();
        BlazeLogInPage blazeLogInPage = new BlazeLogInPage(driver);
        blazeLogInPage.logInFunctionality(ConfigReader.readProperty("blaze_username"),
                ConfigReader.readProperty("blaze_password"), "Welcome");
        blazeHomePage.laptopsButton();
        BlazeLaptopPage blazeLaptopPage = new BlazeLaptopPage(driver);
        blazeLaptopPage.productInformation(driver, "MacBook Pro", "$1100 *includes tax", "Product added.");
        blazeHomePage.cartButton();
        BlazeCartPage blazeCartPage = new BlazeCartPage(driver);
        blazeCartPage.placeOrderButton();
        BlazeOrderPage blazeOrderPage = new BlazeOrderPage(driver);
        blazeOrderPage.placeOrderFunctionality("Aliyah B", "United States", "Houston", "234355667", "08", "2025", "Thank you for your purchase!");

    }
}
