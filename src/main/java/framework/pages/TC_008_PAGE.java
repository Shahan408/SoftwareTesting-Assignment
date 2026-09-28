package framework.pages;

import framework.driver.DriverManager;
import framework.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class TC_008_PAGE {
    private static final Logger log = LoggerFactory.getLogger(TC_008_PAGE.class);

    private WebDriver driver;
    private WebDriverWait wait;

    public TC_008_PAGE() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_SECONDS));
    }

    private By loginEmail = By.cssSelector("input[type='email']");
    private By loginPassword = By.cssSelector("input[type='password']");
    private By submitBtn = By.cssSelector("button[type='submit']");
    private By logoutBtn = By.xpath("//*[contains(text(),'Log out')]");

    public void login(){
        driver.get(Constants.BASE_URL);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        driver.findElement(loginEmail).sendKeys(Constants.EMAIL);
        driver.findElement(loginPassword).sendKeys(Constants.PASSWORD);
        driver.findElement(submitBtn).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("Logged into dashboard");
    }

    public void clickLogout(){
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
        logout.click();
        log.info("Clicked logout");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean isOnLoginPage(){
        boolean present = !driver.findElements(loginEmail).isEmpty();
        log.info("Login page email field present: " + present);
        return present;
    }

    public void navigateBack(){
        driver.navigate().back();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("Navigated back after logout");
    }

    public boolean isStillOnLoginPage(){
        return isOnLoginPage();
    }
}