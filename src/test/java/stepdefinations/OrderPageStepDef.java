package stepdefinations;

import base.DriverManager;
import common.TestContext;
import io.cucumber.java.en.Given;
import pages.OrderPage;

import java.util.List;
import java.util.Map;

public class OrderPageStepDef {

    private final OrderPage orderPage;
    public OrderPageStepDef(TestContext context){
        this.orderPage = context.getOrderPage();
    }

    @Given("Verify the order details on order page")
    public void verify_the_order_details_on_order_page(List<Map<String,String>> dataTable) {
        orderPage.verifyTheOrderDetailsPage(dataTable);
    }
}
