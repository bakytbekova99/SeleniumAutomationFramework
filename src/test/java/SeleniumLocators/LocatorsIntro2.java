package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/alieb/Downloads/codeWiseWebsite.html");
        //LOCATOR: TAGNAME
        WebElement version = driver.findElement(By.tagName("u"));
        System.out.println(version.getText());
        //LOCATOR: linkText (tagName must be a)
        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        System.out.println(javaHeader.getText());
        driver.navigate().back();
        WebElement seleniumHeader = driver.findElement(By.linkText("Selenium"));
        seleniumHeader.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        WebElement seleniumText = driver.findElement(By.tagName("h1"));
        System.out.println(seleniumText.getText());
        driver.navigate().back();
        WebElement cucumberHeader = driver.findElement(By.linkText("Cucumber"));
        cucumberHeader.click();
        WebElement header = driver.findElement(By.className("hero__title"));
        System.out.println(header.getText());
        driver.navigate().back();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().refresh();

        //LOCATOR: PARTIAL LINK TEXT
        WebElement restAPI = driver.findElement(By.partialLinkText("Rest"));
        restAPI.click();
        Thread.sleep(5000);
        driver.quit();







    }
}
