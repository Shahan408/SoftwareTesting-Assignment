package StepDefinitions;

import framework.pages.TC_011_PAGE;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class TC_011 {
    TC_011_PAGE search = new TC_011_PAGE();

    @Given("the user logs into the admin dashboard for TC011")
    public void the_user_logs_into_the_admin_dashboard_for_tc011() {
        search.login();
    }

    @When("the user navigates to the companies page for TC011")
    public void the_user_navigates_to_the_companies_page_for_tc011() {
        search.goToCompaniesPage();
    }

    @And("the user searches for {string} for TC011")
    public void the_user_searches_for_for_tc011(String keyword) {
        search.searchFor(keyword);
    }

    @Then("the company {string} should be displayed in the results for TC011")
    public void the_company_should_be_displayed_in_the_results_for_tc011(String companyName) {
        Assert.assertTrue(search.isCompanyDisplayed(companyName), "Expected company was not displayed in search results");
    }
}