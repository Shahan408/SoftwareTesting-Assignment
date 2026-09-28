package StepDefinitions;

import framework.pages.TC_008_PAGE;
import io.cucumber.java.en.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class TC_008 {
    TC_008_PAGE logout = new TC_008_PAGE();
    private static final Logger log = LoggerFactory.getLogger(TC_008.class);

    @Given("the user logs into the admin dashboard for TC008")
    public void the_user_logs_into_the_admin_dashboard_for_tc008() {
        logout.login();
    }

    @When("the user clicks the Log out button for TC008")
    public void the_user_clicks_the_log_out_button_for_tc008() {
        logout.clickLogout();
    }

    @Then("the user should be redirected to the login page for TC008")
    public void the_user_should_be_redirected_to_the_login_page_for_tc008() {
        Assert.assertTrue(logout.isOnLoginPage(), "User was not redirected to login page after logout");
    }

    @And("the user should not be able to access the dashboard via back navigation for TC008")
    public void the_user_should_not_be_able_to_access_the_dashboard_via_back_navigation_for_tc008() {
        logout.navigateBack();
        Assert.assertTrue(logout.isStillOnLoginPage(), "Dashboard was accessible via back button after logout — session not properly terminated!");
    }
}