package WaitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class ExplicitlyWait {
    /*
    1. It is a way to handle wait time issue in Selenium
    2. We need to create an object
    3. We need to provide condition
     */
    @Test
    public void explicitlyWait(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement start = driver.findElement(By.xpath("//button[.='Start']"));
        start.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement text = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        BrowserUtils.waitTime(driver, text);
//        wait.until(ExpectedConditions.visibilityOf(text));
        System.out.println(text.getText());
    }
}
