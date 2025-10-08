package com.qa.saucelab.tests;

import com.qa.saucelab.pages.SauceLabHomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceLabHomePageTest extends SauceLabTestBase {
//    @DataProvider(name = "login")
//    public Object[][] getData(){
//        return new Object[][]{
//                {"standard_user", "secret_sauce", "Swag Labs", "https://www.saucedemo.com/inventory.html"},
//                {"problem_user", "secret_sauce", "Swag Labs", "https://www.saucedemo.com/inventory.html"},
//                {"performance_glitch_user", "secret_sauce", "Swag Labs", "https://www.saucedemo.com/inventory.html"},
//                {"error_user", "secret_sauce", "Swag Labs", "https://www.saucedemo.com/inventory.html"},
//                {"visual_user", "secret_sauce", "Swag Labs", "https://www.saucedemo.com/inventory.html"}
//
//        };
//    }
    @Test(dataProvider = "login", dataProviderClass = SauceLabTestData.class)
    public void validateLoginFunctionality(String username, String password, String title, String url){
        SauceLabHomePage sauceLabHomePage = new SauceLabHomePage(driver);
        sauceLabHomePage.homePageFunctionality(driver, username, password, url, title);
    }
//    @DataProvider(name = "negativeLogin")
//    public Object[][] getDataNegative(){
//            return new Object[][]{
//                    {"standard_user","asdasds","Epic sadface: Username and password do not match any user in this service"},
//                    {"standard_user","","Epic sadface: Password is required"},
//                    {"","secret_sauce","Epic sadface: Username is required"},
//                    {"locked_out_user","secret_sauce","Epic sadface: Sorry, this user has been locked out."},
//            };
//    }
    @Test(dataProvider = "negativeLogin", dataProviderClass = SauceLabTestData.class)
    public void validateNegativePathFunctionality(String username, String password, String message){
        SauceLabHomePage sauceLabHomePage = new SauceLabHomePage(driver);
        sauceLabHomePage.negativeLogin(username, password, message);
    }
}
