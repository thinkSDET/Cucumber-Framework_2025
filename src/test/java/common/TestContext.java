package common;

import base.DriverManager;
import pages.*;

/**
 * This class acts as a container for page objects, ensuring dependency injection.
 */
public class TestContext {

    private final BillingDetailsPage billingDetailsPage;
    private final CartPage cartPage;
    private final CheckOutPage checkOutPage;
    private final LaunchPage launchPage;
    private final OrderPage orderPage;
    private final StorePage storePage;


    public TestContext() {
        this.billingDetailsPage = new BillingDetailsPage(DriverManager.getDriver());
        this.cartPage = new CartPage(DriverManager.getDriver());
        this.launchPage = new LaunchPage(DriverManager.getDriver());
        this.orderPage = new OrderPage(DriverManager.getDriver());
        this.storePage = new StorePage(DriverManager.getDriver());
        this.checkOutPage = new CheckOutPage(DriverManager.getDriver());
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
