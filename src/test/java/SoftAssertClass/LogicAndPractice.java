package SoftAssertClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LogicAndPractice {
    public int getSum(int number1, int number2){
        return number1 + number2;
    }
    @Test
    public void hardAssert(){
        Assert.assertEquals(getSum(1, 5), 6);
        System.out.println("Test1");
        Assert.assertEquals(getSum(6, 5), 11);
        System.out.println("Test2");
        Assert.assertEquals(getSum(5,8), 13);
        System.out.println("Test3");
        // NOTE: When hard Assert fails, it does not go to the next line.
        //It stops the execution of the code
    }
    @Test
    public void softAssert(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getSum(1, 5), 6);
        System.out.println("Test1");
        softAssert.assertEquals(getSum(5, 7), 11);
        System.out.println("Test2");
        softAssert.assertEquals(getSum(3, 5), 8);
        System.out.println("Test3");
        softAssert.assertAll();
        //NOTE: When soft Assert fails, it continues executing the code
        //You need to activate with AssertAll method
        //You need to create an object of SoftAssert
    }
    @Test
    public void practiceDragAndDrop(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(driver);
        WebElement bigBox = driver.findElement(By.xpath("//div[@id='droppable']"));
        String actualText = bigBox.getText();
        String excpectedText = "Drop here";
//        Assert.assertEquals(actualText, excpectedText);

        softAssert.assertEquals(actualText, excpectedText);

        WebElement smallBox = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='draggable']"));
        actions.dragAndDrop(smallBox, bigBox).perform();
        actualText = bigBox.getText();
        excpectedText = "Dropped!";
//        Assert.assertEquals(actualText, excpectedText);

        softAssert.assertEquals(actualText, excpectedText);

        actions.scrollToElement(bigBox).perform();
        String actualColor = bigBox.getCssValue("background-color");
        String expectedColor = "rgba(70, 130, 180, 1)";
//        Assert.assertEquals(actualColor, expectedColor);

        softAssert.assertEquals(actualColor, expectedColor);
        softAssert.assertAll();
    }
}
