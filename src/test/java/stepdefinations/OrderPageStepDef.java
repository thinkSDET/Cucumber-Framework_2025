package stepdefinations;

import baseClass.DriverManager;
import io.cucumber.java.en.Given;
import pages.CheckOutPage;
import pages.OrderPage;

public class OrderPageStepDef {

    OrderPage orderPage;
    public OrderPageStepDef(){
        orderPage = new OrderPage(DriverManager.getDriver());
    }

    @Given("Verify the order details on order page")
    public void verify_the_order_details_on_order_page(io.cucumber.datatable.DataTable dataTable) {
        orderPage.verifyTheOrderDetailsPage();
    }
}
