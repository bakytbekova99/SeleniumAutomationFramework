package Selenium_Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElements {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //way to wait for element to be loaded on the website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///C:/Users/alieb/Downloads/codeWiseWebsite.html");
        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement box: allBoxes){
            if (box.isDisplayed() && box.isEnabled() && !box.isSelected()){
                box.click();
            }
            Thread.sleep(1000);
        }
    }
}
