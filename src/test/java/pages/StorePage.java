package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class StorePage extends BasePage{

    @FindBy(xpath = "(//nav[@id='primary-site-navigation']//a[text()='Store'])[1]")
    private WebElement storeLink;

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToStorePage(){
        storeLink.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://askomdch.com/store/","please check the url");
    }
    public void addTheProduct(String productName){
        By addToCartBtn = By.xpath("a[aria-label='Add “" + productName + "” to your cart']");
        driver.findElement(addToCartBtn).click();
    }
}
