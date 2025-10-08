package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class DreamCar {
    @Test
    public void task() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cars.com/shopping/");
        Thread.sleep(2000);
        WebElement condition = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(condition, "New & certified", "text");
        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make, "Lexus", "text");
        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model, "  RX 350", "text");
        WebElement price = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select select = new Select(price);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "No max price");
        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance, " 40 miles", "text");
        WebElement zip = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zip.clear();
        Thread.sleep(2000);
        zip.sendKeys("77042");
        zip.sendKeys(Keys.ENTER);
        WebElement header = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(header.getText().contains("New and certified used Lexus RX 350 for sale"));
        List<WebElement> list = driver.findElements(By.xpath("//h2[@class='title']"));
        for (WebElement element : list) {
            Assert.assertTrue(element.getText().contains("Lexus RX 350"));
        }
        System.out.println("Validation passed");
        driver.quit();


    }
}
