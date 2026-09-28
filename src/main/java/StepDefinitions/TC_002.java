package StepDefinitions;

import framework.pages.TC_002_PAGE;
import io.cucumber.java.en.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class TC_002 {
    TC_002_PAGE invalidPass = new TC_002_PAGE();
    private static final Logger log = LoggerFactory.getLogger(TC_002.class);

    @Given("the user opens the admin login page for TC002")
    public void the_user_opens_the_admin_login_page_for_tc002() {
        invalidPass.openweb();
    }

    @When("the user provides a valid email for TC002")
    public void the_user_provides_a_valid_email_for_tc002() {
        invalidPass.enterEmail();
    }

    @When("the user provides an incorrect password for TC002")
    public void the_user_provides_an_incorrect_password_for_tc002() {
        invalidPass.enterWrongPassword();
    }

    @When("the user submits the login form for TC002")
    public void the_user_submits_the_login_form_for_tc002() {
        invalidPass.clickSubmit();
    }

    @Then("an error message should be displayed for TC002")
    public void an_error_message_should_be_displayed_for_tc002() {
        Assert.assertTrue(invalidPass.isErrorMessageDisplayed(), "Expected error message was not displayed");
    }
}