package stepdefinations;

import testBaseSetup.common.PageObjectManager;
import io.cucumber.java.en.Given;
import pages.LaunchPage;

public class LaunchAppPageStepDef {

    private final LaunchPage launchPage;
    public LaunchAppPageStepDef(PageObjectManager pageObjectManager) {
        this.launchPage = pageObjectManager.getLaunchPage();
    }

    @Given("Launch the application with valid credentials")
    public void launch_the_application_with_valid_credentials() {
        launchPage.navigateToLaunchPageAndLogin();
    }
    @Given("Launch the application as guest user")
    public void launch_the_application_as_guest_user() {
        launchPage.launchUrl();
    }
}
