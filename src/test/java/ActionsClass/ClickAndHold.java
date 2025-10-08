package ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ClickAndHold {
    @Test
    public void clickAndHold() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement cookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookies.click();
        Actions actions = new Actions(driver);
        actions.scrollByAmount(300, 300).perform();
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppable = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualText = droppable.getText();
        String expectedText = "Drag the small circle here ...";
        Assert.assertEquals(actualText, expectedText);
        actions.clickAndHold(draggable).moveToElement(droppable).release().perform();
        droppable = driver.findElement(By.xpath("//div[@class='test1']"));
        actualText = droppable.getText();
        expectedText = "You did great!";
        Assert.assertEquals(actualText, expectedText);

    }

    @Test
    public void practiceClickAndHold() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement acceptButton = driver.findElement(By.cssSelector("#droppableExample-tab-accept"));

        Actions actions = new Actions(driver);

        actions.scrollByAmount(300, 300).perform();

        actions.click(acceptButton).perform();

        WebElement acceptableButton = driver.findElement(By.cssSelector("#acceptable"));
        WebElement notAcceptableButton = driver.findElement(By.cssSelector("#notAcceptable"));
        WebElement droppable = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));


        String actualText = droppable.getText();
        String expectedText = "Drop here";
        Thread.sleep(3000);
        Assert.assertEquals(actualText, expectedText);


        actions.clickAndHold(notAcceptableButton).moveToElement(droppable).release().perform();

        actualText = droppable.getText();
        expectedText = "Drop here";

        Assert.assertEquals(actualText, expectedText);

        actions.clickAndHold(acceptableButton).moveToElement(droppable).release().perform();

        actualText = droppable.getText();
        expectedText = "Dropped!";

        Assert.assertEquals(actualText, expectedText);




        /*
1-Navigate to the website
  -->Click Accept Button with actions.click(Accept).perform
2-Validate the text is Box text is "Drop here"
3-Click and Hold Not acceptable box and release into Box
4-Validate the box text is still "Drop here"
5-Click and Hold Acceptable box and release into Box
6-Validate box text is "Dropped!"

 */
    }

}
