package Selenium_Intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealLifeTestCase {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        String actualURL = driver.getCurrentUrl();
        String exoectedURL = "https://www.amazon.com/";
        if (actualURL.equals(exoectedURL)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        Thread.sleep(2000);
        driver.close();
    }
}
