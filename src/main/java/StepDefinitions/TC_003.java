package StepDefinitions;

import framework.pages.TC_003_PAGE;
import io.cucumber.java.en.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class TC_003 {
    TC_003_PAGE emptyFields = new TC_003_PAGE();
    private static final Logger log = LoggerFactory.getLogger(TC_003.class);

    @Given("the user opens the admin login page for TC003")
    public void the_user_opens_the_admin_login_page_for_tc003() {
        emptyFields.openweb();
    }

    @When("the user leaves email and password empty for TC003")
    public void the_user_leaves_email_and_password_empty_for_tc003() {
        emptyFields.leaveFieldsEmpty();
    }

    @When("the user submits the login form for TC003")
    public void the_user_submits_the_login_form_for_tc003() {
        emptyFields.clickSubmit();
    }

    @Then("validation errors should be displayed for TC003")
    public void validation_errors_should_be_displayed_for_tc003() {
        Assert.assertTrue(emptyFields.areValidationErrorsDisplayed(), "Expected validation errors were not displayed");
    }
}