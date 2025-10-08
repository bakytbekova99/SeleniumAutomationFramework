package JavaScriptExecuterClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class JavaScriptMethods {
    @Test
    public void clickJS(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codewise.academy/");
        WebElement aboutUs = driver.findElement(By.xpath("//*[@id=\"rec673496367\"]/div/div/div[7]/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", aboutUs);
    }
    @Test
    public void practice() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click()", button);
        BrowserUtils.JSClick(driver, button);
        WebElement text = driver.findElement(By.className("mt-3"));
        String actualText = text.getText();
        Assert.assertTrue(actualText.contains("Impressive"));

    }
    @Test
    public void scrollIntoView() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codewise.academy/");
        WebElement applyNow = driver.findElement(By.xpath("//*[@id=\"rec672682366\"]/div/div/div[27]/a"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true)", applyNow);
        BrowserUtils.JSScroll(driver, applyNow);
        Thread.sleep(3000);
        BrowserUtils.JSClick(driver, applyNow);


    }
}
