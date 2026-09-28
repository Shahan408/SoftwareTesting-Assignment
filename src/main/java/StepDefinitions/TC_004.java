package StepDefinitions;

import framework.pages.TC_004_PAGE;
import io.cucumber.java.en.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class TC_004 {
    TC_004_PAGE invalidEmail = new TC_004_PAGE();
    private static final Logger log = LoggerFactory.getLogger(TC_004.class);

    @Given("the user opens the admin login page for TC004")
    public void the_user_opens_the_admin_login_page_for_tc004() {
        invalidEmail.openweb();
    }

    @When("the user enters a malformed email for TC004")
    public void the_user_enters_a_malformed_email_for_tc004() {
        invalidEmail.enterMalformedEmail();
    }

    @When("the user enters a password for TC004")
    public void the_user_enters_a_password_for_tc004() {
        invalidEmail.enterPassword();
    }

    @When("the user submits the login form for TC004")
    public void the_user_submits_the_login_form_for_tc004() {
        invalidEmail.clickSubmit();
    }

    @Then("an email format validation error should be displayed for TC004")
    public void an_email_format_validation_error_should_be_displayed_for_tc004() {
        Assert.assertTrue(invalidEmail.isEmailValidationErrorDisplayed(), "Expected email format validation error was not displayed");
    }
}