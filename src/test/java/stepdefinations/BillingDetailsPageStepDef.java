package stepdefinations;

import base.DriverManager;

import common.TestContext;
import io.cucumber.java.en.Given;
import pages.BillingDetailsPage;

import java.util.List;
import java.util.Map;

public class BillingDetailsPageStepDef {
    private final BillingDetailsPage billingDetailsPage;
    public BillingDetailsPageStepDef(TestContext context){
        this.billingDetailsPage = context.getBillingDetailsPage(); // Injected Dependency
    }
    @Given("Fill the my billing details page")
    public void fill_the_my_billing_details_page(List<Map<String, String>> dataTable) {
        billingDetailsPage.fillBillingDetails(dataTable);
    }

    @Given("Navigate to order page by placing the order from billing details page")
    public void navigate_to_order_page_by_placing_the_order_from_billing_details_page() {
        billingDetailsPage.placeTheOrder();
    }
}
