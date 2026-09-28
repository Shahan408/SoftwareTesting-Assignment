package framework.pages;

import framework.driver.DriverManager;
import framework.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TC_012_PAGE {

    private static final Logger log = LoggerFactory.getLogger(TC_012_PAGE.class);

    private WebDriver driver;

    public TC_012_PAGE() {
        this.driver = DriverManager.getDriver();
    }

    // Login
    private By loginEmail = By.cssSelector("input[type='email']");
    private By loginPassword = By.cssSelector("input[type='password']");
    private By loginSubmit = By.cssSelector("button[type='submit']");

    // Sidebar
    private By companiesLink = By.xpath("//*[contains(text(),'Companies')]");

    // Search
    private By searchBox = By.xpath("//input[@placeholder='Search name or slug…']");

    public void login() {

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

    public void goToCompaniesPage() {

        driver.findElement(companiesLink).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        log.info("Navigated to Companies page");
    }

    public void searchFor(String keyword) {

        driver.findElement(searchBox).sendKeys(keyword);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        log.info("Searched for: " + keyword);
    }

    public boolean isCompanyNotDisplayed(String companyName) {

        By noCompaniesFound = By.xpath("//h3[normalize-space()='No companies found']");

        boolean found = driver.findElements(noCompaniesFound).size() > 0;

        log.info("No companies found message displayed: " + found);

        return found;
    }
}