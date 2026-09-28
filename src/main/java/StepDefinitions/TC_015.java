package StepDefinitions;

import framework.pages.TC_015_PAGE;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TC_015 {

    TC_015_PAGE industry = new TC_015_PAGE();

    @Given("the user logs into the admin dashboard for TC015")
    public void the_user_logs_into_the_admin_dashboard_for_tc015() {

        industry.login();
    }

    @When("the user navigates to the companies page for TC015")
    public void the_user_navigates_to_the_companies_page_for_tc015() {

        industry.goToCompaniesPage();
    }

    @And("the user filters by industry {string} for TC015")
    public void the_user_filters_by_industry_for_tc015(String industryName) {

        industry.filterByIndustry(industryName);
    }

    @Then("only companies with industry {string} should be displayed for TC015")
    public void only_companies_with_industry_should_be_displayed_for_tc015(String industryName) {

        Assert.assertTrue(
                industry.isIndustrySelected(industryName),
                "Industry should be selected"
        );
    }
}