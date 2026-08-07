import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import pages.HeaderSectionPage;
import pages.HomePage;
import pages.LoginPage;
public class HeaderSectionPageTest {
    WebDriver Driver;
    LoginPage loginPage;
    HeaderSectionPage headerSectionPage;
    @BeforeMethod
    public void SetUp(){
        Driver = new ChromeDriver();
        Driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(Driver);
        headerSectionPage = new HeaderSectionPage(Driver);
        loginPage.loginToApplication("rahul","rahul@2021");
        String Expect = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(Driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(Expect));
    }
    @Test(priority = 1)
    public void testNavbarNavigation(){
        headerSectionPage.clickHome();
        headerSectionPage.clickPopular();
        headerSectionPage.clickSearchButton();
        headerSectionPage.Clickprofile();
    }
    @Test(priority = 2)
    public void visibility(){

            Assert.assertTrue(headerSectionPage.logo(), "Not Displayed");
            Assert.assertTrue(headerSectionPage.IsHome(), "Not Displayed");
            Assert.assertTrue(headerSectionPage.IsPopular(), "Not Displayed");
            Assert.assertTrue(headerSectionPage.IsSearch(), "Not Displayed");
            Assert.assertTrue(headerSectionPage.IsAvatar(), "Not Displayed");

        }

    }



