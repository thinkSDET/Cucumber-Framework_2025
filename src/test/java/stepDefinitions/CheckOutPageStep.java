package stepDefinitions;
import testBase.common.PageObjectManager;
import io.cucumber.java.en.Given;
import pages.CheckOutPage;

public class CheckOutPageStep {
    private final CheckOutPage checkOutPage;
    public CheckOutPageStep(PageObjectManager pageObjectManager){
        this.checkOutPage = pageObjectManager.getCheckOutPage();
    }
    @Given("Navigate to Checkout page")
    public void navigate_to_Checkout_page() {
        checkOutPage.navigateToCheckoutPage();
    }
}
