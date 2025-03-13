package stepDefinitions;

import testBase.common.PageObjectManager;
import io.cucumber.java.en.Given;
import pages.CartPage;

import java.util.List;
import java.util.Map;

public class CartPageStep {

    private final CartPage cartPage;
    public CartPageStep(PageObjectManager pageObjectManager){
        this.cartPage = pageObjectManager.getCartPage();
    }

    @Given("Navigate to Cart page")
    public void navigate_to_Cart_page() {
        cartPage.navigateToCartPage();
    }
    @Given("Verify that user can find the added product in Cart page")
    public void verify_that_user_can_find_the_added_product_in_Cart_page(List<Map<String, String>> cartData) {
        cartPage.verifyAddedProductInCart(cartData);
    }

    @Given("Navigate to Cart page to clear the cart")
    public void navigate_to_cart_page_to_clear_the_cart() {
       cartPage.clearCart();
    }
}
