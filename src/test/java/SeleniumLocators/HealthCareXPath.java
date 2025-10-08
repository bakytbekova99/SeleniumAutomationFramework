package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HealthCareXPath {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        WebElement appoinment = driver.findElement(By.id("btn-make-appointment"));
        appoinment.click();
        WebElement username = driver.findElement(By.xpath("//input[@id='txt-username']"));
        username.sendKeys("John Doe");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement login = driver.findElement(By.xpath("//button[@id='btn-login']"));
        login.click();
        Thread.sleep(5000);
        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");
        WebElement apply = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        if (apply.isDisplayed() && apply.isEnabled() && !apply.isSelected()){
            apply.click();
            System.out.println("Apply for hospital readmission is clicked");
        }
        WebElement medicate = driver.findElement(By.xpath("//input[@name='programs']"));
        if (medicate.isDisplayed() && medicate.isEnabled() && !medicate.isSelected()){
            medicate.click();
            System.out.println("Medicate was chosen");
        }
        WebElement date = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("10/09/2025");
        WebElement comment = driver.findElement(By.xpath("//textarea[@class='form-control']"));
        comment.sendKeys("I love Selenium");
        System.out.println(comment.getText());
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
        Thread.sleep(2000);
        WebElement actualHeader = driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
        String expectedHeader = "Appointment Confirmation";
        if (actualHeader.getText().equals(expectedHeader)){
            System.out.println("HEADER PASSED");
        } else {
            System.out.println("HEADER FAILED");
        }
        WebElement actualFacility = driver.findElement(By.xpath("//p[.='Hongkong CURA Healthcare Center']"));
        String expectedFacility = "Hongkong CURA Healthcare Center";
        if (actualFacility.getText().equals(expectedFacility)){
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        WebElement readmission = driver.findElement(By.xpath("//p[.='Yes']"));
        String expectedProgram = "Yes";
        System.out.println(readmission.getText().equals(expectedProgram) ? "READMISSION PASSED":"READMISSION FAILED");
        WebElement program = driver.findElement(By.xpath("//p[.='Medicare']"));
        String expected = "Medicare";
        System.out.println(program.getText().equals(expected)? "PROGRAM PASSED":"PROGRAM FAILED");
        WebElement actualDate = driver.findElement(By.xpath("//p[.='10/09/2025']"));
        String expectedDate = "10/09/2025";
        System.out.println(actualDate.getText().equals(expectedDate) ? "DATE PASSED":"DATE FAILED");
        WebElement actualComment = driver.findElement(By.xpath("//p[.='I love Selenium']"));
        String expectedComment ="I love Selenium";
        System.out.println(actualComment.getText().equals(expectedComment) ? "COMMENT PASSED": "COMMENT FAILED");
        WebElement homePage = driver.findElement(By.xpath("//a[.='Go to Homepage']"));
        homePage.click();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://katalon-demo-cura.herokuapp.com/";
        System.out.println(actualURL.equals(expectedURL)? "URL PASSED": "URL FAILED");






    }
}
