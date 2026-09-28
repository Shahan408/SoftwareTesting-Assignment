package StepDefinitions;

import framework.pages.TC_013_PAGE;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class TC_013 {


    TC_013_PAGE search = new TC_013_PAGE();

    @Given("the user logs into the admin dashboard for TC013")
    public void the_user_logs_into_the_admin_dashboard_for_tc013() {
        search.login();
    }

    @When("the user navigates to the companies page for TC013")
    public void the_user_navigates_to_the_companies_page_for_tc013() {
        search.goToCompaniesPage();
    }

    @And("the user searches for slug {string} for TC013")
    public void the_user_searches_for_slug_for_tc013(String slug) {
        search.searchFor(slug);
    }

    @Then("the company {string} should be displayed in the results for TC013")
    public void the_company_should_be_displayed_in_the_results_for_tc013(String companyName) {

        Assert.assertTrue(
                search.isCompanyDisplayed(companyName),
                "Company should be displayed in search results"
        );
    }
}
