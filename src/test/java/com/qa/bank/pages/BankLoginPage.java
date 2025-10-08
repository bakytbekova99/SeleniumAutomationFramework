package com.qa.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankLoginPage {
    /*
    1. Under page classes we store our Constructor
    2. Find the elements and store as a WebElement with @FindBy
    3. Create methods with WebElements and manipulations (changes)
     */

    //Constructor will initialize my WebElements by using PageFactory Class
    public BankLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    //STEP 1:
    //FidBy is a way to locate the element
    @FindBy(tagName = "strong")
    WebElement header;

    @FindBy(xpath = "//button[.='Home']")
    WebElement homeButton;

    @FindBy(xpath = "//button[contains(@ng-click, 'customer')]")
    WebElement customerLoginButton;

    @FindBy(xpath = "//button[contains(@ng-click, 'manager')]")
    WebElement managerLoginButton;

    //STEP 2:

    public void clickCustomerLoginButton(){
        customerLoginButton.click();
    }
    public void clickManagerLoginButton(){
        managerLoginButton.click();
    }
    public void clickHomeButton(){
        homeButton.click();
    }

    public void checkLoginPageInformation(String expectedHeader, String expectedColor){
        Assert.assertEquals(header.getText(), expectedHeader);
        Assert.assertTrue(homeButton.isDisplayed() && homeButton.isEnabled());
        Assert.assertTrue(customerLoginButton.isDisplayed() && customerLoginButton.isEnabled());
        Assert.assertTrue(managerLoginButton.isDisplayed() && managerLoginButton.isEnabled());
        Assert.assertEquals(customerLoginButton.getCssValue("background-color"), expectedColor);
        Assert.assertEquals(managerLoginButton.getCssValue("background-color"), expectedColor);



    }

}
