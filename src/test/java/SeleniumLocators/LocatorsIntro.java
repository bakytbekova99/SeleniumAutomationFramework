package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/alieb/Downloads/codeWiseWebsite.html");

        WebElement header = driver.findElement(By.id("codewise1"));
        String actualHeader = header.getText();
        String expectedHeader = "CodeWise Academy";
        if (actualHeader.equals(expectedHeader)){
            System.out.println("Header Passed");
        } else {
            System.out.println("Header Failed");
        }
        WebElement text = driver.findElement(By.id("details2"));
        String paragraph = text.getText();
        System.out.println(paragraph);

        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Aliyah");
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Bakytbekova");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("8324757130");
        WebElement email = driver.findElement(By.id("userName"));
        email.sendKeys("bakytbekova99@gmail.com");
        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("10755 Meadowglen Ln");
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Houston");
        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("Texas");
        WebElement code = driver.findElement(By.name("postalCode"));
        code.sendKeys("77042");

        WebElement valClass = driver.findElement(By.className("group_checkbox"));
        String answer = valClass.getText();
        String myAnswer = "All Tools";
        System.out.println(answer.equals(myAnswer) ? "PASSED":"FAILED");

        WebElement javaBox = driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed() && javaBox.isEnabled() && !javaBox.isSelected()){
            javaBox.click();
        }
        WebElement testNGBox = driver.findElement(By.id("cond3"));
        if (testNGBox.isDisplayed() && testNGBox.isEnabled() && !testNGBox.isSelected()){
            testNGBox.click();
        }
        WebElement cucumberBox = driver.findElement(By.id("cond4"));
        if (cucumberBox.isDisplayed() && cucumberBox.isEnabled() && !cucumberBox.isSelected()){
            cucumberBox.click();
        }
        Thread.sleep(5000);
        driver.quit();







    }
}
