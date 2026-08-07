package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
public class HeaderSectionPage {
    WebDriver Driver;
    WebDriverWait wait;

     @FindBy(className = "website-logo")
     WebElement MoviesLogo;

     @FindBy(xpath = "//li/a[text()='Home']")
     WebElement home;

    @FindBy(xpath = "//a[text()='Popular']")
    WebElement Pop2;

    @FindBy(css = "button[data-testid='searchButton']")
    WebElement searchButton;

    @FindBy(className = "avatar-img")
    WebElement AVB;





    public HeaderSectionPage(WebDriver Driver){
        this.Driver = Driver;
        this.wait = new WebDriverWait(Driver,Duration.ofSeconds(10));
        PageFactory.initElements(Driver,this);

    }
    public boolean logo(){
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(MoviesLogo));
         return MoviesLogo.isDisplayed();
    }

    public void clickHome(){
        wait.until(ExpectedConditions.visibilityOf(home));
        home.click();
    }
    public void clickPopular(){
        wait.until(ExpectedConditions.visibilityOf(home));
        Pop2.click();
    }

    public void clickSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    public void Clickprofile(){
        AVB.click();
    }

    public boolean IsMovieDisplayed(){
        return MoviesLogo.isDisplayed();
    }

    public boolean IsHome(){
        return home.isDisplayed();
    }
    public boolean IsPopular(){
        return Pop2.isDisplayed();
    }
    public boolean IsSearch(){
        return searchButton.isDisplayed();
    }
    public boolean IsAvatar(){
        return AVB.isDisplayed();
    }




}

