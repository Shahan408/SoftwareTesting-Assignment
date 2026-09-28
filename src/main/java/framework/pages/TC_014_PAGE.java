package framework.pages;

import framework.driver.DriverManager;
import framework.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TC_014_PAGE {

    private static final Logger log = LoggerFactory.getLogger(TC_014_PAGE.class);

    private WebDriver driver;

    public TC_014_PAGE() {
        this.driver = DriverManager.getDriver();
    }

    // Login
    private By loginEmail = By.cssSelector("input[type='email']");
    private By loginPassword = By.cssSelector("input[type='password']");
    private By loginSubmit = By.cssSelector("button[type='submit']");

    // Sidebar
    private By companiesLink = By.xpath("//*[contains(text(),'Companies')]");

    // Status Filter
    private By statusFilter = By.xpath("//select[1]");

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

    public void filterByStatus(String status) {

        Select select = new Select(driver.findElement(statusFilter));

        select.selectByVisibleText(status);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        log.info("Filtered companies by status: " + status);
    }

    public boolean isStatusSelected(String status) {

        Select select = new Select(driver.findElement(statusFilter));

        String selectedStatus = select.getFirstSelectedOption().getText();

        log.info("Selected status: " + selectedStatus);

        return selectedStatus.equals(status);
    }
}