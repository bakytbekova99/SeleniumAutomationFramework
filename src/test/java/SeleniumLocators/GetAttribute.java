package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        WebElement username = driver.findElement(By.xpath("//input[@value='John Doe']"));
        System.out.println(username.getText());// will not work
        System.out.println(username.getAttribute("value"));
        System.out.println(username.getAttribute("placeholder"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        System.out.println(password.getAttribute("placeholder"));
    }
}
