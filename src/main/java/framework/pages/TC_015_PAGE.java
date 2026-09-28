package framework.pages;

import framework.driver.DriverManager;
import framework.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TC_015_PAGE {

    private static final Logger log = LoggerFactory.getLogger(TC_015_PAGE.class);

    private WebDriver driver;

    public TC_015_PAGE() {
        this.driver = DriverManager.getDriver();
    }

    // Login
    private By loginEmail = By.cssSelector("input[type='email']");
    private By loginPassword = By.cssSelector("input[type='password']");
    private By loginSubmit = By.cssSelector("button[type='submit']");

    // Sidebar
    private By companiesLink = By.xpath("//*[contains(text(),'Companies')]");

    // Industry Filter
    private By industryFilter = By.xpath("//select[2]");

    // View Company
    private By viewCompany = By.xpath("//tbody/tr[1]/td[8]/div/a[1]/span");


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


    public void filterByIndustry(String industry) {

        Select select = new Select(driver.findElement(industryFilter));

        select.selectByVisibleText(industry);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        log.info("Filtered companies by industry: " + industry);
    }


    public boolean isIndustrySelected(String industry) {

        Select select = new Select(driver.findElement(industryFilter));

        String selectedIndustry = select.getFirstSelectedOption().getText();

        log.info("Selected industry: " + selectedIndustry);

        return selectedIndustry.equals(industry);
    }


    public void openCompany() {

        driver.findElement(viewCompany).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        log.info("Opened company details");
    }
}