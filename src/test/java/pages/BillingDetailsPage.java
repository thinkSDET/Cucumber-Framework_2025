package pages;

import testBaseSetup.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class BillingDetailsPage extends BasePage {
    @FindBy(xpath = "//input[@name='billing_first_name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='billing_last_name']")
    private WebElement lastName;

    @FindBy(xpath = "//div[@class='woocommerce-billing-fields']//span[@aria-label='Country / Region']")
    private WebElement countryOrRegion;

    @FindBy(xpath = "//input[@name='billing_address_1']")
    private WebElement streetAddress;

    @FindBy(xpath = "//input[@name='billing_city']")
    private WebElement townOrCity;

    @FindBy(xpath = "//div[@class='woocommerce-billing-fields']//span[@id='select2-billing_state-container']")
    private WebElement stateOrCountry;

    @FindBy(xpath = "//input[@id='billing_postcode']")
    private WebElement postcodeOrZipCode;

    @FindBy(xpath = "//input[@id='billing_email']")
    private WebElement emailAddress;

    @FindBy(xpath = "//button[@id='place_order']")
    private WebElement placeOrderBtn;

    public BillingDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void fillBillingDetails(List<Map<String, String>> data){
        firstName.sendKeys(data.getFirst().get("firstname"));
        lastName.sendKeys(data.getFirst().get("lastname"));
        selectValueFromDropDown(data.getFirst().get("country"),"//ul[@id='select2-billing_country-results']//li",countryOrRegion);
        streetAddress.sendKeys(data.getFirst().get("streetAddress"));
        townOrCity.sendKeys(data.getFirst().get("town/city"));
        selectValueFromDropDown(data.getFirst().get("state"),"//ul[@id='select2-billing_state-results']//li",stateOrCountry);
        postcodeOrZipCode.sendKeys(data.getFirst().get("pinCode"));
        emailAddress.sendKeys(data.getFirst().get("email"));
    }
    public void placeTheOrder(){
       /* JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('.blockUI.blockOverlay').remove();");*/
     //   placeOrderBtn.click();
        safeClick(placeOrderBtn);
    }

    public void selectValueFromDropDown(String value,String locator, WebElement element){
        element.click();
        List<WebElement> options = driver.findElements(By.xpath(locator));
       for(WebElement option : options){
           if(option.getText().equals(value)){
               option.click();
               break;
           }
       }
    }
}
