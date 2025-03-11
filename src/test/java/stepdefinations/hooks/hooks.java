package stepdefinations.hooks;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.PicoContainer;
import org.picocontainer.annotations.Inject;
import testBaseSetup.DriverManager;
import testBaseSetup.common.PageObjectManager;
import testBaseSetup.utils.LoggerUtil;

public class hooks {
    private final DriverManager driverManager;

    public hooks(DriverManager driverManager) {
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