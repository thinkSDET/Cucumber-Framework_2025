package stepdefinations.hooks;

import baseClass.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

public class hooks {

    private static WebDriver driver;

    @Before
    public void beforeHook(){
        driver =  DriverManager.invokeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
