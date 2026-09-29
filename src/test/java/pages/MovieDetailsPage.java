package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
public class MovieDetailsPage {
    WebDriver Driver;
    WebDriverWait wait;

    @FindBy(xpath = "//div[@class='App']/div[1]")
    WebElement first;

    @FindBy(className = "movie-title")
    WebElement heading;

    @FindBy(className = "watch-time")
    WebElement Time;

    @FindBy(className = "sensor-rating")
    WebElement Sensor;

    @FindBy(className = "release-year")
    WebElement ReaYear;

    @FindBy(className = "movie-overview")
    WebElement MovieOverview;

    @FindBy(className = "play-button")
    WebElement PlayButton;

    @FindBy(className = "genres-heading")
    WebElement genre;

    @FindBy(xpath = "//div[@class='genres-container']/p")
    List<WebElement> genres;

    @FindBy(className = "audio-heading")
    WebElement AudioHeading;

    @FindBy(xpath="//ul[@class='audio-container']/li")
    List<WebElement> Audio;

    @FindBy(className = "rating-heading")
    WebElement Rcount;

    @FindBy(xpath = "//div[@class='rating-category']/*")
    List<WebElement> rating;

    @FindBy(xpath = "//div[@class='budget-category']/*")
    List<WebElement> budget;




    public MovieDetailsPage(WebDriver Driver){
        this.Driver = Driver;
        this.wait = new WebDriverWait(Driver,Duration.ofSeconds(10));
        PageFactory.initElements(Driver, this);
    }
    public void click1() {
        By duneMovie = By.cssSelector("img[alt='Dune']");
        wait.until(ExpectedConditions.elementToBeClickable(duneMovie)).click();
    }

    public String MovieName(){
        wait.until(ExpectedConditions.visibilityOf(heading));
        return heading.getText();
    }

    public String Duration(){
        return Time.getText();
    }

    public String Rating(){
        wait.until(ExpectedConditions.visibilityOf(Sensor));
        return Sensor.getText();
    }

    public String Year(){
        return ReaYear.getText();
    }

    public String overview(){
        return MovieOverview.getText();
    }

    public boolean Pbutton(){
       return PlayButton.isDisplayed();
    }
    public String Genre(){
        return genre.getText();
    }

    public void verifyGenres() {

        Assert.assertEquals(genres.get(0).getText(), "Science Fiction");
        Assert.assertEquals(genres.get(1).getText(), "Adventure");
    }

    public String Aheading(){
        return AudioHeading.getText();
    }

    public void language() {

        Assert.assertEquals(Audio.get(0).getText(), "Mandarin");
        Assert.assertEquals(Audio.get(1).getText(), "English");
    }

    public String RatingCount(){
        return Rcount.getText();
    }

    public void RatingContainer() {
        wait.until(ExpectedConditions.visibilityOfAllElements(rating));

        Assert.assertEquals(rating.get(0).getText(), "Rating Count");
        Assert.assertEquals(rating.get(1).getText(), "3720");
        Assert.assertEquals(rating.get(2).getText(), "Rating Average");
        Assert.assertEquals(rating.get(3).getText(), "8");
    }

    public void Budget() {
        wait.until(ExpectedConditions.visibilityOfAllElements(rating));

        Assert.assertEquals(budget.get(0).getText(), "Budget");
        Assert.assertEquals(budget.get(1).getText(), "16.5 Crores");
        Assert.assertEquals(budget.get(2).getText(), "Release Date");
        Assert.assertEquals(budget.get(3).getText(), "15th September 2021");
    }







}
