package com.qa.blaze.tests;

import com.qa.blaze.pages.BlazeHomePage;
import com.qa.blaze.pages.BlazeLaptopPage;
import com.qa.blaze.pages.BlazeLogInPage;
import com.qa.blaze.pages.BlazeSignUpPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class BlazeProductTest extends BlazeTestBase{
    @Parameters({"expectedText", "expectedHeader", "expectedPrice", "expectedMessage"})
    @Test
    public void validateProductFunctionality(String expectedText, String expectedHeader, String expectedPrice, String expectedMessage) throws InterruptedException {
        BlazeHomePage blazeHomePage = new BlazeHomePage(driver);
        blazeHomePage.logInButton();
        BlazeLogInPage blazeLogInPage = new BlazeLogInPage(driver);
        blazeLogInPage.logInFunctionality(ConfigReader.readProperty("blaze_username"),
                ConfigReader.readProperty("blaze_password"), expectedText);
        blazeHomePage.laptopsButton();
        BlazeLaptopPage blazeLaptopPage = new BlazeLaptopPage(driver);
        blazeLaptopPage.productInformation(driver, expectedHeader, expectedPrice, expectedMessage);
    }
}
