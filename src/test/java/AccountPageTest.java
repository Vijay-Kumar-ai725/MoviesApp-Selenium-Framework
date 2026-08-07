import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import pages.HeaderSectionPage;
import pages.LoginPage;
import pages.MovieDetailsPage;
import pages.Accountspage;
public class AccountPageTest {
    WebDriver Driver;
    LoginPage loginpage;
    Accountspage accountsPage;
    @BeforeMethod
    public void SetUp(){
        Driver = new ChromeDriver();
        Driver.get("https://qamoviesapp.ccbp.tech");

        loginpage = new LoginPage(Driver);
        loginpage.loginToApplication("rahul", "rahul@2021");
        accountsPage = new Accountspage(Driver);

        String Expect = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(Expect));

    }

    @Test(priority = 1)
    public void AccountFunctionality(){
        accountsPage.areIconsDisplayed();
    }



}
