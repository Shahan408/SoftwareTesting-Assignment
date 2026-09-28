package framework.pages;

import framework.driver.DriverManager;
import framework.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class TC_004_PAGE {
    private static final Logger log = LoggerFactory.getLogger(TC_004_PAGE.class);

    private WebDriver driver;
    private WebDriverWait wait;

    public TC_004_PAGE() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_SECONDS));
    }

    private By email = By.cssSelector("input[type='email']");
    private By password = By.cssSelector("input[type='password']");
    private By submitBtn = By.cssSelector("button[type='submit']");
    private By validationError = By.cssSelector(".inline-error"); // reusing known class — confirm after run

    public void openweb(){
        driver.get(Constants.BASE_URL);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("Opening website");
    }

    public void enterMalformedEmail(){
        driver.findElement(email).sendKeys("test.com"); // no "@" — invalid format
        log.info("Entering malformed email");
    }

    public void enterPassword(){
        driver.findElement(password).sendKeys(Constants.PASSWORD);
        log.info("Entering password");
    }

    public void clickSubmit(){
        driver.findElement(submitBtn).click();
        log.info("Clicking submit");
    }

    public boolean isEmailValidationErrorDisplayed(){
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(validationError));
        log.info("Email validation error displayed: " + error.getText());
        return error.isDisplayed();
    }
}