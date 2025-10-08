package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectBasics {
    @Test
    public void selectMethods() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select option = new Select(dropDown);

        String actualDefaultValue = option.getFirstSelectedOption().getText();
        String expectedValue = "Please select an option";
        Assert.assertEquals(actualDefaultValue, expectedValue);

        option.selectByVisibleText("Option 1"); //goes with the text value
        Thread.sleep(5000);
        option.selectByValue("2"); //goes with the value attribute's vale
        Thread.sleep(2000);
        option.selectByIndex(1); // go  es with index number of value
        List<WebElement> allOptions = option.getOptions();
        List<String> exceptedOptions = Arrays.asList("Please select an option", "Option 1", "Option 2");
        for (int i = 0; i < allOptions.size(); i++) {
            Assert.assertEquals(allOptions.get(i).getText(), exceptedOptions.get(i));
        }





    }
}
