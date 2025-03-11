package stepdefinations;
import base.DriverManager;
import common.TestContext;
import io.cucumber.java.en.Given;
import pages.CheckOutPage;

public class CheckOutPageStepDef {
    private final CheckOutPage checkOutPage;
    public CheckOutPageStepDef(TestContext context){
        this.checkOutPage = context.getCheckOutPage();
    }
    @Given("Navigate to checkout page")
    public void navigate_to_checkout_page() {
        checkOutPage.navigateToCheckoutPage();
    }
}
