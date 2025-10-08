package com.qa.saucelab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;

public class SauceLabHomePage {
    public SauceLabHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#user-name")
    WebElement username;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#login-button")
    WebElement loginButton;
    @FindBy(tagName = "h3")
    WebElement message;

    public void homePageFunctionality(WebDriver driver, String username, String password, String expectedURL, String expectedTitle){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertEquals(driver.getTitle(), expectedTitle);

    }
    public void negativeLogin(String username, String password, String expectedMessage){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }
}
