package com.qa.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeHomePage {
    public BlazeHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "signin2")
    WebElement singUpButton;
    @FindBy(css = "#login2")
    WebElement logInButton;
    @FindBy(xpath = "//a[.='Laptops']")
    WebElement laptopsButton;
    @FindBy(css = "#cartur")
    WebElement cartButton;

    public void signUpButton(){
        singUpButton.click();
    }
    public void logInButton(){
        logInButton.click();
    }
    public void laptopsButton(){
        laptopsButton.click();
    }
    public void cartButton(){
        cartButton.click();
    }
}
