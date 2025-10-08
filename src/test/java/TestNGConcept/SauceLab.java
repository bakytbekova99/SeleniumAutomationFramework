package TestNGConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SauceLab {
//`https://www.saucedemo.com/`
//TestName --> ValidateHappyPathLoginFunctionality
/*
1-Login Succesfully with "standard_user" , "secret_sauce"
2-Validate Title (ASSERT) -->Swag Labs
3-Validate URL (ASSERT) --> https://www.saucedemo.com/inventory.html
4-quit
 */
    @Test
    public void ValidateHappyPathLoginFunctionality() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement button = driver.findElement(By.xpath("//input[@id='login-button']"));
        button.click();
        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Swag Labs";
        Assert.assertEquals(actualTitle, expectedTitle);
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualURL, expectedURL);
        driver.quit();
    }
    @Test
    public void NegativeLoginFunctionality() throws InterruptedException {
        // Provide wrong login information and validate the Message
        //Epic sadface: Username and password do not match any user in this service
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("SECRET_SAUCE");
        WebElement button = driver.findElement(By.xpath("//input[@id='login-button']"));
        button.click();
        WebElement message = driver.findElement(By.tagName("h3"));
        String actualMessage = message.getText();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualMessage, expectedMessage);


    }
    @Test
    public void validateTestProductDescription() throws InterruptedException {
                /*
1-Navigate to website https://www.saucedemo.com/
2-Login Successfully with username and password
3-Store all the elements and validate there are 6 items on the website (list.size method might help)
4-Loop through all items and once this element name is "Sauce Labs Bolt T-Shirt" then click and break
5-Validate the header "Sauce Labs Bolt T-Shirt"
6-Validate the description contains(heather gray)
7-Validate the price "$15.99"
8-Validate the Add to card is displayed and enabled on the page.
9-Quit
*/
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement button = driver.findElement(By.xpath("//input[@id='login-button']"));
        button.click();
        Thread.sleep(2000);
        List<WebElement> lists = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
        Assert.assertEquals(lists.size(), 6);
        for (WebElement list : lists) {
            if (list.getText().equals("Sauce Labs Bolt T-Shirt")){
                list.click();
                break;
            }
        }
        WebElement header = driver.findElement(By.xpath("//div[.='Sauce Labs Bolt T-Shirt']"));
        String expectedHeader = "Sauce Labs Bolt T-Shirt";
        Assert.assertEquals(header.getText(), expectedHeader);

        WebElement description = driver.findElement(By.xpath("//div[@data-test='inventory-item-desc']"));
        Assert.assertTrue(description.getText().contains("heather gray"));
        WebElement price = driver.findElement(By.xpath("//div[@data-test='inventory-item-price']"));
        String actualPrice = price.getText();
        String expectedPrice = "$15.99";
        Assert.assertEquals(actualPrice, expectedPrice);

        WebElement addToCartButton = driver.findElement(By.xpath("//button[@data-test='add-to-cart']"));
        Assert.assertTrue(addToCartButton.isDisplayed() && addToCartButton.isEnabled());

    }
    @Test
    public void orderFunctionality() throws InterruptedException {
          /*
    1-Click Add to Card button
    2-Click the cart at the top right
    3-Validate the name of the item "Sauce Labs Bolt T-Shirt" header
    4-Click check out button
    5-Provide the information
    6- Validate Total Amount(if you cannot do first way)
    7-Click Finish Button
    8-Validate "Thank you for your order!"
    9-driver.quit()
     */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement button = driver.findElement(By.xpath("//input[@id='login-button']"));
        button.click();
        Thread.sleep(2000);
        List<WebElement> lists = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
        Assert.assertEquals(lists.size(), 6);
        for (WebElement list : lists) {
            if (list.getText().equals("Sauce Labs Bolt T-Shirt")){
                list.click();
                break;
            }
        }
        Thread.sleep(2000);
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@data-test='add-to-cart']"));
        addToCartButton.click();
        WebElement cart = driver.findElement(By.xpath("//div[@id='shopping_cart_container']"));
        cart.click();
        WebElement itemName = driver.findElement(By.xpath("//div[@data-test='inventory-item-name']"));
        String exceptedItemName = "Sauce Labs Bolt T-Shirt";
        Assert.assertEquals(itemName.getText(), exceptedItemName);
        Thread.sleep(2000);
        WebElement checkoutButton = driver.findElement(By.xpath("//button[@data-test='checkout']"));
        checkoutButton.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='first-name']"));
        firstName.sendKeys("Aliyah");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='last-name']"));
        lastName.sendKeys("Bakytbekova");
        WebElement postalCodes = driver.findElement(By.xpath("//input[@id='postal-code']"));
        postalCodes.sendKeys("77089");
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='continue']"));
        continueButton.click();
        WebElement actualTotal = driver.findElement(By.xpath("//div[@data-test='total-label']"));
        String expectedTotal = "Total: $17.27";
        Assert.assertEquals(actualTotal.getText(), expectedTotal);
        WebElement finishButton = driver.findElement(By.xpath("//button[@id='finish']"));
        finishButton.click();
        WebElement finalMessage = driver.findElement(By.tagName("h2"));
        String expectedFinalMessage = "Thank you for your order!";
        Assert.assertEquals(finalMessage.getText(), expectedFinalMessage);
        driver.quit();
    }

}
