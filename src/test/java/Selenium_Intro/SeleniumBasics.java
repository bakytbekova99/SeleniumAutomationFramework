package Selenium_Intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) throws InterruptedException {
        //We create an object
        WebDriver driver = new ChromeDriver();
        //We maximize the screen
        driver.manage().window().maximize();
        //We go to the website
        driver.navigate().to("https://www.facebook.com/");
        //GetTitle method will return you the title of the page as a String
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - log in or sign up";
        //Validation TITLE: Comparing actual and expected matching or not
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Your title is Passed");
        } else {
            System.out.println("Your Title is Failed");
        }
        //Validation URL
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.facebook.com/";
        if (actualURL.equals(expectedURL)){
            System.out.println("YourURL is Passed");
        } else {
            System.out.println("Your URL is Failed");
        }
        Thread.sleep(2000);// It pauses the system for 2 sec
        driver.close(); //It will close the page that automation opens
    }
}
