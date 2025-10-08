package com.qa.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlazeOrderPage {
    public BlazeOrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#name")
    WebElement name;
    @FindBy(css = "#country")
    WebElement country;
    @FindBy(css = "#city")
    WebElement city;
    @FindBy(css = "#card")
    WebElement creditCard;
    @FindBy(css = "#month")
    WebElement month;
    @FindBy(css = "#year")
    WebElement year;
    @FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    WebElement purchaseButton;
    @FindBy(xpath = "//h2[.='Thank you for your purchase!']")
    WebElement thanksMessage;
    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public void placeOrderFunctionality(String name, String country, String city, String creditCard, String month, String year, String expectedMessage){
        this.name.sendKeys(name);
        this.country.sendKeys(country);
        this.city.sendKeys(city);
        this.creditCard.sendKeys(creditCard);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
        purchaseButton.click();
        Assert.assertEquals(thanksMessage.getText(), expectedMessage);
        okButton.click();

    }
}
