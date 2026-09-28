package framework.pages;

import framework.driver.DriverManager;
import framework.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class TC_005_PAGE {
    private static final Logger log = LoggerFactory.getLogger(TC_005_PAGE.class);

    private WebDriver driver;
    private WebDriverWait wait;

    public TC_005_PAGE() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_SECONDS));
    }
    private By password = By.cssSelector(".password-field input");
    private By eyeIcon = By.cssSelector(".password-field button");

    public void openweb(){
        driver.get(Constants.BASE_URL);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("Opening website");
    }

    public void enterPassword(){
        driver.findElement(password).sendKeys(Constants.PASSWORD);
        log.info("Entering password");
    }

    public void clickEyeIcon(){
        WebElement eye = wait.until(ExpectedConditions.elementToBeClickable(eyeIcon));
        eye.click();
        log.info("Clicking eye icon to toggle password visibility");
    }

    public String getPasswordFieldType(){
        String type = driver.findElement(password).getAttribute("type");
        log.info("Password field type is now: " + type);
        return type;
    }
}