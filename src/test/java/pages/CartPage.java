package pages;

import testBaseSetup.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import testBaseSetup.utils.LoggerUtil;

import java.util.List;
import java.util.Map;

public class CartPage extends BasePage {

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
    @FindBy(xpath = "(//a[@title='View your shopping cart'])[1]//span")
    private WebElement cartCount;
    @FindBy(xpath = "(*//div[@class='widget woocommerce widget_shopping_cart']//div//p)[1]")
    private WebElement clearCartMessage;
    @FindBy(xpath = "(//a[@class='remove remove_from_cart_button'])[1]")
    private WebElement removeItemsFromCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToCartPage(){
        try {
            moveToAnElement(shoppingCartIcon);
            clickOnElement(viewCartBtn);
            waitUntilPageGetsFullyLoaded();
            Assert.assertEquals(getCurrentUrl(),"https://askomdch.com/cart/","");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void verifyAddedProductInCart(List<Map<String, String>> cartData){
        LoggerUtil.info("This is from add to cart-->"+ productNameFld.getText());
        Assert.assertEquals(cartData.getFirst().get("Product"),productNameFld.getText());
        Assert.assertEquals(cartData.getFirst().get("Quantity"),productQuantityFld.getDomProperty("value"));
    }


    public void clearCart(){
        try {
            int cartItem = Integer.parseInt(cartCount.getText());
            if(cartItem>0){
                moveToAnElement(shoppingCartIcon);
                clickOnElement(removeItemsFromCart);
                waitForElementToBeInVisible(removeItemsFromCart);
                Assert.assertEquals(waitForElementToVisible(clearCartMessage).getText(),"No products in the cart.","Please check cart is not empty");
                LoggerUtil.info("cart is cleared now");
            }
            else {
                LoggerUtil.info("Cart is already empty");
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }

    }
}
