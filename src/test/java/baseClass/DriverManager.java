package baseClass;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    public static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static void invokeDriver() {
        WebDriver driver = BrowserManager.setAndInvokeBrowser("chrome");
        System.out.println("Thread ID: " + Thread.currentThread().threadId());
        driverThreadLocal.set(driver);
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
        }
        driverThreadLocal.remove();
    }
}
