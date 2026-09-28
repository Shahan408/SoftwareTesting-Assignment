package StepDefinitions;

import framework.pages.TC_006_PAGE;
import io.cucumber.java.en.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class TC_006 {
    TC_006_PAGE unauthAccess = new TC_006_PAGE();
    private static final Logger log = LoggerFactory.getLogger(TC_006.class);

    @Given("the user has not logged in for TC006")
    public void the_user_has_not_logged_in_for_tc006() {
        // No login performed — intentional, this is the whole point of the test
        log.info("Starting test with no active session");
    }

    @When("the user directly navigates to the dashboard URL for TC006")
    public void the_user_directly_navigates_to_the_dashboard_url_for_tc006() {
        unauthAccess.navigateDirectlyToDashboard();
    }

    @Then("the user should be redirected to the login page for TC006")
    public void the_user_should_be_redirected_to_the_login_page_for_tc006() {
        Assert.assertTrue(unauthAccess.isRedirectedToLoginPage(),
                "User was NOT redirected to login page — unauthorized access may be possible! Current URL: "
                        + unauthAccess.getCurrentUrl());
    }
}