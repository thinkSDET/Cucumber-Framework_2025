package stepdefinations;

import baseClass.DriverManager;
import io.cucumber.java.en.Given;
import pages.StorePage;

public class StorePageStepDef {
    StorePage storePage;
    public StorePageStepDef(){
        storePage = new StorePage(DriverManager.getDriver());
    }

    @Given("Navigate to the store page")
    public void navigate_to_the_store_page() {
        storePage.navigateToStorePage();
    }
    @Given("Add the product from the store page")
    public void add_the_product_from_the_store_page() {
        storePage.addTheProduct("String productName");
    }
}
