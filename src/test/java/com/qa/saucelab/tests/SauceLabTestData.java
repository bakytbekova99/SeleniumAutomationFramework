package com.qa.saucelab.tests;

import org.testng.annotations.DataProvider;

public class SauceLabTestData {
    @DataProvider(name = "login")
    public Object[][] getData(){
        return new Object[][]{
                {"standard_user", "secret_sauce", "Swag Labs", "https://www.saucedemo.com/inventory.html"},
                {"problem_user", "secret_sauce", "Swag Labs", "https://www.saucedemo.com/inventory.html"},
                {"performance_glitch_user", "secret_sauce", "Swag Labs", "https://www.saucedemo.com/inventory.html"},
                {"error_user", "secret_sauce", "Swag Labs", "https://www.saucedemo.com/inventory.html"},
                {"visual_user", "secret_sauce", "Swag Labs", "https://www.saucedemo.com/inventory.html"}

        };
    }
    @DataProvider(name = "negativeLogin")
    public Object[][] getDataNegative(){
        return new Object[][]{
                {"standard_user","asdasds","Epic sadface: Username and password do not match any user in this service"},
                {"standard_user","","Epic sadface: Password is required"},
                {"","secret_sauce","Epic sadface: Username is required"},
                {"locked_out_user","secret_sauce","Epic sadface: Sorry, this user has been locked out."},
        };
    }
}
