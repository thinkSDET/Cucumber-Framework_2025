package stepdefinations.hooks;

import testBaseSetup.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testBaseSetup.utils.LoggerUtil;

public class hooks {



    @Before(order = 1)
    public void setupLogger(Scenario scenario) {
        LoggerUtil.initializeLogger(scenario);
    }

    @Before(order = 2)
    public void setupDriver() {
        DriverManager.invokeDriver();
        LoggerUtil.info("- Initializing the browser: 'chrome'");
    }

    @After
    public void tearDown(){
        LoggerUtil.info("Closing the driver...");
        DriverManager.getDriver().quit(); // Quit the driver for the current thread
        DriverManager.removeDriver(); // Remove the ThreadLocal instance
    }
}
