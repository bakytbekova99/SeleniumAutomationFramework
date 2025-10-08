package com.qa.bank.tests;

import com.qa.bank.pages.BankLoginPage;
import com.qa.bank.pages.BankManagerPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class BankManagerTest extends BankTestBase {
    @Test
    public void validateAddCustomerFunctionality(){
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerLoginButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, ConfigReader.readProperty("firstName"),
                ConfigReader.readProperty("lastName"),
                ConfigReader.readProperty("zipCode"),
                ConfigReader.readProperty("expectedMessage"));
    }
    @Test
    public void validateOpenAccountAndCustomerFunctionality() throws InterruptedException {
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerLoginButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Aliyah", "Bakytbekova",
                "77042", "Customer added successfully");
        bankManagerPage.openAccountAndCustomerFunctionality(driver,
                ConfigReader.readProperty("customerName"),
                ConfigReader.readProperty("currency"),
                ConfigReader.readProperty("expectedText"),
                ConfigReader.readProperty("firstName"),
                ConfigReader.readProperty("lastName"),
                ConfigReader.readProperty("zipCode"));

    }


}
