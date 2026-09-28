package StepDefinitions;

import framework.pages.TC_012_PAGE;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class TC_012 {

    TC_012_PAGE search = new TC_012_PAGE();

    @Given("the user logs into the admin dashboard for TC012")
    public void the_user_logs_into_the_admin_dashboard_for_tc012() {
        search.login();
    }

    @When("the user navigates to the companies page for TC012")
    public void the_user_navigates_to_the_companies_page_for_tc012() {
        search.goToCompaniesPage();
    }

    @And("the user searches for {string} for TC012")
    public void the_user_searches_for_for_tc012(String keyword) {
        search.searchFor(keyword);
    }

    @Then("the company {string} should not be displayed in the results for TC012")
    public void the_company_should_not_be_displayed_in_the_results_for_tc012(String companyName) {

        Assert.assertTrue(
                search.isCompanyNotDisplayed(companyName),
                "Company should not be displayed in search results"
        );

    }
}