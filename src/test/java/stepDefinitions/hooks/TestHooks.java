package stepDefinitions.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testBase.DriverManager;
import testBase.utils.LoggerUtil;

public class TestHooks {
    private final DriverManager driverManager;

    // Constructor injection: PicoContainer injects DriverManager here
    public TestHooks(DriverManager driverManager) {
        this.driverManager = driverManager;
    }
    @Before(order = 1)
    public void setupLogger(Scenario scenario) {
        LoggerUtil.initializeLogger(scenario);
    }

    @Before(order = 2)
    public void setupDriver() {
        driverManager.getDriver();
    }

    @After
    public void tearDown() {
        driverManager.quitDriver();
    }

}