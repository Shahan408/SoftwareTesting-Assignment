package framework.pages;

import framework.driver.DriverManager;
import framework.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class TC_006_PAGE {
    private static final Logger log = LoggerFactory.getLogger(TC_006_PAGE.class);

    private WebDriver driver;
    private WebDriverWait wait;

    public TC_006_PAGE() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_SECONDS));
    }

    private By emailField = By.cssSelector("input[type='email']");

    public void navigateDirectlyToDashboard(){
        // Attempt direct access — assumes dashboard route is "/dashboard" or similar
        // Adjust this URL once you confirm the actual authenticated dashboard route
        driver.get(Constants.BASE_URL + "dashboard");

        try {
            Thread.sleep(8000); // allow redirect / app logic to settle
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        log.info("Attempted direct navigation to dashboard without login");
    }

    public boolean isRedirectedToLoginPage(){
        boolean emailFieldPresent = !driver.findElements(emailField).isEmpty();
        log.info("Login page email field present after redirect: " + emailFieldPresent);
        return emailFieldPresent;
    }

    public String getCurrentUrl(){
        String url = driver.getCurrentUrl();
        log.info("Current URL: " + url);
        return url;
    }
}