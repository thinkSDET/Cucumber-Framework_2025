package base;

import org.openqa.selenium.WebDriver;
import utils.LoggerUtil;

import java.time.Duration;

public class DriverManager {

    public static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static void invokeDriver() {
        WebDriver driver = BrowserManager.setAndInvokeBrowser("chrome");
        LoggerUtil.getLogger().info("Thread ID: {}", Thread.currentThread().threadId());
        driverThreadLocal.set(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getImplicitWait())));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        LoggerUtil.getLogger().info("Driver initialized successfully");
    }

    public static WebDriver getDriver(){
        return driverThreadLocal.get();
    }

    public static void removeDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            LoggerUtil.getLogger().info("Driver quit successfully");
        }
        driverThreadLocal.remove();
    }
}
