package testBase;

import org.openqa.selenium.WebDriver;
import testBase.utils.LoggerUtil;

import java.time.Duration;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            WebDriver driver = BrowserManager.setAndInvokeBrowser(ConfigManager.getBrowser());
            LoggerUtil.info("Thread ID: " + Thread.currentThread().getId() + " - Driver initialized");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getImplicitWait())));
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driverThreadLocal.set(driver);  // Store the driver instance for the current thread
        }
        return driverThreadLocal.get();
    }

    public void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            LoggerUtil.info("Thread ID: " + Thread.currentThread().getId() + " - Driver closed");
            driverThreadLocal.remove();  // Remove driver instance from ThreadLocal
        }
    }
}
