package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.LoggerUtil;

public class BrowserManager {


    public static WebDriver setAndInvokeBrowser(String browser){
        WebDriver driver;
        String browserName = browser.toLowerCase().trim();
        driver = switch (browserName) {
            case "chrome" -> setChromeDriver();
            case "ff", "firefox" -> setupFirefoxDriver();
            case "edge" -> setupEdgeDriver();
            default -> throw new RuntimeException("Please pass the right browser");
        };
        LoggerUtil.info(browserName + "Invoked");
        return driver;
    }

    private static ChromeDriver setChromeDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        if(ConfigManager.getHeadLessMode()){
            chromeOptions.addArguments("--headless=new");  // Run in headless mode
        }
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-popup-blocking");
        return new ChromeDriver(chromeOptions);
    }

    private static WebDriver setupFirefoxDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        return new FirefoxDriver(firefoxOptions);
    }

    private static WebDriver setupEdgeDriver() {
        EdgeOptions edgeOptions = new EdgeOptions();
        return new EdgeDriver(edgeOptions);
    }
}
