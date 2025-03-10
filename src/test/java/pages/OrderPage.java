package pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class OrderPage extends BasePage {
    @FindBy(xpath = "//td[@class='woocommerce-table__product-name product-name']//a")
    private WebElement productName;
    @FindBy(xpath = "//th[text()='Subtotal:']/parent::tr//td//span[@class='woocommerce-Price-amount amount']")
    private WebElement subtotal;
    @FindBy(xpath = "//th[text()='Payment method:']/following-sibling::td")
    private WebElement paymentMethod;
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void verifyTheOrderDetailsPage(List<Map<String,String>> data){
        waitUntilPageGetsFullyLoaded();
        Assert.assertEquals(productName.getText(),data.getFirst().get("productName"));
        Assert.assertEquals(subtotal.getText(),data.getFirst().get("subtotal"));
        Assert.assertEquals(paymentMethod.getText(),data.getFirst().get("paymentMethod"));
    }
}
