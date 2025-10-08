package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathLocator {
    public static void main(String[] args) throws InterruptedException {
        /*
        STRUCTURE OF THE XPATH:
        1. //TAGNAME[@Attribute='AttributeValue'] -> ATTRIBUTES
        2. //TAGNAME[contains(text),'textValue')] -> CONTAINS TEXT -> part of text
        3. //TAGNAME[.='TEXTVALUE'] -> 100% MATCH UP TEXT VALUE -> full sentence
         */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=account/register");
        WebElement fisrtName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        fisrtName.sendKeys("Aliyah");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Bakytbekova");
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("monllapin@gmail.com");
        WebElement phone = driver.findElement(By.xpath("//input[@name='telephone']"));
        phone.sendKeys("8324757139");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("1234hororor");
        WebElement confirmation = driver.findElement(By.xpath("//input[@placeholder='Password Confirm']"));
        confirmation.sendKeys("1234hororor");
        Thread.sleep(2000);
        WebElement agreement = driver.findElement(By.xpath("//input[@name='agree']"));
        if (agreement.isDisplayed() && agreement.isEnabled() && !agreement.isSelected()){
            agreement.click();
            System.out.println("Clicked");
        } else {
            System.out.println("Not clicked");
        }
        Thread.sleep(2000);
        WebElement submit = driver.findElement(By.xpath("//input[@value='Continue']"));
        submit.click();
        String actual = driver.getCurrentUrl();
        String expected = "https://tutorialsninja.com/demo/index.php?route=account/register";
        System.out.println(actual.equals(expected) ? "PASSED" : "FAILED");








    }
}
