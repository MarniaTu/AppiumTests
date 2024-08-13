import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class NewTextInputTest {
    private AndroidDriver driver;
    private MobileObjects mobileObjects;

    String emptyLine = "     ";
    String newInputText = "Hello, Appium";

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("appium:deviceName", "Samsung Galaxy");
        caps.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        caps.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        caps.setCapability("appium:automationName", "uiautomator2");
        caps.setCapability("appium:ensureWebviewsHavePages", true);
        caps.setCapability("appium:nativeWebScreenshot", true);
        caps.setCapability("appium:newCommandTimeout", 3600);
        caps.setCapability("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(this.getUrl(), caps);

        mobileObjects = new MobileObjects(driver);

    }


    @Test
    public void emptyLineInputTest() {

        mobileObjects.initialText.isDisplayed();
//        MobileElement initialText = (MobileElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/textToBeChanged"));

        mobileObjects.userInput.isDisplayed();
        mobileObjects.userInput.sendKeys(emptyLine);
//        MobileElement userInput = (MobileElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
//        userInput.isDisplayed();
//        userInput.sendKeys(emptyLine);

        mobileObjects.btnChange.isDisplayed();
        mobileObjects.btnChange.click();
//        MobileElement btnChange = (MobileElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonChange"));
//        btnChange.isDisplayed();
//        btnChange.click();

        mobileObjects.changedText.isDisplayed();
//        MobileElement changedText = (MobileElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/textToBeChanged"));

        Assertions.assertEquals(mobileObjects.changedText.getText(), mobileObjects.initialText.getText());


    }

    @Test
    public void secondActivityTextTest() {

        mobileObjects.userInput.isDisplayed();
        mobileObjects.userInput.sendKeys(newInputText);
//        MobileElement userInput = (MobileElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
//        userInput.isDisplayed();
//        userInput.sendKeys(newInputText);

        mobileObjects.btnActivity.isDisplayed();
        mobileObjects.btnActivity.click();
//        MobileElement btnActivity = (MobileElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonActivity"));
//        btnActivity.isDisplayed();
//        btnActivity.click();

        mobileObjects.secondActivity.isDisplayed();
//        MobileElement secondActivity = (MobileElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/text"));
//        secondActivity.isDisplayed();

        Assertions.assertEquals(mobileObjects.secondActivity.getText(), newInputText);


    }

    @AfterEach

    public void tearDown() {
        driver.quit();
    }

}


