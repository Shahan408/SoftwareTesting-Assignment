package framework.pages;

import framework.driver.DriverManager;
import framework.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class TC_007_PAGE {
    private static final Logger log = LoggerFactory.getLogger(TC_007_PAGE.class);

    private WebDriver driver;
    private WebDriverWait wait;

    public TC_007_PAGE() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_SECONDS));
    }

    private By emailField = By.cssSelector(".password-field input");
    private By passwordField = By.cssSelector(".password-field input");
    private By loginEmail = By.cssSelector("input[type='email']");
    private By loginPassword = By.cssSelector("input[type='password']");
    private By submitBtn = By.cssSelector("button[type='submit']");

    // Sidebar links — guessed via visible text, confirm/adjust if they fail
    private By overviewLink = By.xpath("//*[contains(text(),'Overview')]");
    private By companiesLink = By.xpath("//*[contains(text(),'Companies')]");
    private By platformAdminsLink = By.xpath("//*[contains(text(),'Platform Admins')]");
    private By auditLink = By.xpath("//*[contains(text(),'Audit')]");
    private By settingsLink = By.xpath("//*[contains(text(),'Settings')]");

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
            Thread.sleep(5000); // allow dashboard to load post-login
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("Logged into dashboard");
    }

    public void clickLink(By locator, String name){
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(locator));
        link.click();
        log.info("Clicked sidebar link: " + name);
        try {
            Thread.sleep(3000); // allow page transition
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void clickOverview(){ clickLink(overviewLink, "Overview"); }
    public void clickCompanies(){ clickLink(companiesLink, "Companies"); }
    public void clickPlatformAdmins(){ clickLink(platformAdminsLink, "Platform Admins"); }
    public void clickAudit(){ clickLink(auditLink, "Audit"); }
    public void clickSettings(){ clickLink(settingsLink, "Settings"); }

    public String getCurrentUrl(){
        String url = driver.getCurrentUrl();
        log.info("Current URL: " + url);
        return url;
    }

    public boolean urlContains(String segment){
        return getCurrentUrl().toLowerCase().contains(segment.toLowerCase());
    }
}