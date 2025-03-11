package pages;

import testBaseSetup.ConfigReader;
import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.LoggerUtil;

/**
 *  userName : Testing
 *  Email : Testing@gmail.com
 *  Password : Testing@123
 */
public class LaunchPage extends BasePage {
    @FindBy (xpath = "(//nav[@id='primary-site-navigation']//a[text()='Account'])[1]")
    private WebElement accountLink;
    @FindBy (id = "username")
    private WebElement userNameInputBox;
    @FindBy (id = "password")
    private WebElement passwordInputBox;
    @FindBy (xpath = "//button[@name='login']")
    private WebElement loginBtn;

    public WebDriver driver;
    public LaunchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void launchUrl(){
        invokeURL();
        LoggerUtil.info("Url is launched");
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
}
