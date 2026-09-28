package StepDefinitions;

import framework.pages.TC_005_PAGE;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class TC_005 {
    TC_005_PAGE toggle = new TC_005_PAGE();


    @Given("the user opens the admin login page for TC005")
    public void the_user_opens_the_admin_login_page_for_tc005() {
        toggle.openweb();
    }

    @When("the user enters a password for TC005")
    public void the_user_enters_a_password_for_tc005() {
        toggle.enterPassword();
    }

    @When("the user clicks the show password icon for TC005")
    public void the_user_clicks_the_show_password_icon_for_tc005() {
        toggle.clickEyeIcon();
    }

    @Then("the password should be visible as plain text for TC005")
    public void the_password_should_be_visible_as_plain_text_for_tc005() {
        Assert.assertEquals(toggle.getPasswordFieldType(), "text", "Password field did not switch to plain text");
    }

    @When("the user clicks the show password icon again for TC005")
    public void the_user_clicks_the_show_password_icon_again_for_tc005() {
        toggle.clickEyeIcon();
    }

    @Then("the password should be masked again for TC005")
    public void the_password_should_be_masked_again_for_tc005() {
        Assert.assertEquals(toggle.getPasswordFieldType(), "password", "Password field did not switch back to masked");
    }
}