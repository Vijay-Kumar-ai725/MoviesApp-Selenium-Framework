package pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import pages.HeaderSectionPage;
import pages.LoginPage;
import pages.PopularPage;
import pages.SearchPage;

import org.openqa.selenium.WebDriver;

public class Accountspage {
    WebDriver Driver;
    WebDriverWait wait;

    @FindBy(xpath="//div[@class='footer-icons-container']//*[name()='svg']")
    List<WebElement> icons;



    public Accountspage(WebDriver Driver){
        this.Driver = Driver;
        this.wait = new WebDriverWait(Driver,Duration.ofSeconds(10));
        PageFactory.initElements(Driver, this);
    }

    public boolean areIconsDisplayed() {
        return icons.size() == 4;
    }


}
