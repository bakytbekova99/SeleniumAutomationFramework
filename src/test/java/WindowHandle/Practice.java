package WindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class Practice {
    @Test
    public void practice() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button4 = driver.findElement(By.xpath("//h3[.='Button4']"));
        BrowserUtils.JSScroll(driver, button4);
        WebElement multipleTabs = driver.findElement(By.cssSelector("#newTabsBtn"));
        BrowserUtils.JSClick(driver, multipleTabs);
        Thread.sleep(2000);
        BrowserUtils.switchWindow(driver, "Basic Controls - H Y R Tutorials");
        Thread.sleep(2000);
        WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
        BrowserUtils.JSScroll(driver, firstName);
        firstName.sendKeys("Aliyah");
        WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("Bakytbekova");
        WebElement gender = driver.findElement(By.cssSelector("#femalerb"));
        gender.click();
        WebElement language = driver.findElement(By.cssSelector("#englishchbx"));
        language.click();
        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("monpouss@gmail.com");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("i6qDWowGBPf");
        WebElement register = driver.findElement(By.cssSelector("#registerbtn"));
        BrowserUtils.JSClick(driver, register);
        WebElement actualText = driver.findElement(By.cssSelector("#msg"));
        String expectedText = "Registration is Successful";
        Assert.assertEquals(actualText.getText(), expectedText);
        String actualColor = actualText.getCssValue("color");
        String expectedColor = "rgba(0, 128, 0, 1)";
        Assert.assertEquals(actualColor, expectedColor);
        BrowserUtils.switchWindow(driver, "Window Handles Practice - H Y R Tutorials");
        WebElement actualHeader = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        String expectedHeader = "Window Handles Practice";
        Assert.assertEquals(actualHeader.getText(), expectedHeader);
        BrowserUtils.switchWindow(driver, " AlertsDemo -  H Y R Tutorials");
        WebElement demoHeader = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        String actualDemo = "AlertsDemo";
        Assert.assertEquals(demoHeader.getText(), actualDemo);
        WebElement clickMe = driver.findElement(By.cssSelector("#promptBox"));
        clickMe.click();


        /*
       1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
       2-scroll down to button 4 and Click open multiple tabs under Button 4
       3-the Basic Control and fill all the blanks (JS CLICK MIght work if regular does not)
       4-Click Register button and validate the message "Registration is Successful" and color
       5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
       6- go to the AlertsDemo page and validate "AlertsDemo" then click  the "Click Me" button under prompt box
       7-Proud of yourself
*/
    }
}
