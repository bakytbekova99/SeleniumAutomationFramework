package Selenium_Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsPractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> links = driver.findElements(By.xpath("//li"));
        int counter = 0;
        for (WebElement link : links) {
            System.out.println(link.getText());
            counter++;
        }
        System.out.println("Counter: " + counter);
        System.out.println(links.size());
        int count = 0;
        for (WebElement element : links) {
            if (element.getText().length() > 12){
                System.out.println(element.getText());
                count++;
            }
        }
        System.out.println(count);
    }
}
