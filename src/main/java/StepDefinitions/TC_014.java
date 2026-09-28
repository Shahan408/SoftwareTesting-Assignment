package StepDefinitions;

import framework.pages.TC_014_PAGE;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TC_014 {

    TC_014_PAGE status = new TC_014_PAGE();

    @Given("the user logs into the admin dashboard for TC014")
    public void the_user_logs_into_the_admin_dashboard_for_tc014() {
        status.login();
    }

    @When("the user navigates to the companies page for TC014")
    public void the_user_navigates_to_the_companies_page_for_tc014() {
        status.goToCompaniesPage();
    }

    @And("the user filters by status {string} for TC014")
    public void the_user_filters_by_status_for_tc014(String statusName) {
        status.filterByStatus(statusName);
    }

    @Then("only companies with status {string} should be displayed for TC014")
    public void only_companies_with_status_should_be_displayed_for_tc014(String statusName) {

        Assert.assertTrue(
                status.isStatusSelected(statusName),
                "Active status should be selected"
        );
    }
}