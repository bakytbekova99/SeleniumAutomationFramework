package com.qa.bank.tests;

import com.qa.bank.pages.BankLoginPage;
import org.testng.annotations.Test;

public class BankLoginTest extends BankTestBase{
    @Test
    public void validateLoginPageInformation(){
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.checkLoginPageInformation("XYZ Bank", "rgba(51, 122, 183, 1)");
    }

}
