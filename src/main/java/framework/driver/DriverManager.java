package framework.driver;

import framework.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.logging.Logger;

public class DriverManager {

    private static final Logger log = Logger.getLogger(DriverManager.class.getName());
    private static WebDriver driver;

    public static void openBrowser() {

        String browser = Constants.BROWSER.toLowerCase();
        boolean headless = Constants.HEADLESS;

        log.info("Opening browser: " + browser + " | Headless: " + headless);

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
//        options.addArguments("--disable-popup-blocking");

        if (headless) {
            options.addArguments("--headless=new");
        }

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        log.info("Browser opened successfully");
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeBrowser() {
        if (driver != null) {
            log.info("Closing browser");
            driver.quit();
            driver = null;
        }
    }
}