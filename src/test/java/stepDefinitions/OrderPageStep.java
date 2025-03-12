package stepDefinitions;

import testBase.common.PageObjectManager;
import io.cucumber.java.en.Given;
import pages.OrderPage;

import java.util.List;
import java.util.Map;

public class OrderPageStep {

    private final OrderPage orderPage;
    public OrderPageStep(PageObjectManager pageObjectManager){
        this.orderPage = pageObjectManager.getOrderPage();
    }

    @Given("Verify the order details on Order page")
    public void verify_the_order_details_on_Order_page(List<Map<String,String>> dataTable) {
        orderPage.verifyTheOrderDetailsPage(dataTable);
    }
}
