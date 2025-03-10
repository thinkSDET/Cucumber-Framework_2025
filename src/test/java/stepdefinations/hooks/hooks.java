package stepdefinations.hooks;

import base.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {


    @Before
    public void beforeHook(){
       DriverManager.invokeDriver(); // Initialize the driver for the current thread
    }

    @After
    public void tearDown(){
        DriverManager.getDriver().quit(); // Quit the driver for the current thread
        DriverManager.removeDriver(); // Remove the ThreadLocal instance
    }
}
