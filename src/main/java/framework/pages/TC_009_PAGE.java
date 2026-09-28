package framework.pages;

import framework.driver.DriverManager;
import framework.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class TC_009_PAGE {
    private static final Logger log = LoggerFactory.getLogger(TC_009_PAGE.class);

    private WebDriver driver;
    private WebDriverWait wait;

    public TC_009_PAGE() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_SECONDS));
    }

    // Login locators
    private By loginEmail = By.cssSelector("input[type='email']");
    private By loginPassword = By.cssSelector("input[type='password']");
    private By loginSubmit = By.cssSelector("button[type='submit']");

    // Register Company button
    private By registerCompanyBtn = By.xpath("//a[@class='button button-primary']");

    // Company information fields
    private By companyName = By.xpath("//section[1]//label[1]//input[1]");
    private By slug = By.xpath("//section[1]//label[2]//input[1]");
    private By officialEmail = By.xpath("//section[1]//label[3]//input[1]");
    private By phoneNumber = By.xpath("//section[1]//label[4]//input[1]");
    private By industryDropdown = By.xpath("//select[1]");
    private By companySize = By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/form[1]/section[1]/label[6]/input[1]");
    private By address = By.xpath("//label[7]//input[1]");

    // Initial owner fields
    private By ownerName = By.xpath("//section[2]//label[1]//input[1]");
    private By ownerEmail = By.xpath("//section[2]//label[2]//input[1]");
    private By ownerPhone = By.xpath("//section[2]//label[3]//input[1]");
    private By tempPassword = By.xpath("(//div[@class='password-field']//input[@type='password'])[1]");
    private By confirmPassword = By.xpath("//section[2]//label[4]//input[1]");
    private By submitBtn = By.xpath("//button[@type='submit']");

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

    public void fillCompanyInformation(){
        driver.findElement(companyName).sendKeys("AutoTestCompany1");
        driver.findElement(slug).sendKeys("autotestcompany1");
        driver.findElement(officialEmail).sendKeys("company1@example.com");
        driver.findElement(phoneNumber).sendKeys("03001234567");

        Select industry = new Select(driver.findElement(industryDropdown));
        industry.selectByVisibleText("Technology");

        driver.findElement(companySize).sendKeys("50");
        driver.findElement(address).sendKeys("123 Test Street, Karachi");

        log.info("Filled company information");
    }

    public void fillInitialOwnerDetails(){
        driver.findElement(ownerName).sendKeys("Auto Test Owner");
        driver.findElement(ownerEmail).sendKeys("owner1@example.com");
        driver.findElement(ownerPhone).sendKeys("03007654321");

        driver.findElement(tempPassword).sendKeys("TempPass123!");
        driver.findElement(confirmPassword).sendKeys("TempPass123!");

        log.info("Filled initial owner details");
    }

    public void submitForm(){
        driver.findElement(submitBtn).click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {}

        log.info("Submitted company registration form");
    }

    public boolean isCompanyCreatedSuccessfully(){
        try {
            Thread.sleep(6000); // give more time for redirect + list to load
        } catch (InterruptedException e) {}

        String currentUrl = driver.getCurrentUrl();
        log.info("Current URL after submission: " + currentUrl);

        boolean found = driver.getPageSource().contains("AutoTestCompany1");
        log.info("Company found on page after submission: " + found);

        return found;
    }
}