package framework.pages;

import framework.driver.DriverManager;
import framework.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class TC_001_PAGE {
    private static final Logger log = LoggerFactory.getLogger(TC_001_PAGE.class);

    private WebDriver driver;
    private WebDriverWait wait;

    public TC_001_PAGE() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_SECONDS));
    }


    private By email =  By.cssSelector("input[type='email']");
    private By password = By.cssSelector("input[type='password']");
    private By submitBtn = By.cssSelector("button[type='submit']");


    public void openweb(){
        driver.get(Constants.BASE_URL);

        try {
            Thread.sleep(5000); // wait 10 seconds for page to fully render before doing anything
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        log.info("Opening website");
    }
    public void enterEmail(){
        WebElement emailField = driver.findElement(email);
        emailField.sendKeys(Constants.EMAIL);
        log.info("Entering email");
    }

    public void enterPassword(){
        WebElement passwordField = driver.findElement(password);
        passwordField.sendKeys(Constants.PASSWORD);
        log.info("Entering password");
    }
    public void clickSubmit(){
       WebElement submit =  driver.findElement(submitBtn);
       submit.click();
        log.info("Clicking submit");
    }

}
