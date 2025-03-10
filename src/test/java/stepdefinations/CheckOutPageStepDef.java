package stepdefinations;
import baseClass.DriverManager;
import io.cucumber.java.en.Given;
import pages.CheckOutPage;
import pages.StorePage;

public class CheckOutPageStepDef {
    CheckOutPage checkOutPage;
    public CheckOutPageStepDef(){
        checkOutPage = new CheckOutPage(DriverManager.getDriver());
    }
    @Given("Navigate to checkout page")
    public void navigate_to_checkout_page() {
        checkOutPage.navigateToCheckoutPage();
    }
}
