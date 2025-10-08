package com.qa.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BankCustomerLoginPage {
    public BankCustomerLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#userSelect")
    WebElement customerName;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginAndDepositWithdrawButton;
    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement welcomeMessage;
    @FindBy(xpath = "//button[contains(@ng-click, 'deposit()')]")
    WebElement depositButton;
    @FindBy(xpath = "//input[@type='number']")
    WebElement amountToDeposit;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement finalDepositButton;
    @FindBy(xpath = "//span[contains(@ng-show, 'message')]")
    WebElement depositSuccessfulMessage;
    @FindBy(xpath = "//button[@ng-class = 'btnClass3']")
    WebElement withdrawButton;
    @FindBy(xpath = "//strong[@class='ng-binding'][2]")
    WebElement balance;
    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement transactionButton;
    @FindBy(xpath = "//tr[@id='anchor0']//td[@class='ng-binding'][2]")
    WebElement creditAmount;
    @FindBy(xpath = "//tr[@id='anchor1']//td[@class='ng-binding'][2]")
    WebElement debit;
    @FindBy(xpath = "//button[@ng-show='logout']")
    WebElement logoutButton;

    public void customerLogin(String customerName, String expectedMessage){
        BrowserUtils.selectBy(this.customerName, customerName, "text");
        loginAndDepositWithdrawButton.click();
        Assert.assertEquals(welcomeMessage.getText().trim(), expectedMessage);
    }
    public void depositFunctionality(String amount, String expectedMessage, String expectedColor){
        depositButton.click();
        this.amountToDeposit.sendKeys(amount);
        loginAndDepositWithdrawButton.click();
        Assert.assertEquals(depositSuccessfulMessage.getText(), expectedMessage);
        Assert.assertEquals(depositSuccessfulMessage.getCssValue("color"), expectedColor);
    }
    public void withdrawFunctionality(String amount, String expectedMessage, String expectedColor) throws InterruptedException {
        withdrawButton.click();
        Thread.sleep(2000);
        this.amountToDeposit.sendKeys(amount);
        loginAndDepositWithdrawButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(depositSuccessfulMessage.getText(), expectedMessage);
        Assert.assertEquals(depositSuccessfulMessage.getCssValue("color"), expectedColor);
    }
    public void transactionFunctionality(WebDriver driver, String expectedURL){
        int actualBalance = Integer.parseInt(balance.getText());
        transactionButton.click();
        int expectedBalance = Integer.parseInt(creditAmount.getText()) - Integer.parseInt(debit.getText());
        Assert.assertEquals(actualBalance, expectedBalance);
        logoutButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }


}
