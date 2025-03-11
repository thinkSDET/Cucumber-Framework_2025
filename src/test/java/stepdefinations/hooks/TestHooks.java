package stepdefinations.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testBaseSetup.DriverManager;
import testBaseSetup.utils.LoggerUtil;

public class TestHooks {
    private final DriverManager driverManager;

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