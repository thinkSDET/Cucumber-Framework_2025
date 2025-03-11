package testBaseSetup.common;

import org.openqa.selenium.WebDriver;
import testBaseSetup.DriverManager;
import pages.*;

/**
 * This class acts as a container for page objects, ensuring dependency injection.
 */
public class PageObjectManager {
    private final DriverManager driverManager;
    private final BillingDetailsPage billingDetailsPage;
    private final CartPage cartPage;
    private final CheckOutPage checkOutPage;
    private final LaunchPage launchPage;
    private final OrderPage orderPage;
    private final StorePage storePage;


    public PageObjectManager(DriverManager driverManager) {
        this.driverManager = driverManager;
        this.billingDetailsPage = new BillingDetailsPage(driverManager.getDriver());
        this.cartPage = new CartPage(driverManager.getDriver());
        this.launchPage = new LaunchPage(driverManager.getDriver());
        this.orderPage = new OrderPage(driverManager.getDriver());
        this.storePage = new StorePage(driverManager.getDriver());
        this.checkOutPage = new CheckOutPage(driverManager.getDriver());
    }

    public BillingDetailsPage getBillingDetailsPage() {
        return billingDetailsPage;
    }

    public CartPage getCartPage() {
        return cartPage;
    }

    public LaunchPage getLaunchPage() {
        return launchPage;
    }

    public OrderPage getOrderPage() {
        return orderPage;
    }
    public CheckOutPage getCheckOutPage() {
        return checkOutPage;
    }

    public StorePage getStorePage() {
        return storePage;
    }
}
