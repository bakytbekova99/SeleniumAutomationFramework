package com.qa.saucelab.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverHelper;

public class SauceLabTestBase {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("sauce_url"));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
