package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver Driver;
    WebDriverWait wait;

    @FindBy(className = "login-website-logo")
    WebElement logo;

    @FindBy(className = "sign-in-heading")
    WebElement loginHeading;

    @FindBy(xpath = "//label[text()='USERNAME']")
    WebElement UserNameLabel;

    @FindBy(xpath = "//label[text()='PASSWORD']")
    WebElement passwordNameLabel;

    @FindBy(className = "login-button")
    WebElement LoginButton;

    @FindBy(className = "error-message")
    WebElement errormessage;

    @FindBy(id="passwordInput")
    WebElement password;

    @FindBy(id="usernameInput")
    WebElement username;

    public LoginPage(WebDriver Driver){
        this.Driver = Driver;
        this.wait = new WebDriverWait(Driver,Duration.ofSeconds(10));
        PageFactory.initElements(Driver,this);
    }

    public boolean logoM(){
        return logo.isDisplayed();
    }
    public String loginHeading1(){
        return loginHeading.getText();
    }

    public String Username(){
        return UserNameLabel.getText();
    }

    public String Password(){
        return passwordNameLabel.getText();
    }
    public void login_button(){
        LoginButton.click();
    }
    public String ErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return errormessage.getText();
    }

    public void EnterPassword(String password1){
        password.sendKeys(password1);
    }

    public void EnterUsername(String username1){
        username.sendKeys(username1);
    }

    public void loginToApplication(String username1, String password1){
        username.sendKeys(username1);
        password.sendKeys(password1);
        LoginButton.click();

    }

}
