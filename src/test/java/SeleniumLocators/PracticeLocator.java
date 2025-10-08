package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeLocator {
    public static void main(String[] args) throws InterruptedException {
        //1-Navigate to the https://formy-project.herokuapp.com/form
        //2-Fill all the blanks
        //3-use isDisplayed,isEnabled,isSelected for the buttons
        //4-For the experience and date use send keys
        //5-Click Submit Button
        //6-Validate the header is "Thanks for submitting your form"
        //7-Quit your driver
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://formy-project.herokuapp.com/form");
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Aliyah");
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Bakytbekova");
        WebElement jobTitle = driver.findElement(By.id("job-title"));
        jobTitle.sendKeys("developer");
        WebElement levelOfEducation = driver.findElement(By.id("radio-button-3"));
        if (levelOfEducation.isDisplayed() && levelOfEducation.isEnabled() && !levelOfEducation.isSelected()){
            levelOfEducation.click();
        }
        WebElement sex = driver.findElement(By.id("checkbox-2"));
        if (sex.isDisplayed() && sex.isEnabled() && !sex.isSelected()){
            sex.click();
        }
        WebElement yearsOfEx = driver.findElement(By.id("select-menu"));
        yearsOfEx.sendKeys("2-4");
        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("08/08/2024");
        WebElement button = driver.findElement(By.linkText("Submit"));
        button.click();
        Thread.sleep(2000);
        WebElement validation = driver.findElement(By.tagName("h1"));
        String actualText = validation.getText();
        String expectedText = "Thanks for submitting your form";
        System.out.println(actualText.equals(expectedText) ? "Passed":"Failed");
        Thread.sleep(2000);
        driver.quit();
    }
}
