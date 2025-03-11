package stepdefinations;

import common.PageObjectManager;
import io.cucumber.java.en.Given;
import pages.StorePage;

import java.util.List;

public class StorePageStepDef {
    private final StorePage storePage;
    public StorePageStepDef(PageObjectManager context){
        this.storePage = context.getStorePage();
    }

    @Given("Navigate to the store page")
    public void navigate_to_the_store_page() {
        storePage.navigateToStorePage();
    }
    @Given("Add the product from the store page")
    public void add_the_product_from_the_store_page(List<String> productData) {
        storePage.addTheProduct(productData);
    }
}
