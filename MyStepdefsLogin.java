package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginSalesForcePage;

public class MyStepdefsLogin {

    @Given("I am on the SalesForce login page")
    public void iAmOnTheSalesForceLoginPage() {

    }

    @When("I enter the channel username as {string}")
    public void iEnterTheChannelUsernameAs(String arg0) throws InterruptedException {
        LoginSalesForcePage.enterUsername(arg0);
    }

    @And("I enter the channel password as {string}")
    public void iEnterTheChannelPasswordAs(String arg0) throws InterruptedException {
        LoginSalesForcePage.enterpassword(arg0);
    }

    @And("I click the login  button")
    public void iClickTheLoginButton() throws InterruptedException {
        LoginSalesForcePage.ClickLog_In();
    }

    @And("i checkbox remember me")
    public void iCheckboxRememberMe() throws InterruptedException {
        LoginSalesForcePage.ClickrememberMeCheckbox();
    }

    @Then("verify successful login")
    public void verifySuccessfulLogin() throws InterruptedException {
        LoginSalesForcePage.ClickSaleforceHomePage();
    }


}
