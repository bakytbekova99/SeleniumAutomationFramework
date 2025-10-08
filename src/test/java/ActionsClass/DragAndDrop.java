package ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDrop {
    @Test
    public void dragAndDrop() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement cookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookies.click();
        Actions actions = new Actions(driver);
        actions.scrollByAmount(300,300).perform();
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessage = orangeBox.getText();
        String expectedMessage = "... Or here.";
        Assert.assertEquals(actualMessage, expectedMessage);
        actions.dragAndDrop(draggable, orangeBox).perform();
        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        actualMessage = orangeBox.getText();
        expectedMessage = "You did great!";
        String actualColor = orangeBox.getCssValue("background-color");
        String expectedColor = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualColor, expectedColor);
        Assert.assertEquals(actualMessage, expectedMessage); 

    }
    @Test
    public void practiceDragAndDrop(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        Actions actions = new Actions(driver);
        WebElement bigBox = driver.findElement(By.xpath("//div[@id='droppable']"));
        String actualText = bigBox.getText();
        String excpectedText = "Drop here";
        Assert.assertEquals(actualText, excpectedText);
        WebElement smallBox = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='draggable']"));
        actions.dragAndDrop(smallBox, bigBox).perform();
        actualText = bigBox.getText();
        excpectedText = "Dropped!";
        Assert.assertEquals(actualText, excpectedText);
        actions.scrollToElement(bigBox).perform();
        String actualColor = bigBox.getCssValue("background-color");
        String expectedColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor, expectedColor);
    }

}
