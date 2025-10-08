package SelfPractice.Project1.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class Project1FinalPage {
    public Project1FinalPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//b[.='Account Created!']")
    WebElement accountCreatedText;
    @FindBy(xpath = "//a[.='Continue']")
    WebElement continueButton;
    @FindBy(xpath = "//b[.='Aliyah']")
    WebElement visibleName;
    @FindBy(xpath = "//a[contains(text(), ' Delete Account')]")
    WebElement deleteAccount;
    @FindBy(xpath = "//h2[@data-qa='account-deleted']")
    WebElement deletedText;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueB;

    public void finalPageFunctionality(WebDriver driver, String expectedText, String expectedName, String expectedHeader) throws InterruptedException {
        Assert.assertEquals(accountCreatedText.getText(), expectedText);
        continueButton.click();
        Assert.assertEquals(visibleName.getText(), expectedName);
        Thread.sleep(5000);
        deleteAccount.click();
        Assert.assertEquals(deletedText.getText(), expectedHeader);
        continueB.click();
    }
}
