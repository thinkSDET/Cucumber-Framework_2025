package testBase.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class ScreenshotUtil {

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public static byte[] captureScreenshot(WebDriver driver) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Failure Screenshot", "image/png", new ByteArrayInputStream(screenshot), ".png"); // Store inside allure-results
        return screenshot;
    }
}
