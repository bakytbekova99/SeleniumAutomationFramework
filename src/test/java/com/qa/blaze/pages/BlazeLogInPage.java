package com.qa.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlazeLogInPage {
    public BlazeLogInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#loginusername")
    WebElement username;
    @FindBy(css = "#loginpassword")
    WebElement password;
    @FindBy(xpath = "//button[@onclick='logIn()']")
    WebElement logInButton;
    @FindBy(css = "#nameofuser")
    WebElement welcome;

    public void logInFunctionality(String username, String password, String expectedText) throws InterruptedException {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        logInButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(welcome.getText().contains(expectedText));
        Assert.assertTrue(welcome.isDisplayed());
    }
}
