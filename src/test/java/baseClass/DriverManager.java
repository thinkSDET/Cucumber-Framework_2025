package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public static WebDriver driver;

    public static WebDriver invokeDriver() {
        driver = new ChromeDriver();
        driverThreadLocal.set(driver);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

    public static WebDriver getDriver(){
        return driverThreadLocal.get();
    }
}
