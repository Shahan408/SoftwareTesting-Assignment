package framework.pages;

import framework.driver.DriverManager;
import framework.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class TC_010_PAGE {
    private static final Logger log = LoggerFactory.getLogger(TC_010_PAGE.class);

    private WebDriver driver;
    private WebDriverWait wait;

    public TC_010_PAGE() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_SECONDS));
    }

    // Login locators
    private By loginEmail = By.cssSelector("input[type='email']");
    private By loginPassword = By.cssSelector("input[type='password']");
    private By loginSubmit = By.cssSelector("button[type='submit']");

    // Register Company button
    private By registerCompanyBtn = By.xpath("//a[@class='button button-primary']");

    private By submitBtn = By.xpath("//button[@type='submit']");
//    private By validationErrors = By.cssSelector(".inline-error");

    private By validationErrors = By.xpath("//div[@class='inline-error']");

    public void login(){
        driver.get(Constants.BASE_URL);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {}

        driver.findElement(loginEmail).sendKeys(Constants.EMAIL);
        driver.findElement(loginPassword).sendKeys(Constants.PASSWORD);
        driver.findElement(loginSubmit).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}

        log.info("Logged into dashboard");
    }

    public void goToRegisterCompanyPage(){
        driver.findElement(registerCompanyBtn).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        log.info("Navigated to Register Company page");
    }

    public void submitEmptyForm(){
        driver.findElement(submitBtn).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        log.info("Submitted empty registration form");
    }

    public boolean areValidationErrorsDisplayed(){
        List<WebElement> errors = driver.findElements(validationErrors);
        int count = errors.size();
        log.info("Validation errors found: " + count);

        if (count > 0) {
            String errorText = errors.get(0).getText();
            log.info("Error text: " + errorText);
            return true;
        } else {
            return false;
        }
    }

    public boolean isStillOnRegisterPage(){
        String url = driver.getCurrentUrl();
        log.info("Current URL: " + url);
        return url.contains("companies/new");
    }
}