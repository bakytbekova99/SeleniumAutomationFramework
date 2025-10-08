package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSAndXPATH {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/alieb/Downloads/codeWiseWebsite.html");
        WebElement header = driver.findElement(By.cssSelector("#codewise1"));//ID(#)
        System.out.println(header.getText());
        WebElement allTools = driver.findElement(By.cssSelector(".group_checkbox"));//Class(.)
        System.out.println(allTools.getText());
        driver.navigate().to("https://the-internet.herokuapp.com/");
        WebElement abTesting = driver.findElement(By.partialLinkText("Testing"));
        abTesting.click();
        WebElement headerAB = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
        System.out.println(headerAB.getText());
        WebElement paragraph = driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        System.out.println(paragraph.getText());

    }
}
