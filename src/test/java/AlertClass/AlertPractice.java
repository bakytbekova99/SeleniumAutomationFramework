package AlertClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertPractice {
    @Test
    public void practice(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
        WebElement alertBox = driver.findElement(By.xpath("//button[@id='alertBox']"));
        alertBox.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        WebElement confirmBox = driver.findElement(By.xpath("//button[@id='confirmBox']"));
        confirmBox.click();
        System.out.println(alert.getText());
        alert.dismiss();
        WebElement promptBox = driver.findElement(By.xpath("//button[@id='promptBox']"));
        promptBox.click();
        alert.sendKeys("Hello there!");
        alert.accept();
        WebElement result = driver.findElement(By.cssSelector("#output"));
        System.out.println(result.getText());



    }
}
