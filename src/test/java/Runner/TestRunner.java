package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*
 * TestRunner.java
 *
 * This is the ENTRY POINT for running your tests.
 * When you right-click this file and click "Run", it:
 * 1. Finds all your .feature files (from the "features" folder)
 * 2. Matches each step in the feature files to a method in StepDefinitions
 * 3. Runs them and generates a report
 *
 * CucumberOptions settings:
 *   features  → where your .feature files are
 *   glue      → where your Step Definitions AND Hooks are (Cucumber scans these packages)
 *   plugin    → what kind of reports to generate
 *   monochrome → makes the console output cleaner (no weird symbols)
 */
@CucumberOptions(
        features   = "src/main/resources/feature",
        glue       = {"StepDefinitions", "framework.hooks"},
        plugin     = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
