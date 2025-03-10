package pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void verifyTheOrderDetailsPage(){
        System.out.println("verified the order details page");
    }
}
