package com.qa.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BlazeLaptopPage {
    public BlazeLaptopPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[.='MacBook Pro']")
    WebElement MacBookProButton;
    @FindBy(tagName = "h2")
    WebElement header;
    @FindBy(tagName = "h3")
    WebElement price;
    @FindBy(xpath = "//div[@id='more-information']//p")
    WebElement description;
    @FindBy(xpath = "//a[.='Add to cart']")
    WebElement addToCartButton;

    public void productInformation(WebDriver driver, String expectedHeader, String expectedPrice, String expectedMessage) throws InterruptedException {
        BrowserUtils.JSScroll(driver, MacBookProButton);
        MacBookProButton.click();
        Assert.assertEquals(header.getText(), expectedHeader);
        Assert.assertEquals(price.getText(), expectedPrice);
        Assert.assertTrue(description.getText().contains(expectedHeader));
        addToCartButton.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), expectedMessage);
        alert.accept();
    }
}
