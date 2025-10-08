package IFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class IFramePractice {
    @Test
    public void iFrameConcept() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(header.getText());
        Thread.sleep(3000);
        driver.switchTo().frame("mce_0_ifr");
        WebElement text = driver.findElement(By.xpath("//p"));
        System.out.println(text.getText());
        driver.switchTo().parentFrame();
        WebElement link = driver.findElement(By.partialLinkText("Elemental"));
        link.click();
    }
    @Test
    public void practiceIFrame() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://skpatro.github.io/demo/iframes/");
        WebElement pavilion = driver.findElement(By.xpath("//a[.='Pavilion']"));
        pavilion.click();
        BrowserUtils.switchWindow(driver, "Home - qavalidation");
        WebElement text = driver.findElement(By.xpath("//h4[@class='vc_custom_heading vc_do_custom_heading']"));
        String expectedText = "Tutorials on QA tools and best practices with code snippets, examples & videos.";
        Assert.assertEquals(text.getText(), expectedText);
        Thread.sleep(3000);
        BrowserUtils.switchWindow(driver, "iframes");
        driver.switchTo().frame("Frame1");
        WebElement categoryOne = driver.findElement(By.xpath("//a[.='Category1']"));
        categoryOne.click();
        BrowserUtils.switchWindow(driver, "SeleniumTesting Archives - qavalidation");

        WebElement header = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(header.getText(), "Category Archives: SeleniumTesting");
        List<WebElement> boxes = driver.findElements(By.xpath("//div[@class='post-entry-content']"));
        for (WebElement box : boxes) {
            System.out.println("Text: " + box.getText());

        }
        Assert.assertEquals(boxes.size(), 9);
        BrowserUtils.switchWindow(driver, "iframes");
        driver.switchTo().frame("Frame1");
        WebElement smallText = driver.findElement(By.xpath("//p[@id='frametext']"));
        System.out.println(smallText.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement categoryThree = driver.findElement(By.xpath("//a[.='Category3']"));
        categoryThree.click();
        BrowserUtils.switchWindow(driver, "SoftwareTesting Archives - qavalidation");
        WebElement actualHeader = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(actualHeader.getText(), "Category Archives: SoftwareTesting");




    }
}
