package com.qa.blaze.tests;

import com.qa.blaze.pages.BlazeHomePage;
import com.qa.blaze.pages.BlazeSignUpPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class BlazeSignUpTest extends BlazeTestBase {
    @Test
    public void validateSignUpFunctionality() throws InterruptedException {
        BlazeHomePage blazeHomePage = new BlazeHomePage(driver);
        blazeHomePage.signUpButton();
        BlazeSignUpPage blazeSignUpPage = new BlazeSignUpPage(driver);
        blazeSignUpPage.signUpFunctionality(driver, ConfigReader.readProperty("blaze_username"), ConfigReader.readProperty("blaze_password"), "Sign up successful.");
    }
}
