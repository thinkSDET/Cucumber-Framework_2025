package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Objects;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public void invokeURL(String url){
        driver.get(url);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void moveToAnElement(WebElement element){
        waitForElementToVisible(element);
        actions.moveToElement(element).perform();
    }
    public void clickOnElement(WebElement element){
        moveToAnElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * Waits until the page is fully loaded by checking the document.readyState.
     * Useful for full page loads (e.g., URL changes or page reloads).
     * For dynamic content, use additional waits for specific elements or AJAX calls.
     */
    public void waitUntilPageGetsFullyLoaded(){
        wait.until(d -> Objects.equals(((JavascriptExecutor) d).executeScript("return document.readyState"), "complete"));
    }
    public WebElement waitForElementToVisible(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementToInVisible(WebElement element){
         wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
