package AlertClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void AcceptAndGetText(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement clickForJS = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        clickForJS.click();
        Alert alert = driver.switchTo().alert();//It switches your driver to JS pop-up
        String actualText = alert.getText();
        String expectedText = "I am a JS Alert";
        Assert.assertEquals(actualText, expectedText);
        alert.accept();//It clicks OK button
        WebElement result = driver.findElement(By.cssSelector("#result"));
        String actualMessage = result.getText();
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    @Test
    public void dismiss(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement confirm = driver.findElement(By.xpath("//button[contains(@onclick, 'jsConfirm')]"));
        confirm.click();
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText = "I am a JS Confirm";
        Assert.assertEquals(actualText, expectedText);
        alert.dismiss();
        WebElement result = driver.findElement(By.cssSelector("#result"));
        String actualMessage = result.getText();
        String expectedMessage = "You clicked: Cancel";
        Assert.assertEquals(actualMessage, expectedMessage);
        WebElement prompt = driver.findElement(By.xpath("//button[contains(@onclick, 'jsPrompt')]"));
        prompt.click();
        alert.sendKeys("I love this");
        alert.accept();
        System.out.println(prompt.getText());

    }
}
