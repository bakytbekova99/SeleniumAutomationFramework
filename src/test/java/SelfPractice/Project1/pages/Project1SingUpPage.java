package SelfPractice.Project1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class Project1SingUpPage {
    public Project1SingUpPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//b[.='Enter Account Information']")
    WebElement accountInfoText;
    @FindBy(css = "#id_gender2")
    WebElement gender;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#days")
    WebElement day;
    @FindBy(css = "#months")
    WebElement month;
    @FindBy(css = "#years")
    WebElement year;
    @FindBy(css = "#newsletter")
    WebElement newsletterBox;
    @FindBy(css = "#optin")
    WebElement specialOffersBox;
    @FindBy(css = "#first_name")
    WebElement firstName;
    @FindBy(css = "#last_name")
    WebElement lastName;
    @FindBy(css = "#company")
    WebElement company;
    @FindBy(css = "#address1")
    WebElement address;
    @FindBy(css = "#country")
    WebElement country;
    @FindBy(css = "#state")
    WebElement state;
    @FindBy(css = "#city")
    WebElement city;
    @FindBy(css = "#zipcode")
    WebElement zipcode;
    @FindBy(css = "#mobile_number")
    WebElement mobileNumber;
    @FindBy(xpath = "//button[.='Create Account']")
    WebElement createAccountButton;


    public void signUpPageFunctionality(WebDriver driver, String expectedText, String password, String firstName, String lastName, String company, String address,
                                        String state, String city, String zipcode, String number){
        Assert.assertEquals(accountInfoText.getText(), expectedText);
        if (gender.isDisplayed() && gender.isEnabled() && !gender.isSelected()){
            gender.click();
        }
        this.password.sendKeys(password);
        BrowserUtils.selectBy(day, "9", "text");
        BrowserUtils.selectBy(month, "August", "text");
        BrowserUtils.selectBy(year, "1999", "text");
        BrowserUtils.JSClick(driver, newsletterBox);
        BrowserUtils.JSClick(driver, specialOffersBox);
//        if (newsletterBox.isDisplayed() && newsletterBox.isEnabled() && !newsletterBox.isSelected()){
//            newsletterBox.click();
//        }
//        if (specialOffersBox.isDisplayed() && specialOffersBox.isEnabled() && !specialOffersBox.isSelected()){
//            specialOffersBox.click();
//        }
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.company.sendKeys(company);
        this.address.sendKeys(address);
        BrowserUtils.selectBy(country, "United States", "text");
        this.state.sendKeys(state);
        this.city.sendKeys(city);
        this.zipcode.sendKeys(zipcode);
        this.mobileNumber.sendKeys(number);
        BrowserUtils.JSClick(driver, createAccountButton);

    }



}
