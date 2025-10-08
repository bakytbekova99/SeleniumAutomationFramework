package com.qa.bank.tests;

import com.qa.bank.pages.BankCustomerLoginPage;
import com.qa.bank.pages.BankLoginPage;
import com.qa.bank.pages.BankManagerPage;
import org.testng.annotations.Test;

public class BankCustomerTest extends BankTestBase{

    @Test
    public void validateCustomerFunctionality() throws InterruptedException {
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerLoginButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Aliyah", "Bakytbekova", "77042", "Customer added successfully");
        bankManagerPage.openAccountAndCustomerFunctionality(driver, "Aliyah Bakytbekova", "Dollar", "Account created successfully", "Aliyah", "Bakytbekova", "77042");
        bankLoginPage.clickHomeButton();
        bankLoginPage.clickCustomerLoginButton();
        BankCustomerLoginPage bankCustomerLoginPage = new BankCustomerLoginPage(driver);
        bankCustomerLoginPage.customerLogin("Aliyah Bakytbekova", "Welcome Aliyah Bakytbekova !!");
        Thread.sleep(3000);
        bankCustomerLoginPage.depositFunctionality("800", "Deposit Successful", "rgba(255, 0, 0, 1)");
        Thread.sleep(3000);
        bankCustomerLoginPage.withdrawFunctionality("200", "Transaction successful", "rgba(255, 0, 0, 1)");
        Thread.sleep(3000);
        bankCustomerLoginPage.transactionFunctionality(driver, "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
    }

}
