package com.qa.spruce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpruceHomePage {
    public SpruceHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement ingredients;
    @FindBy(xpath = "//a[.='Fish & Seafood']")
    WebElement fishAndSeafood;

    public void ingredientsFunctionality(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(ingredients).perform();
        actions.click(fishAndSeafood).perform();
    }
}
