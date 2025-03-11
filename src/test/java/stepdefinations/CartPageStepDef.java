package stepdefinations;

import base.DriverManager;
import common.TestContext;
import io.cucumber.java.en.Given;
import pages.CartPage;

import java.util.List;
import java.util.Map;

public class CartPageStepDef {

    private final CartPage cartPage;
    public CartPageStepDef(TestContext context){
        this.cartPage = context.getCartPage();
    }

    @Given("Navigate to cart page")
    public void navigate_to_cart_page() {
        cartPage.navigateToCartPage();
    }
    @Given("Verify that user can find the added product in cart page")
    public void verify_that_user_can_find_the_added_product_in_cart_page(List<Map<String, String>> cartData) {
        cartPage.verifyAddedProductInCart(cartData);
    }
}
