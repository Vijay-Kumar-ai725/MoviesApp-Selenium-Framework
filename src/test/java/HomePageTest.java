import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
public class HomePageTest {
    WebDriver Driver;
    HomePage homepage;
    LoginPage loginpage;
    @BeforeMethod
    public void setUp(){
        Driver = new ChromeDriver();
        Driver.get("https://qamoviesapp.ccbp.tech");
        loginpage = new LoginPage(Driver);
        homepage = new HomePage(Driver);
        loginpage.loginToApplication("rahul","rahul@2021");
        String Expect = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(Driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(Expect));
    }
    @Test(priority = 1)
    public void HeadingTests(){
        Assert.assertEquals(homepage.Trending1(),"Trending Now");
        Assert.assertEquals(homepage.Original1(),"Originals");
    }
    @Test(priority = 2)
    public void PlayButtonTest(){
        Assert.assertTrue(homepage.buttonP(),"Play button is not displayed");
    }
   @Test(priority = 4)
    public void MovieSection(){
        Assert.assertTrue(homepage.movies(),"Not Displayed");
   }
  @Test(priority = 5)
    public void ContactSection(){
        Assert.assertEquals(homepage.contact1(),"Contact Us");
        Driver.close();
  }


}
