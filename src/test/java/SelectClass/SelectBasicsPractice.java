package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectBasicsPractice {
    /*
1-Validate the default value is "UNITED STATES"
2-Choose Your own country with "VisibleText" Method Thread.sleep to see how it is changing
3-Choose your favorite country with "value" method Thread.sleep
4-Choose the country you do not want to visit "index" Thread.sleep
5-Validate the number of countries is 264
6-Print out all the countries
7-driver.quit()
 */
    @Test
    public void task1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///C:/Users/alieb/Downloads/codeWiseWebsite.html");
        WebElement lists = driver.findElement(By.xpath("//select[@name='country']"));
        Select option = new Select(lists);
        String actualDefaultValue = option.getFirstSelectedOption().getText();
        String expectedValue = "UNITED STATES";
        Assert.assertEquals(actualDefaultValue, expectedValue);
        option.selectByVisibleText("KYRGYZSTAN");
        Thread.sleep(2000);
        option.selectByValue("2");
        Thread.sleep(2000);
        option.selectByIndex(20);
        Thread.sleep(2000);
        List<WebElement> countries = option.getOptions();
        Assert.assertEquals(countries.size(), 264);
        for (WebElement country : countries) {
            System.out.println("country.getText() = " + country.getText());
        }





    }
}
