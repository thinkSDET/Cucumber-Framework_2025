package stepdefinations;

import testBaseSetup.common.PageObjectManager;
import io.cucumber.java.en.Given;
import pages.LaunchPage;

public class LaunchAppPageStepDef {
    /**
     * In test automation, marking a Page Object (e.g., BillingDetailsPage) as private final ensures that its reference remains unchanged throughout the
     * test execution, preventing accidental reassignment. While final helps maintain consistency within a single test execution,
     * it does not make the object thread-safe. For parallel execution, ThreadLocal<T>
     * should be used to ensure each test thread gets its own separate instance, avoiding concurrency issues when multiple tests run simultaneously.
     */
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
