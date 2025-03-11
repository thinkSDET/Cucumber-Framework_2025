package pages;

import pages.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {
    @FindBy(xpath = "//a[normalize-space(text())='Proceed to checkout']")
    private WebElement proceedToCheckoutBtn;
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToCheckoutPage(){
        proceedToCheckoutBtn.click();
    }

}
