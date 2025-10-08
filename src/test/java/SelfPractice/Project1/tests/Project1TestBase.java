package SelfPractice.Project1.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverHelper;

public class Project1TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.get("https://automationexercise.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
