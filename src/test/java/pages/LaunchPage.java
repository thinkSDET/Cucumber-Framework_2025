package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 *  userName : Testing
 *  Email : Testing@gmail.com
 *  Password : Testing@123
 */
public class LaunchPage extends BasePage{
    @FindBy (xpath = "(//nav[@id='primary-site-navigation']//a[text()='Account'])[1]")
    private WebElement accountLink;
    @FindBy (id = "username")
    private WebElement userNameInputBox;
    @FindBy (id = "password")
    private WebElement passwordInputBox;
    @FindBy (id = "//button[@name='login']")
    private WebElement loginBtn;

    public WebDriver driver;
    public LaunchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void navigateToLaunchPageAndLogin(String userName, String password){
        invokeURL("https://askomdch.com/");
        accountLink.click();
        userNameInputBox.sendKeys(userName);
        passwordInputBox.sendKeys(password);
        loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://askomdch.com/account/","Please check the url");
    }
}
