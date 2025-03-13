package pages;

import io.cucumber.java.it.Ma;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.basePage.BasePage;
import utility.TestDataGenerator;
import utility.TestDataStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountPage extends BasePage {
    @FindBy(id = "reg_username")
    private WebElement userName;

    @FindBy(id = "reg_email")
    private WebElement email;

    @FindBy(id = "reg_password")
    private WebElement password;

    @FindBy(name = "register")
    private WebElement registerBtn;

    @FindBy(xpath = "(//a[@href='https://askomdch.com/account/edit-account/'])[2]")
    private WebElement confirmationMessage;


    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void fillNewUserRegistrationForm(List<Map<String, String>> testDataList) {
        for (Map<String, String> testData : testDataList) {

            //Convert to Mutable Map
            Map<String, String> modifiableData = new HashMap<>(testData);

            modifiableData.put("Username", TestDataGenerator.generateRandomUsername());
            modifiableData.put("Email", TestDataGenerator.generateRandomEmail());

            TestDataStorage.saveTestData(modifiableData.get("Username"), modifiableData.get("Email"));
            enterRegistrationDetails(modifiableData);
        }
    }

    private void enterRegistrationDetails(Map<String, String> testData) {
        userName.sendKeys(testData.get("Username"));
        email.sendKeys(testData.get("Email"));
        password.sendKeys(testData.get("Password"));
    }
    public void clickOnRegisterBtn(){
        registerBtn.click();
    }

    public String verifyConfirmationMessageForNewUserRegistration(){
        waitForElementToVisible(confirmationMessage);
        System.out.println(confirmationMessage.getText());
        return confirmationMessage.getText();
    }
}
