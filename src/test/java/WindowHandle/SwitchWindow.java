package WindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchWinwod(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement click = driver.findElement(By.xpath("//a[.='Click Here']"));
        click.click();
        WebElement text = driver.findElement(By.tagName("h3"));
        System.out.println(text.getText());
        Set<String> pageIDs = driver.getWindowHandles();
        System.out.println(pageIDs);
//        for (String pageID : pageIDs) {
//            driver.switchTo().window(pageID);
//            if (driver.getTitle().contains("New Window")){
//                break;
//            }
//        }
        BrowserUtils.switchWindow(driver, "New Window");
        text = driver.findElement(By.tagName("h3"));
        System.out.println(text.getText());

    }
    @Test
    public void practice() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.open('https://codewise.academy/')");
        js.executeScript("window.open('https://www.ebay.com/')");
        js.executeScript("window.open('https://www.etsy.com/')");
        BrowserUtils.switchWindow(driver, "Electronics, Cars, Fashion, Collectibles & More | eBay");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        BrowserUtils.switchWindow(driver, "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        BrowserUtils.switchWindow(driver, "SDET");
        System.out.println(driver.getCurrentUrl());
    }
}
