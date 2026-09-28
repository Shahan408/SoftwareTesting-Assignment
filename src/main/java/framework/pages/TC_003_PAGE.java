package framework.pages;

import framework.driver.DriverManager;
import framework.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class TC_003_PAGE {
    private static final Logger log = LoggerFactory.getLogger(TC_003_PAGE.class);

    private WebDriver driver;
    private WebDriverWait wait;

    public TC_003_PAGE() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_SECONDS));
    }

    private By submitBtn = By.cssSelector("button[type='submit']");
    private By validationErrors = By.cssSelector(".inline-error"); // reusing same class — confirm below

    public void openweb(){
        driver.get(Constants.BASE_URL);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("Opening website");
    }

    public void leaveFieldsEmpty(){
        // intentionally doing nothing — fields stay blank
        log.info("Leaving email and password fields empty");
    }

    public void clickSubmit(){
        driver.findElement(submitBtn).click();
        log.info("Clicking submit with empty fields");
    }

    public boolean areValidationErrorsDisplayed(){
        List<WebElement> errors = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(validationErrors)
        );
        log.info("Validation errors found: " + errors.size());
        for (WebElement e : errors) {
            log.info("Error text: " + e.getText());
        }
        return !errors.isEmpty();
    }
}