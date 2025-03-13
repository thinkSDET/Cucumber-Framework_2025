package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.AccountPage;
import pages.BillingDetailsPage;
import testBase.common.PageObjectManager;

import java.util.List;
import java.util.Map;

public class AccountPageStep {

    private final AccountPage accountPage;

    public AccountPageStep(PageObjectManager pageObjectManager) {
        this.accountPage = pageObjectManager.getAccountPage();
    }

    @Given("Navigate to Account page")
    public void navigate_to_account_page() {

    }

    @Given("Complete the Registration on Account page")
    public void complete_the_registration_on_account_page(List<Map<String, String>> testData) {

    }

    @Given("Navigate to Account page by register")
    public void navigate_to_account_page_by_register() {

    }
    @Given("Verify that user able to see a confirmation message on Account page")
    public void verify_that_user_able_to_see_a_confirmation_message_on_account_page() {

    }
    @Given("Verify that user able to see logout option on Account page")
    public void verify_that_user_able_to_see_logout_option_on_account_page() {

    }
}
