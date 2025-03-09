package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class CartPage extends BasePage{

    @FindBy(xpath = "(//a[@title='View your shopping cart'])[1]")
    private WebElement shoppingCartIcon;
    @FindBy(xpath = "(//div[@class='widget woocommerce widget_shopping_cart']//a[text()='View cart'])[1]")
    private WebElement viewCartBtn;


    @FindBy(css = "td[class='product-name'] a")
    private WebElement productNameFld;
    @FindBy(css = "input[type=\"number\"]")
    private WebElement productQuantityFld;
    @FindBy(css = ".checkout-button")
    private WebElement proceedToCheckoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToCartPage(){
        moveToAnElement(shoppingCartIcon);
        clickOnElement(viewCartBtn);
        waitUntilPageGetsFullyLoaded();
        Assert.assertEquals(getCurrentUrl(),"https://askomdch.com/cart/","");
    }

    public void verifyAddedProductInCart(List<Map<String, String>> cartData){
        Assert.assertEquals(cartData.getFirst().get("Product"),productNameFld.getText());
        Assert.assertEquals(cartData.getFirst().get("Quantity"),productQuantityFld.getDomProperty("value"));
    }
}
