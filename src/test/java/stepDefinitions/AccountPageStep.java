package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import pages.AccountPage;
import testBase.common.PageObjectManager;
import utility.DataTableMapper;

public class AccountPageStep {

    private final AccountPage accountPage;

    public AccountPageStep(PageObjectManager pageObjectManager) {
        this.accountPage = pageObjectManager.getAccountPage();
    }

   @Given("Complete the Registration on Account page")
   public void complete_the_registration_on_account_page(DataTable dataTable) {
       accountPage.fillNewUserRegistrationForm(DataTableMapper.convertToMap(dataTable));
   }

    @Given("Navigate to Account page by register")
    public void navigate_to_account_page_by_register() {
        accountPage.clickOnRegisterBtn();
    }
    @Given("Verify that user able to see a confirmation message on Account page")
    public void verify_that_user_able_to_see_a_confirmation_message_on_account_page() {
        Assert.assertTrue(accountPage.verifyConfirmationMessageForNewUserRegistration().contains("edit your password and account details"));
    }
}
