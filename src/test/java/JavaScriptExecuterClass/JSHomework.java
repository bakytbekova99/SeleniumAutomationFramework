package JavaScriptExecuterClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class JSHomework {
    @Test
    public void homework() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://candymapper.com/");
        WebElement xButton = driver.findElement(By.cssSelector("#popup-widget307423-close-icon"));
        xButton.click();
        WebElement contactUs = driver.findElement(By.xpath("//span[.='Contact Us']"));
        BrowserUtils.JSScroll(driver, contactUs);
        WebElement firstName = driver.findElement(By.xpath("//input[@data-aid='First Name']"));
        Actions actions = new Actions(driver);
        actions.sendKeys(firstName, "Aliyah").perform();
        WebElement lastName = driver.findElement(By.xpath("//input[@data-aid='Last Name']"));
        actions.sendKeys(lastName, "Bakytbekova").perform();
        WebElement email = driver.findElement(By.xpath("//input[@data-aid='CONTACT_FORM_EMAIL']"));
        email.sendKeys("monpouss@gmail.com");
        WebElement phone = driver.findElement(By.xpath("//input[@data-aid='By entering a Phone Number you agree to our SMS Terms of Service']"));
        phone.sendKeys("7328960965");
        WebElement message = driver.findElement(By.xpath("//textarea[@placeholder='Message']"));
        message.sendKeys("Hello, how are you?");
        BrowserUtils.JSScroll(driver, message);
        Thread.sleep(3000);
        WebElement sumbit = driver.findElement(By.xpath("//button[@data-aid='CONTACT_SUBMIT_BUTTON_REND']"));
        BrowserUtils.JSClick(driver, sumbit);
        WebElement thankYou = driver.findElement(By.xpath("//span[.='Thank you for your inquiry! We will get back to you within 48 Years.']"));
        String actualMessage = thankYou.getText();
        String expectedMessage = "Thank you for your inquiry! We will get back to you within 48 Years.";
        Assert.assertEquals(actualMessage, expectedMessage);
        driver.quit();


    }
}
