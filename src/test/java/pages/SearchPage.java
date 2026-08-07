package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class SearchPage {
    WebDriver Driver;
    WebDriverWait wait;

    @FindBy(xpath = "//div[@class='search-container']//input")
    WebElement searchInput;

    @FindBy(xpath="//ul[@class='search-movies-container']//li")
    List<WebElement> moviesList;

    @FindBy(className = "not-found-search-container")
    WebElement errorImage;

    @FindBy(className = "not-found-search-paragraph")
    WebElement  notFoundText;

    @FindBy(css="input#search")
    WebElement SearchBox;





    public SearchPage(WebDriver Driver){
        this.Driver = Driver;
        this.wait = new WebDriverWait(Driver,Duration.ofSeconds(10));
        PageFactory.initElements(Driver,this);
    }
    public void SearchMovieName(String MovieName){

        wait.until(ExpectedConditions.elementToBeClickable(searchInput));
        searchInput.clear();
        searchInput.sendKeys(MovieName);

    }
    public int getMoviesCount(){
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//ul[@class='search-movies-container']//li"), 0
        ));
        return moviesList.size();
    }

    public boolean isErrorImageDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(errorImage));
        return errorImage.isDisplayed();
    }
    public String errorText(){
        return notFoundText.getText();
    }

    public void clearSearchBox(){
        SearchBox.clear();
    }
}
