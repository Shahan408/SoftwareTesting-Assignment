package StepDefinitions;

import framework.pages.TC_010_PAGE;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class TC_010 {
    TC_010_PAGE emptyForm = new TC_010_PAGE();

    @Given("the user logs into the admin dashboard for TC010")
    public void the_user_logs_into_the_admin_dashboard_for_tc010() {
        emptyForm.login();
    }

    @When("the user navigates to the register company page for TC010")
    public void the_user_navigates_to_the_register_company_page_for_tc010() {
        emptyForm.goToRegisterCompanyPage();
    }

    @When("the user submits the registration form without filling any fields for TC010")
    public void the_user_submits_the_registration_form_without_filling_any_fields_for_tc010() {
        emptyForm.submitEmptyForm();
    }

    @Then("validation errors should be displayed for TC010")
    public void validation_errors_should_be_displayed_for_tc010() {
        Assert.assertTrue(emptyForm.areValidationErrorsDisplayed(), "Expected validation errors were not displayed");
    }

    @And("no company should be created for TC010")
    public void no_company_should_be_created_for_tc010() {
        Assert.assertTrue(emptyForm.isStillOnRegisterPage(), "User was navigated away — company may have been created despite empty fields");
    }
}