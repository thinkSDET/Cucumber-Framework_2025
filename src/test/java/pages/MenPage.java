package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.basePage.BasePage;
import testBase.utils.LoggerUtil;

public class MenPage extends BasePage {
    @FindBy(xpath = "(//nav[@id='primary-site-navigation']//a[text()='Men'])[1]")
    private WebElement storeLink;
    public MenPage(WebDriver driver) {
        super(driver);
    }
    public void navigateToMenPage(){
        storeLink.click();
        Assert.assertEquals(getCurrentUrl(),"https://askomdch.com/product-category/men/","please check the url");
    }

    public void addProducts(String productName){
        By addToCartBtn = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
        driver.findElement(addToCartBtn).click();
    }
}
