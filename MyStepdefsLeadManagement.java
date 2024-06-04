package stepdefs;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LeadManagementPage;
import pages.LoginSalesForcePage;

import java.io.IOException;

public class MyStepdefsLeadManagement {


    @Given("I have Logged into Salesforce with my username {string} and password {string}")
    public void iHaveLoggedIntoSalesforceWithMyUsernameAndPassword(String arg0, String arg1) throws InterruptedException, IOException {

        LoginSalesForcePage.IhaveLoggedin(arg0, arg1);
    }


    @When("I open Leads tab")
    public void iOpenLeadsTab() throws InterruptedException {
        LeadManagementPage.Leads_Tab();
    }

    @And("I click new Lead button")
    public void iClickNewButton() throws InterruptedException {
        LeadManagementPage.New_client();
    }


    @And("I Select Business Type as {string} with  {string} and {string}")
    public void iSelectBusinessTypeAsWithAnd(String arg0, String arg1, String arg2) throws InterruptedException {

        LeadManagementPage.iSelectBusinessTypeAsBusiness(arg0, arg1, arg2);

    }

    @And("I select new added Lead")
    public void iSelectNewaddedLead() throws InterruptedException {

        LeadManagementPage.NewLead();

    }
    @And("I Mark Status as Contacted")
    public void iMarkStatusAsContacted() throws InterruptedException {
        LeadManagementPage.MarkStatus();

    }

    @And("I click convert Lead")
    public void iClickConvertLead() throws InterruptedException {
        LeadManagementPage.ConvertLead();
    }


    @And("I click Go to Leads")
    public void iClickGoToLeads() throws InterruptedException {
        LeadManagementPage.iClickGoToLeads();
    }


    @Then("verify that a new Lead is created and converted {string} and {string}")
    public void verifyThatANewLeadIsCreatedAndConvertedAnd(String arg0, String arg1) throws InterruptedException {
        LeadManagementPage.verifyThatANewLeadIsCreated(arg0,arg1);
    }


    @Given("Given I have Logged into Salesforce with my username {string} and password {string}")
    public void givenIHaveLoggedIntoSalesforceWithMyUsernameAndPassword(String arg0, String arg1) throws IOException, InterruptedException {

        LoginSalesForcePage.IhaveLoggedin(arg0, arg1);

    }


    @When("I click open Leads Tab")
    public void iClickOpenLeadsTab() throws InterruptedException {

        LeadManagementPage.Leads_Tab();
    }
    @And("I click existing Lead")
    public void iClickExistingLead() throws InterruptedException {

        LeadManagementPage.NewLead();
    }
    @And("I click clone button")
    public void iClickCloneButton() throws InterruptedException {

LeadManagementPage.CloneLead();
    }


    @And("I click save button")
    public void iClickSaveButton() throws InterruptedException {
        LeadManagementPage.iClickSave();

    }
    @Then("I verify a successful clone")
    public void iVerifyASuccessfulClone() throws InterruptedException {

        LeadManagementPage.VerifyClone();


    }
    @And("I click Convert")
    public void iClickConvert() {
    }

    @Then("Verify conversion of the Lead")
    public void verifyConversionOfTheLead() {
    }

    @And("I click Edit button")
    public void iClickEditButton() {
    }

//    @And("I select Business Type as <Business_Type>")
//    public void iSelectBusinessTypeAsBusiness_Type() {
//    }

    @And("I Select Lead Status as <Lead_Status>")
    public void iSelectLeadStatusAsLead_Status() {
    }

    @And("I select a Lead Source as <Lead_Source>")
    public void iSelectALeadSourceAsLead_Source() {
    }

    @And("I select Product Interest as <Product_interest>")
    public void iSelectProductInterestAsProduct_interest() {
    }

    @Then("Verify lead editing")
    public void verifyLeadEditing() {
    }

    @Given("I have Login to Salesforce")
    public void iHaveLoginToSalesforce() {
    }

    @And("I click open Leadlink")
    public void iClickOpenLeadlink() {
    }



    @And("I select the close reason<Clone_Reason>")
    public void iSelectTheCloseReasonClone_Reason() {
    }





    @When("I click open cases Tab")
    public void iClickOpenCasesTab() {
    }

    @And("I click open Lead link")
    public void iClickOpenLeadLink() {
    }

    @And("I click Follow")
    public void iClickFollow() {
    }

    @Then("I verify a successful following")
    public void iVerifyASuccessfulFollowing() {
    }

    @And("I click Send Account closure Survey button")
    public void iClickSendAccountClosureSurveyButton() {
    }

    @Then("Verify successful sending of the survey")
    public void verifySuccessfulSendingOfTheSurvey() {
    }

    @And("I click open")
    public void iClickOpen() {
    }

    @And("I click Change Owner")
    public void iClickChangeOwner() {
    }

    @And("I search Users")
    public void iSearchUsers() {
    }

    @And("I click notification email checkbox")
    public void iClickNotificationEmailCheckbox() {
    }

    @And("I click Submit")
    public void iClickSubmit() {
    }

    @Then("Verify the added Lead Owner")
    public void verifyTheAddedLeadOwner() {

    }


    @Given("I have logged into SalesForce")
    public void iHaveLoggedIntoSalesForce() {

    }


    @And("I select Business Type as <Business_Type>")
    public void iSelectBusinessTypeAsBusiness_Type() {
    }


    @And("I enter Email as <Email>")
    public void iEnterEmailAsEmail() {
    }

    @And("I enter Phone as <Phone>")
    public void iEnterPhoneAsPhone() {
        

    }



}
