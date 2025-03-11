package pages;

import pages.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import testBaseSetup.utils.LoggerUtil;

import java.util.List;

public class StorePage extends BasePage {
    CartPage cartPage;
    @FindBy(xpath = "(//nav[@id='primary-site-navigation']//a[text()='Store'])[1]")
    private WebElement storeLink;

    public StorePage(WebDriver driver) {
        super(driver);
        cartPage = new CartPage(driver);
    }

    public void navigateToStorePage(){
        storeLink.click();
        LoggerUtil.info(storeLink + "clicked");
        Assert.assertEquals(getCurrentUrl(),"https://askomdch.com/store/","please check the url");
        cartPage.clearCart();
    }
    public void addTheProduct(List<String> productNames){
       for(String productName : productNames){
           By addToCartBtn = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
           driver.findElement(addToCartBtn).click();
       }
    }
}
