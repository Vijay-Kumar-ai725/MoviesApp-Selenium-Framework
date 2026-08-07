import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import org.openqa.selenium.support.PageFactory;
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
import pages.LoginPage;
import pages.PopularPage;
import pages.SearchPage;

public class SearchPageTest {
    WebDriver Driver;
    LoginPage loginPage;
    HeaderSectionPage headerSectionPage;
    SearchPage searchPage;


    @BeforeMethod
    public void SetUp() {
        Driver = new ChromeDriver();
        Driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(Driver);
        searchPage = new SearchPage(Driver);
        headerSectionPage = new HeaderSectionPage(Driver);
        loginPage.loginToApplication("rahul", "rahul@2021");
        String Expect = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(Expect));
    }
    @Test(priority = 1)
    public void SearchFunctionality(){
        headerSectionPage.clickSearchButton();
        searchPage.SearchMovieName("TITANIC");
        headerSectionPage.clickSearchButton();
        int titanicCount = searchPage.getMoviesCount();
        Assert.assertEquals(titanicCount, 1, "TITANIC movie count mismatch");

        searchPage.clearSearchBox();
        searchPage.SearchMovieName("LUCA");
        headerSectionPage.clickSearchButton();
        int lucaCount = searchPage.getMoviesCount();
        Assert.assertEquals(lucaCount, 1, "LUCA movie count mismatch");

    }
    @Test(priority = 2)
    public void SearchFunctionalityFail(){
        headerSectionPage.clickSearchButton();
        searchPage.SearchMovieName("HIMBGH");
        headerSectionPage.clickSearchButton();

        Assert.assertTrue(searchPage.isErrorImageDisplayed(),"Not Displayed");
        Assert.assertEquals(searchPage.errorText(),"Your search for HIMBGH did not find any matches.");
    }

}
