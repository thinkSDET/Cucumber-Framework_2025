package stepdefinations;
import testBaseSetup.common.PageObjectManager;
import io.cucumber.java.en.Given;
import pages.CheckOutPage;

public class CheckOutPageStepDef {
    private final CheckOutPage checkOutPage;
    public CheckOutPageStepDef(PageObjectManager context){
        this.checkOutPage = context.getCheckOutPage();
    }
    @Given("Navigate to checkout page")
    public void navigate_to_checkout_page() {
        checkOutPage.navigateToCheckoutPage();
    }
}
