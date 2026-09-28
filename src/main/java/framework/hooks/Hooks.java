package framework.hooks;

import framework.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


/*
 * Hooks.java
 * You never have to think about opening or closing the browser in your
 * step definitions anymore — Hooks handles it for you.
 */
public class Hooks {

    // @Before runs automatically before each Scenario in your feature files
    @Before
    public void beforeEachScenario(Scenario scenario) {
        System.out.println("Starting Scenario: " + scenario.getName());


        DriverManager.openBrowser();
    }

    // @After runs automatically after each Scenario — even if the test FAILS
    // This is important because it guarantees the browser always closes
    @After
    public void afterEachScenario(Scenario scenario) {


        if (scenario.isFailed()) {
            System.out.println("Scenario FAILED: " + scenario.getName());
        } else {
            System.out.println("Scenario PASSED: " + scenario.getName());
        }

        DriverManager.closeBrowser();
    }
}
