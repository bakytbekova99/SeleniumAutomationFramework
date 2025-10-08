package Selenium_Intro;


import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriverMethods {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.navigate().to("https://www.facebook.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.navigate().back();//goes to google
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.navigate().forward();//goes to facebook
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.quit();


    }
}
