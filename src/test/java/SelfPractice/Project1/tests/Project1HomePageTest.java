package SelfPractice.Project1.tests;

import SelfPractice.Project1.pages.Project1FinalPage;
import SelfPractice.Project1.pages.Project1HomePage;
import SelfPractice.Project1.pages.Project1SingUpPage;
import org.testng.annotations.Test;

public class Project1HomePageTest extends Project1TestBase{
    @Test
    public void validateFinalPage() throws InterruptedException {
        Project1HomePage project1HomePage = new Project1HomePage(driver);
        project1HomePage.loginFunctionality(driver,
                "Automation Exercise",
                "Aliyah", "aekfkebajkkytgbek99@gmail.com",
                "New User Signup!");
        Project1SingUpPage project1SingUpPage = new Project1SingUpPage(driver);
        project1SingUpPage.signUpPageFunctionality(driver, "ENTER ACCOUNT INFORMATION",
                "i6qDWowGBPF", "Aliyah", "Bakytbekova",
                "Lapasha", "2824 S Voss Rd", "Texas", "Houston",
                "77890", "8324567890");
        Project1FinalPage project1FinalPage = new Project1FinalPage(driver);
        project1FinalPage.finalPageFunctionality(driver, "ACCOUNT CREATED!", "Aliyah", "ACCOUNT DELETED!");
    }

}
