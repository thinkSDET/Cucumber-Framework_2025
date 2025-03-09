package pages;

import org.openqa.selenium.WebDriver;

public class LaunchPage extends BasePage{
    public WebDriver driver;
    public LaunchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void navigateToLaunchPage(){
        new BasePage(driver).invokeURL("https://askomdch.com/");
    }
}
