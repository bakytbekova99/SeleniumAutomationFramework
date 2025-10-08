package com.qa.bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {

    public BankManagerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(@ng-click, 'addCust()')]")
    WebElement addCustomer;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@ng-model='lName']")
    WebElement lastName;
    @FindBy(xpath = "//input[@ng-model='postCd']")
    WebElement postCode;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    public void addCustomerFunctionality(WebDriver driver, String firstName, String lastName, String postCode, String expectedMessage){
        addCustomer.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        submitButton.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }

    @FindBy(xpath = "//button[contains(@ng-click, 'openAccount()')]")
    WebElement openAccount;

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerName;
    @FindBy(xpath = "//select[@id='currency']")
    WebElement currency;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement processButton;
    @FindBy(xpath = "//button[contains(@ng-click, 'showCust()')]")
    WebElement customersButton;
    @FindBy(xpath = "//input[@ng-model='searchCustomer']")
    WebElement searchCustomer;
    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement> allInformation;


    public void openAccountAndCustomerFunctionality(WebDriver driver, String customerName, String currency, String expectedMessage, String firstName, String lastName, String zipcode) throws InterruptedException {
        openAccount.click();
        BrowserUtils.selectBy(this.customerName, customerName, "text");
        BrowserUtils.selectBy(this.currency, currency, "value");
        processButton.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
        customersButton.click();
        Thread.sleep(2000);
        searchCustomer.sendKeys(firstName);
        Thread.sleep(2000);
        List<String> expectedInformation = Arrays.asList(firstName, lastName, zipcode);
        for (int i = 0; i < allInformation.size(); i++) {
            Assert.assertEquals(allInformation.get(i).getText(), expectedInformation.get(i));
        }
    }
}
