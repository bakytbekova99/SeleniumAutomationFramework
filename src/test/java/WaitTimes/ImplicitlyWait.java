package WaitTimes;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.DriverHelper;

import java.time.Duration;

public class ImplicitlyWait {
    @Test
    public void test(){
        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //It will wait for the element max 10 sec, if it loads faster, it will continue execution
        //If it does not load in 10 sec, it will throw TIMEOUT exception
    }
}
