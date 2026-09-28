package StepDefinitions;

import framework.driver.DriverManager;
import framework.pages.TC_001_PAGE;
import io.cucumber.java.en.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class TC_001 {
    TC_001_PAGE validcred = new TC_001_PAGE();
    private static final Logger log = LoggerFactory.getLogger(TC_001.class);

    @Given("the user is on the admin login page")
    public void the_user_is_on_the_admin_login_page() {

        validcred.openweb();
    }

    @When("the user enters a valid email address")
    public void the_user_enters_a_valid_email_address() {

    validcred.enterEmail();
    }

    @When("the user enters the correct password")
    public void the_user_enters_the_correct_password() {
    validcred.enterPassword();

    }

    @When("the user clicks the Sign in button")
        public void the_user_clicks_the_sign_in_button(){
        validcred.clickSubmit();
    }

    @Then("the user should be redirected to the admin dashboard")
    public void the_user_should_be_redirected_to_the_admin_dashboard() {
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("dashboard"), "User was not redirected to dashboard");
    }
}
