package StepDefinitions;

import framework.pages.TC_009_PAGE;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class TC_009 {
    TC_009_PAGE register = new TC_009_PAGE();

    @Given("the user logs into the admin dashboard for TC009")
    public void the_user_logs_into_the_admin_dashboard_for_tc009() {
        register.login();
    }

    @When("the user navigates to the register company page for TC009")
    public void the_user_navigates_to_the_register_company_page_for_tc009() {
        register.goToRegisterCompanyPage();
    }

    @When("the user fills in valid company information for TC009")
    public void the_user_fills_in_valid_company_information_for_tc009() {
        register.fillCompanyInformation();
    }

    @When("the user fills in valid initial owner details for TC009")
    public void the_user_fills_in_valid_initial_owner_details_for_tc009() {
        register.fillInitialOwnerDetails();
    }

    @When("the user submits the registration form for TC009")
    public void the_user_submits_the_registration_form_for_tc009() {
        register.submitForm();
    }

    @Then("the new company should be created successfully for TC009")
    public void the_new_company_should_be_created_successfully_for_tc009() {
        Assert.assertTrue(register.isCompanyCreatedSuccessfully(), "New company was not found after registration submission");
    }
}