package com.qa.blaze.pages;

import com.qa.blaze.tests.BlazeTestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlazeSignUpPage extends BlazeTestBase {
    public BlazeSignUpPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#sign-username")
    WebElement username;
    @FindBy(css = "#sign-password")
    WebElement password;
    @FindBy(xpath = "//button[contains(@onclick, 'register()')]")
    WebElement registerButton;

    public void signUpFunctionality(WebDriver driver, String username, String password, String expectedMessage) throws InterruptedException {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        registerButton.click();
        Thread.sleep(2000);
        Alert alert =driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), expectedMessage);
        alert.accept();
    }
}
