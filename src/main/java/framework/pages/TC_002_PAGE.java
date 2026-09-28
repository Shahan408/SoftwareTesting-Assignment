package framework.pages;

import framework.driver.DriverManager;
import framework.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class TC_002_PAGE {
    private static final Logger log = LoggerFactory.getLogger(TC_002_PAGE.class);

    private WebDriver driver;
    private WebDriverWait wait;

    public TC_002_PAGE() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_SECONDS));
    }

    private By email = By.cssSelector("input[type='email']");
    private By password = By.cssSelector("input[type='password']");
    private By submitBtn = By.cssSelector("button[type='submit']");
    private By errorMessage = By.cssSelector(".inline-error"); // ✅ real locator now

    public void openweb(){
        driver.get(Constants.BASE_URL);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("Opening website");
    }

    public void enterEmail(){
        driver.findElement(email).sendKeys(Constants.EMAIL);
        log.info("Entering email");
    }

    public void enterWrongPassword(){
        driver.findElement(password).sendKeys("wrongPassword123");
        log.info("Entering incorrect password");
    }

    public void clickSubmit(){
        driver.findElement(submitBtn).click();
        log.info("Clicking submit");
    }

    public boolean isErrorMessageDisplayed(){
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        log.info("Error message displayed: " + error.getText());
        return error.isDisplayed();
    }
}
