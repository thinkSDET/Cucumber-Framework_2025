package stepDefinitions;

import testBase.common.PageObjectManager;
import io.cucumber.java.en.Given;
import pages.ZeptoHomePage;

public class ZeptoHomePageStep {
    /**
     * In test automation, marking a Page Object (e.g., BillingDetailsPage) as private final ensures that its reference remains unchanged throughout the
     * test execution, preventing accidental reassignment. While final helps maintain consistency within a single test execution,
     * it does not make the object thread-safe. For parallel execution, ThreadLocal<T>
     * should be used to ensure each test thread gets its own separate instance, avoiding concurrency issues when multiple tests run simultaneously.
     */
    private final ZeptoHomePage launchPage;

    // Constructor injection: PicoContainer injects PageObjectManager here
    public ZeptoHomePageStep(PageObjectManager pageObjectManager) {
        this.launchPage = pageObjectManager.getLaunchPage();
    }

    @Given("Launch the Zepto application with valid credentials")
    public void launch_the_Zepto_application_with_valid_credentials() {
        launchPage.navigateToLaunchPageAndLogin();
    }
    @Given("Launch the Zepto application")
    public void launch_the_Zepto_application() {
        launchPage.launchUrl();
    }

    @Given("Close the Zepto application")
    public void close_the_zepto_application() {

    }
}
