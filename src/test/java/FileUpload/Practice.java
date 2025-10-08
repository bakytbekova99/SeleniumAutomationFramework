package FileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Practice {
    @Test
    public void fileUpload() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("C:\\Users\\alieb\\OneDrive\\Desktop\\usa.png");
        WebElement upload = driver.findElement(By.cssSelector("#file-submit"));
        upload.click();
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(header.getText());
    }
    @Test
    public void practiceUpload() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement chooseFile = driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseFile.sendKeys("C:\\Users\\alieb\\OneDrive\\Desktop\\usa.png");
        WebElement terms = driver.findElement(By.cssSelector("#terms"));
        terms.click();
        WebElement submit = driver.findElement(By.xpath("//button[@type='button']"));
        submit.click();
        Thread.sleep(3000);
        WebElement message = driver.findElement(By.xpath("//h3[@id='res']/center"));
        Assert.assertTrue(message.getText().contains("successfully uploaded"));



    }
}
