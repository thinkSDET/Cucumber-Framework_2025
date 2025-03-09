package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class StorePage extends BasePage{

    @FindBy(xpath = "(//nav[@id='primary-site-navigation']//a[text()='Store'])[1]")
    private WebElement storeLink;

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToStorePage(){
        storeLink.click();
        Assert.assertEquals(getCurrentUrl(),"https://askomdch.com/store/","please check the url");
        clearCart();
    }
    public void addTheProduct(List<String> productNames){
       for(String productName : productNames){
           By addToCartBtn = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
           driver.findElement(addToCartBtn).click();
       }
    }
}
