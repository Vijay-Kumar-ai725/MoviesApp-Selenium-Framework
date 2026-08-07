import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import pages.Accountspage;
import pages.HeaderSectionPage;
import pages.LoginPage;
import pages.MovieDetailsPage;


public class MovieDetailsPageTest {
    WebDriver Driver;
    LoginPage loginpage;
    MovieDetailsPage movieDetailsPage;
    HeaderSectionPage headerSectionPage;
    @BeforeMethod
    public void SetUp(){
        Driver = new ChromeDriver();
        Driver.get("https://qamoviesapp.ccbp.tech");

        loginpage = new LoginPage(Driver);
        headerSectionPage = new HeaderSectionPage(Driver);
        movieDetailsPage = new MovieDetailsPage(Driver);

        loginpage.loginToApplication("rahul", "rahul@2021");
        String Expect = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(Expect));


    }
    @Test(priority = 1)
    public void HomeMovieFunctionality() {
        movieDetailsPage.click1();
        Assert.assertEquals(movieDetailsPage.MovieName(), "Dune");
        Assert.assertEquals(movieDetailsPage.Duration(), "2h 35m");
        Assert.assertEquals(movieDetailsPage.Rating(), "U/A");
        Assert.assertEquals(movieDetailsPage.Year(), "2021");
        Assert.assertEquals(movieDetailsPage.overview(), "Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in the universe to ensure the future of his family and his people.");
        Assert.assertTrue(movieDetailsPage.Pbutton());
        Assert.assertEquals(movieDetailsPage.Genre(), "Genres");
        movieDetailsPage.verifyGenres();
        Assert.assertEquals(movieDetailsPage.Aheading(),"Audio Available");
        movieDetailsPage.language();
        Assert.assertEquals(movieDetailsPage.RatingCount(),"Rating Count");
       movieDetailsPage.RatingContainer();
       movieDetailsPage.Budget();
    }

}