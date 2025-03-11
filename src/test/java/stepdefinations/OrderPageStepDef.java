package stepdefinations;

import base.DriverManager;
import io.cucumber.java.en.Given;
import pages.OrderPage;

import java.util.List;
import java.util.Map;

public class OrderPageStepDef {

    OrderPage orderPage;
    public OrderPageStepDef(){
        orderPage = new OrderPage(DriverManager.getDriver());
    }

    @Given("Verify the order details on order page")
    public void verify_the_order_details_on_order_page(List<Map<String,String>> dataTable) {
        orderPage.verifyTheOrderDetailsPage(dataTable);
    }
}
