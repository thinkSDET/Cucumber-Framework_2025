package testBaseSetup;

import org.openqa.selenium.WebDriver;
import testBaseSetup.utils.LoggerUtil;

import java.time.Duration;

public class DriverManager {

    public static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static void invokeDriver() {
        WebDriver driver = BrowserManager.setAndInvokeBrowser(ConfigManager.getBrowser());
        driverThreadLocal.set(driver);
        LoggerUtil.info("Driver is initialized");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getImplicitWait())));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public static WebDriver getDriver(){
        return driverThreadLocal.get();
    }

    public static void removeDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            LoggerUtil.info("Driver is closed");
        }
        driverThreadLocal.remove();
    }
}
