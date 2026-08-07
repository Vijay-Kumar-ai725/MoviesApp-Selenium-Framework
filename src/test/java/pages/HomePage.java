package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
public class HomePage {
    WebDriver Driver;
    WebDriverWait wait;

    @FindBy(xpath = "//h1[text()='Trending Now']")
    WebElement trending;

    @FindBy(xpath = "//h1[text()='Originals']")
    WebElement original;

    @FindBy(className = "home-movie-play-button")
    WebElement PlayButton;

    @FindBy(css = ".slick-list")
    List<WebElement> elements;

    @FindBy(xpath = "//p[text()='Contact Us']")
    WebElement contact;





    public HomePage(WebDriver Driver){
        this.Driver = Driver;
        this.wait = new WebDriverWait(Driver,Duration.ofSeconds(10));
        PageFactory.initElements(Driver,this);
    }

    public String Trending1(){
       return trending.getText();

    }

    public String Original1(){
        return original.getText();

    }

    public boolean buttonP(){
        wait.until(ExpectedConditions.visibilityOf(PlayButton));
        return PlayButton.isDisplayed();

    }
    public boolean movies(){
        for(WebElement movie : elements){
            if(!movie.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
    public String contact1(){
        return contact.getText();
    }




}
