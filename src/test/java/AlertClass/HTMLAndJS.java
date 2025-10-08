package AlertClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.JsonOutput;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class HTMLAndJS {
    @Test
    public void practice() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://sweetalert.js.org/");
        Actions actions = new Actions(driver);
        actions.scrollByAmount(300, 300);
        WebElement jsPopUp = driver.findElement(By.xpath("//button[contains(@onclick, 'alert')]"));
        jsPopUp.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        WebElement htmlPopUp = driver.findElement(By.xpath("//button[contains(@onclick, 'swal')]"));
        htmlPopUp.click();
        Thread.sleep(2000);
        WebElement message = driver.findElement(By.xpath("//div[.='Something went wrong!']"));
        System.out.println(message.getText());
        WebElement button = driver.findElement(By.xpath("//button[.='OK']"));
        button.click();



    }
}
