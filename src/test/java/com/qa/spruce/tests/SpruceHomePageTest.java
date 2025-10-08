package com.qa.spruce.tests;

import com.qa.spruce.pages.SpruceFishAndSeafoodPage;
import com.qa.spruce.pages.SpruceHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SpruceHomePageTest extends SpruceTestBase{
    @Parameters({"word", "product"})
    @Test
    public void validateHomePageFunctionality(String word, String product) throws InterruptedException {
        SpruceHomePage spruceHomePage = new SpruceHomePage(driver);
        spruceHomePage.ingredientsFunctionality(driver);
        SpruceFishAndSeafoodPage spruceFishAndSeafoodPage = new SpruceFishAndSeafoodPage(driver);
        spruceFishAndSeafoodPage.searchFunctionality(driver, word, product);

    }
}
