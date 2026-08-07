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
import java.util.List;

public class PopularPage {
    WebDriver Driver;
    WebDriverWait wait;

    @FindBy(css = ".search-movies-container li")
    List<WebElement> movies;



    public PopularPage(WebDriver Driver){
        this.Driver = Driver;
        this.wait = new WebDriverWait(Driver,Duration.ofSeconds(10));
        PageFactory.initElements(Driver,this);
    }

    public boolean isMoviesDisplayed(){
        wait.until(ExpectedConditions.visibilityOfAllElements(movies));
     return !movies.isEmpty() && movies.get(0) .isDisplayed();
    }

}

