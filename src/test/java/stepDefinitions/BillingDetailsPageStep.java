package stepDefinitions;

import testBase.common.PageObjectManager;
import io.cucumber.java.en.Given;
import pages.BillingDetailsPage;

import java.util.List;
import java.util.Map;

public class BillingDetailsPageStep {
    private final BillingDetailsPage billingDetailsPage;

    public BillingDetailsPageStep(PageObjectManager pageObjectManager) {
        this.billingDetailsPage = pageObjectManager.getBillingDetailsPage();
    }
    @Given("Fill the my Billing details page")
    public void fill_the_my_Billing_details_page(List<Map<String, String>> dataTable) {
        billingDetailsPage.fillBillingDetails(dataTable);
    }

    @Given("Navigate to order page by placing the order from Billing details page")
    public void navigate_to_order_page_by_placing_the_order_from_Billing_details_page() {
        billingDetailsPage.placeTheOrder();
    }
}
