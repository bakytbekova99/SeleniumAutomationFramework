package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class MidLevelPractice {
    @Test
    public void practice() throws InterruptedException {
                /*
1-Navigate to the website (https://demo.guru99.com/test/newtours/reservation.php)
2-Select one way trip button
3-Choose 4 passangers
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message from header which should be "After flight finder - No Seats Available" (you can use font_size=4)

 NOTE:Your test should fail
 NOTE2:You can use any select method value,visibleText
 nOTE3:send the bug picture
 */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement type = driver.findElement(By.xpath("//input[@name='tripType']"));
        if (type.isDisplayed() && type.isEnabled() && !type.isSelected()){
            type.click();
        }
        WebElement passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select option = new Select(passengers);
        option.selectByValue("4");
        WebElement departing = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select option1 = new Select(departing);
        String defaultValue = option1.getFirstSelectedOption().getText();
        String expectedValue = "Acapulco";
        Assert.assertEquals(defaultValue, expectedValue);
        option1.selectByIndex(4);
        WebElement onDate = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select option2 = new Select(onDate);
        option2.selectByVisibleText("August");
        WebElement day = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select option3 = new Select(day);
        option3.selectByVisibleText("15");
        WebElement arriving = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select option4 = new Select(arriving);
        option4.selectByVisibleText("San Francisco");
        WebElement onReturn = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select option5 = new Select(onReturn);
        option5.selectByVisibleText("December");
        WebElement dateReturn = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select option6 = new Select(dateReturn);
        option6.selectByVisibleText("15");
        Thread.sleep(2000);
        WebElement classF = driver.findElement(By.xpath("//input[@value='First']"));
        classF.click();
        WebElement airlineOp = driver.findElement(By.xpath("//select[@name='airline']"));
        Select option7 = new Select(airlineOp);
        List<WebElement> airlineList = option7.getOptions();
        List<String> exceptedOptions = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i = 0; i < airlineList.size(); i++) {
            Assert.assertEquals(airlineList.get(i).getText(), exceptedOptions.get(i));
        }
        option7.selectByVisibleText("Unified Airlines");
        Thread.sleep(7000);

        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
        String expected = "After flight finder - No Seats Available";
        Assert.assertEquals(message.getText(), expected);






    }
    @Test
    public void practiceWithUtils() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement type = driver.findElement(By.xpath("//input[@name='tripType']"));
        if (type.isDisplayed() && type.isEnabled() && !type.isSelected()){
            type.click();
        }
        WebElement passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passengers, "4", "text");
        WebElement departing = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select option1 = new Select(departing);
        String defaultValue = option1.getFirstSelectedOption().getText();
        String expectedValue = "Acapulco";
        Assert.assertEquals(defaultValue, expectedValue);
        option1.selectByIndex(4);
        WebElement onDate = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select option2 = new Select(onDate);
        option2.selectByVisibleText("August");
        WebElement day = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select option3 = new Select(day);
        option3.selectByVisibleText("15");
        WebElement arriving = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(arriving, "San Francisco", "text");
        WebElement onReturn = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select option5 = new Select(onReturn);
        option5.selectByVisibleText("December");
        WebElement dateReturn = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select option6 = new Select(dateReturn);
        option6.selectByVisibleText("15");
        Thread.sleep(2000);
        WebElement classF = driver.findElement(By.xpath("//input[@value='First']"));
        classF.click();
        WebElement airlineOp = driver.findElement(By.xpath("//select[@name='airline']"));
        Select option7 = new Select(airlineOp);
        List<WebElement> airlineList = option7.getOptions();
        List<String> exceptedOptions = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i = 0; i < airlineList.size(); i++) {
            Assert.assertEquals(airlineList.get(i).getText(), exceptedOptions.get(i));
        }
        option7.selectByVisibleText("Unified Airlines");
        Thread.sleep(7000);

        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
        String expected = "After flight finder - No Seats Available";
        Assert.assertEquals(message.getText(), expected);

    }
}
