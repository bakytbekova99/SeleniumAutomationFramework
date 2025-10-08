package SelfPractice.Project1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Project1HomePage {
    public Project1HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[.=' Signup / Login']")
    WebElement loginButton;
    @FindBy(xpath = "//input[@name='name']")
    WebElement name;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement email;
    @FindBy(xpath = "//button[.='Signup']")
    WebElement singUpButton;
    @FindBy(xpath = "//h2[.='New User Signup!']")
    WebElement text;


    public void loginFunctionality(WebDriver driver, String expectedTitle, String name, String email, String expectedText){
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        loginButton.click();
        Assert.assertEquals(text.getText(), expectedText);
        this.name.sendKeys(name);
        this.email.sendKeys(email);
        singUpButton.click();
    }


}
