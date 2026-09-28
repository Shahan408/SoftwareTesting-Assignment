package StepDefinitions;

import framework.pages.TC_007_PAGE;
import io.cucumber.java.en.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class TC_007 {
    TC_007_PAGE nav = new TC_007_PAGE();
    private static final Logger log = LoggerFactory.getLogger(TC_007.class);

    @Given("the user logs into the admin dashboard for TC007")
    public void the_user_logs_into_the_admin_dashboard_for_tc007() {
        nav.login();
    }

    @When("the user clicks the Companies link for TC007")
    public void the_user_clicks_the_companies_link_for_tc007() {
        nav.clickCompanies();
    }

    @Then("the user should land on the Companies page for TC007")
    public void the_user_should_land_on_the_companies_page_for_tc007() {
        Assert.assertTrue(nav.urlContains("companies"), "Did not land on Companies page. URL: " + nav.getCurrentUrl());
    }

    @When("the user clicks the Platform Admins link for TC007")
    public void the_user_clicks_the_platform_admins_link_for_tc007() {
        nav.clickPlatformAdmins();
    }

    @Then("the user should land on the Platform Admins page for TC007")
    public void the_user_should_land_on_the_platform_admins_page_for_tc007() {
        Assert.assertTrue(nav.urlContains("admin"), "Did not land on Platform Admins page. URL: " + nav.getCurrentUrl());
    }

    @When("the user clicks the Audit link for TC007")
    public void the_user_clicks_the_audit_link_for_tc007() {
        nav.clickAudit();
    }

    @Then("the user should land on the Audit page for TC007")
    public void the_user_should_land_on_the_audit_page_for_tc007() {
        Assert.assertTrue(nav.urlContains("audit"), "Did not land on Audit page. URL: " + nav.getCurrentUrl());
    }

    @When("the user clicks the Settings link for TC007")
    public void the_user_clicks_the_settings_link_for_tc007() {
        nav.clickSettings();
    }

    @Then("the user should land on the Settings page for TC007")
    public void the_user_should_land_on_the_settings_page_for_tc007() {
        Assert.assertTrue(nav.urlContains("settings"), "Did not land on Settings page. URL: " + nav.getCurrentUrl());
    }

    @When("the user clicks the Overview link for TC007")
    public void the_user_clicks_the_overview_link_for_tc007() {
        nav.clickOverview();
    }

    @Then("the user should land on the Overview page for TC007")
    public void the_user_should_land_on_the_overview_page_for_tc007() {
        Assert.assertTrue(nav.urlContains("app"), "Did not land on Overview page. URL: " + nav.getCurrentUrl());
    }
}