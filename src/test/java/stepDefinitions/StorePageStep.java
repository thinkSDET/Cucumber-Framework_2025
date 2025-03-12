package stepDefinitions;

import testBase.common.PageObjectManager;
import io.cucumber.java.en.Given;
import pages.StorePage;

import java.util.List;

public class StorePageStep {
    private final StorePage storePage;
    public StorePageStep(PageObjectManager pageObjectManager){
        this.storePage = pageObjectManager.getStorePage();
    }

    @Given("Navigate to the Store page")
    public void navigate_to_the_Store_page() {
        storePage.navigateToStorePage();
    }
    @Given("Add the product from the Store page")
    public void add_the_product_from_the_Store_page(List<String> productData) {
        storePage.addTheProduct(productData);
    }
}
