package pages;

import testBase.ConfigReader;
import pages.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 *  userName : Testing
 *  Email : Testing@gmail.com
 *  Password : Testing@123
 */
public class ZeptoHomePage extends BasePage {
    @FindBy (xpath = "(//nav[@id='primary-site-navigation']//a[text()='Account'])[1]")
    private WebElement accountLink;
    @FindBy (id = "username")
    private WebElement userNameInputBox;
    @FindBy (id = "password")
    private WebElement passwordInputBox;
    @FindBy (xpath = "//button[@name='login']")
    private WebElement loginBtn;

    public ZeptoHomePage(WebDriver driver) {
        super(driver);
    }
    public void launchUrl(){
        invokeURL();
        waitUntilPageGetsFullyLoaded();
    }
    public void navigateToLaunchPageAndLogin(){
        launchUrl();
        accountLink.click();
        userNameInputBox.sendKeys(ConfigReader.getUserName());
        passwordInputBox.sendKeys(ConfigReader.getPassword());
        loginBtn.click();
        Assert.assertEquals(getCurrentUrl(),"https://askomdch.com/account/","Please check the url");
    }

    public void navigateToNewUserRegister(){
        launchUrl();
        accountLink.click();
    }
}
