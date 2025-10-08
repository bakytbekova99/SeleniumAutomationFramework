package com.qa.spruce.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class SpruceFishAndSeafoodPage {
    public SpruceFishAndSeafoodPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#search-form-input")
    WebElement searchBox;
    @FindBy(xpath = "//label[@for='starRating_score_4Star']")
    WebElement fourStarRating;

    @FindBy(xpath = "//label[@for='pop_search_editor']")
    WebElement editorChoice;

    @FindBy(css = ".card__underline")
    WebElement product;

    public void searchFunctionality(WebDriver driver, String search, String expectedProduct) throws InterruptedException {
        BrowserUtils.JSScroll(driver, searchBox);
        Thread.sleep(2000);
        this.searchBox.sendKeys(search, Keys.ENTER);
        fourStarRating.click();
        editorChoice.click();
        Thread.sleep(2000);
        Assert.assertEquals(product.getText(), expectedProduct);
    }

}
