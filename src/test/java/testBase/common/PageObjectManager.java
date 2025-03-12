package testBase.common;

import org.openqa.selenium.WebDriver;
import testBase.DriverManager;
import pages.*;

/**
 * This class acts as a container for page objects, ensuring dependency injection.
 * Instead of instantiating all page objects at once, initialize them only when needed (Lazy Loading).
 * Saves memory and improves performance.
 * Objects are created only when required, which makes your framework more memory-efficient.
 */
public class PageObjectManager {
    private final WebDriver driver;
    private BillingDetailsPage billingDetailsPage;
    private CartPage cartPage;
    private CheckOutPage checkOutPage;
    private ZeptoHomePage launchPage;
    private OrderPage orderPage;
    private StorePage storePage;

    public PageObjectManager(DriverManager driverManager) {
        this.driver = driverManager.getDriver();
    }

    public BillingDetailsPage getBillingDetailsPage() {
        if (billingDetailsPage == null) {
            billingDetailsPage = new BillingDetailsPage(driver);
        }
        return billingDetailsPage;
    }

    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage(driver);
        }
        return cartPage;
    }

    public ZeptoHomePage getLaunchPage() {
        if (launchPage == null) {
            launchPage = new ZeptoHomePage(driver);
        }
        return launchPage;
    }

    public OrderPage getOrderPage() {
        if (orderPage == null) {
            orderPage = new OrderPage(driver);
        }
        return orderPage;
    }

    public CheckOutPage getCheckOutPage() {
        if (checkOutPage == null) {
            checkOutPage = new CheckOutPage(driver);
        }
        return checkOutPage;
    }

    public StorePage getStorePage() {
        if (storePage == null) {
            storePage = new StorePage(driver);
        }
        return storePage;
    }
}
