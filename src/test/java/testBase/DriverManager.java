package testBase;

import org.openqa.selenium.WebDriver;
import testBase.utils.LoggerUtil;

import java.time.Duration;

public class DriverManager {
    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            driver = BrowserManager.setAndInvokeBrowser(ConfigManager.getBrowser());
            LoggerUtil.info("Driver is initialized");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getImplicitWait())));
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            LoggerUtil.info("Driver is closed");
            driver = null;
        }
    }
}
