package framework.pages;

import framework.driver.DriverManager;
import framework.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class TC_011_PAGE {
    private static final Logger log = LoggerFactory.getLogger(TC_011_PAGE.class);

    private WebDriver driver;
    private WebDriverWait wait;

    public TC_011_PAGE() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_SECONDS));
    }

    // Login locators
    private By loginEmail = By.cssSelector("input[type='email']");
    private By loginPassword = By.cssSelector("input[type='password']");
    private By loginSubmit = By.cssSelector("button[type='submit']");

    // Sidebar
    private By companiesLink = By.xpath("//*[contains(text(),'Companies')]");

    // Search
    private By searchBox = By.xpath("//input[@placeholder='Search name or slug…']");

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

    public void goToCompaniesPage(){
        driver.findElement(companiesLink).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        log.info("Navigated to Companies page");
    }

    public void searchFor(String keyword){
        driver.findElement(searchBox).sendKeys(keyword);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        log.info("Searched for: " + keyword);
    }

    public boolean isCompanyDisplayed(String companyName) {
        boolean found = driver.getPageSource().contains(companyName);
        log.info("Company '" + companyName + "' displayed after search: " + found);
        return found;
    }

}