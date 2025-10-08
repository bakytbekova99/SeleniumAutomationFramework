package com.qa.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeCartPage {
    public BlazeCartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@class='btn btn-success']")
    WebElement placeOrderButton;

    public void placeOrderButton(){
        placeOrderButton.click();
    }
}
