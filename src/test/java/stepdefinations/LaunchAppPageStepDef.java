package stepdefinations;

import baseClass.DriverManager;
import io.cucumber.java.en.Given;
import pages.LaunchPage;

public class LaunchAppPageStepDef {

    protected LaunchPage launchPage;
    public LaunchAppPageStepDef() {
        this.launchPage = new LaunchPage(DriverManager.getDriver());
    }

    @Given("Launch the application with {string} and {string}")
    public void launch_the_application_with_and(String userName, String password) {
        launchPage.navigateToLaunchPageAndLogin(userName, password);
    }
    @Given("Launch the application as guest user")
    public void launch_the_application_as_guest_user() {
        launchPage.launchUrl();
    }
}
