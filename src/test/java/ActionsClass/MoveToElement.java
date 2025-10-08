package ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveToElement {
    @Test
    public void moveToElement() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> allImages = driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        List<WebElement> allNames = driver.findElements(By.tagName("h5"));
        Actions actions = new Actions(driver);
        for (int i = 0; i < allNames.size(); i++) {
            actions.moveToElement(allImages.get(i)).perform();
            System.out.println(allNames.get(i).getText());
            Thread.sleep(1000);
        }
    }
    @Test
    public void practiceHoverOver() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        Thread.sleep(2000);
        WebElement cookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookies.click();
        Actions actions = new Actions(driver);
        actions.scrollByAmount(400,400).perform();
        List<WebElement> allImages = driver.findElements(By.xpath("//div[@class='product k-listview-item']//img"));
        List<WebElement> allNames = driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='product-description']//p"));
        Map<String, String> allProduct = new HashMap<>();
        for (int i = 0; i < allImages.size(); i++) {
            actions.moveToElement(allImages.get(i)).perform();
            allProduct.put(allNames.get(i).getText(), allPrices.get(i).getText());
        }
        System.out.println("allProduct = " + allProduct);
        /*
     1-Navigate to the website https://demos.telerik.com/kendo-ui/fx/expand
     2-Accept Cookies if it pop ups.(Be careful about timing)
     3-Use actions.scrollByAmount(400,400) or any number to make sure the items look good on your screen if it necessary
     4-Get the all images location as a list (//div[@class='product k-listview-item']//img)
     5-Get the all Names location as a list (//div[@class='product-description']//h3)
     6-Get the all Price location as a list (//div[@class='product-description']//p )
     7-Inside of regular loop Use actions move to element and put in the map (Key will be name , Value will be Price)
     8-Outside of loop, print out Map
     9-Proud of Yourself
      */

    }
}
