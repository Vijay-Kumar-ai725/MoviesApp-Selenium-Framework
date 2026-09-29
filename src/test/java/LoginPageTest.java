import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import org.testng.Assert;
import pages.LoginPage;

import java.sql.Driver;

public class LoginPageTest {
    WebDriver Driver;
    LoginPage loginpage;
    @BeforeMethod
    public void Setup(){
        Driver = new ChromeDriver();
        Driver.get("https://qamoviesapp.ccbp.tech");
        loginpage = new LoginPage(Driver);
        // poll scm
    }
    @AfterMethod
    public void tearDown() {
        Driver.quit();
    }
    @Test(priority = 1)
    public void LoginPageUi(){


     Assert.assertTrue(loginpage.logoM(),"Image is not displayed");
     Assert.assertEquals(loginpage.loginHeading1(),"Login");
     Assert.assertEquals(loginpage.Username(),"USERNAME");
     Assert.assertEquals(loginpage.Password(),"PASSWORD");
     loginpage.login_button();
     Assert.assertEquals(loginpage.ErrorMessage(),"*Username or password is invalid");
     Driver.close();
    }
    @Test(priority = 2)
    public void EmptyInputFields(){
        // Given: User is on the Login Page

        // When: User clicks login without entering any credentials
        loginpage.login_button();

        // Then: Error message should be displayed
        Assert.assertEquals(loginpage.ErrorMessage(),"*Username or password is invalid");

    }
    @Test(priority = 3)
    public void  emptyUSERNAME(){
        // Given: User is on the Login Page

        // When: User enters only password and clicks login
        loginpage.EnterPassword("rahul@2021");
        loginpage.login_button();

        // Then: Error message should be displayed
        Assert.assertEquals(loginpage.ErrorMessage(),"*Username or password is invalid");

    }
    @Test(priority = 4)
    public void  emptyPASSWORD(){
        // Given: User is on the Login Page

        // When: User enters only username and clicks login
        loginpage.EnterUsername("rahul");
        loginpage.login_button();

        // Then: Error message should be displayed
        Assert.assertEquals(loginpage.ErrorMessage(),"*Username or password is invalid");

    }
    @Test(priority = 5)
    public void  LoginFunctionalityWithInvalidCredentials(){
        loginpage.EnterUsername("rahul");
        loginpage.EnterPassword("rahul@2022");
        loginpage.login_button();
        Assert.assertEquals(loginpage.ErrorMessage(),"*username and password didn't match");
    }

    @Test(priority = 6)
    public void LoginWithValidCredentials(){

        loginpage.EnterUsername("rahul");
        loginpage.EnterPassword("rahul@2021");
        loginpage.login_button();
        Driver.close();
    }


}
