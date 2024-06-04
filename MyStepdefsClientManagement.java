package stepdefs;

import co.za.capitecbank.testing.config.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.ClientManagementPage;
import pages.LoginSalesForcePage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyStepdefsClientManagement {

    @Given("I have Logged into Salesforce with username {string} and password {string}")
    public void iHaveLoggedIntoSalesforceWithUsernameAndPassword(String arg0, String arg1) throws InterruptedException, IOException {
        LoginSalesForcePage.IhaveLoggedin(arg0, arg1);
    }

    @When("i open cases Tab")
    public void iOpenCasesTab() throws InterruptedException {

        ClientManagementPage.Case_Tab();
    }

    @And("i click New Button")
    public void iClickNewButton() throws InterruptedException {

        ClientManagementPage.New_case();

    }


    @And("i click client Name")
    public void iClickClientName() throws InterruptedException {
        ClientManagementPage.Client_Name();

    }

//    @And("i check Record Type  as {string} and i enter last name {string} registration number and SA ID and {string} and {string}")
//    public void iCheckRecordTypeAsWithLastNameRegistrationNumberAndSAIDAnd(String arg0) throws InterruptedException {
//        ClientManagementPage.CheckRecordType(arg0);
//    }


    @And("i check Record Type  as {string}")
    public void iCheckRecordTypeAs(String arg0) throws InterruptedException {
        ClientManagementPage.CheckRecordType(arg0);
    }


    @And("i enter SA ID")
    public void iEnterSAIDAs() throws InterruptedException {
        ClientManagementPage.EnterID();
    }

    @And("i click new contact Name")
    public void iClickNewContactName() throws InterruptedException {
        ClientManagementPage.Contact_Name_();

    }


    @And("i enter Contact details with {string} and {string} and {string} and {string}")
    public void iEnterContactDetailsWithAndAndAndAnd() throws InterruptedException {
        ClientManagementPage.ContactDetails();
    }


    @And("i click Save button")
    public void iClickSaveButton() throws InterruptedException {
        ClientManagementPage.iClickSave();
    }


    @Then("Verify successful case creation")
    public void verifySuccessfulClientCreation() {
        ClientManagementPage.verifySuccessfulClientCreation();

    }


    @And("i select case type as {string}")
    public void iSelectCaseTypeAs(String arg0) throws InterruptedException {
        ClientManagementPage.iSelectCaseTypeAs(arg0);

    }


    @Then("Verify Milestones")
    public void verifyMilestones()

    {

        ClientManagementPage.verifyMilestones();
    }

    @And("i click existing case number")
    public void iClickExistingCaseNumber() throws InterruptedException {
        ClientManagementPage.iClickExistingCaseNumber();


    }

    @And("i edit case Status as {string}and Case type as {string}")
    public void iEditCaseStatusAsAndCaseTypeAs(String arg0, String arg1) throws InterruptedException {
        ClientManagementPage.iEditCaseStatusAsAndCaseTypeAs(arg0, arg1);
    }

    @And("i edit Case priority {string} and Case origin {string}")
    public void iEditCasePriorityAndCaseOrigin(String arg0, String arg1) throws InterruptedException {

        ClientManagementPage.iEditCasePriorityAndCaseOrigin(arg0, arg1);

    }

    @And("i edit Case category as {string} and Case sub as {string} and Case issue as {string}")
    public void iEditCaseCategoryAsAndCaseSubAsAndCaseIssueAs(String arg0, String arg1, String arg2) throws InterruptedException {

        ClientManagementPage.iEditCaseCategoryAsAndCaseSubAsAndCaseIssueAs(arg0, arg1, arg2);

    }


    @And("i enter Case Subject as {string}")
    public void iEnterCaseSubjectAsAndDescriptionAs(String arg0) throws InterruptedException {
        ClientManagementPage.iEnterCaseSubjectAsAndDescriptionAs(arg0);

    }

    @And("i click Save")
    public void iClickSave() throws InterruptedException {
        ClientManagementPage.iClickSave();
    }

    @Then("Verify Case History")
    public void verifyCaseHistory() throws InterruptedException {
        ClientManagementPage.verifyCaseHistory();
    }


//    @And("And i enter Contact details with {string} and {string} and {string} and {string}")
//    public void andIEnterContactDetailsWithAndAndAnd(String arg0, String arg1, String arg2, String arg3) throws InterruptedException {
//        ClientManagementPage.ContactDetails(arg0, arg1, arg2, arg3);
//    }

    @And("i enter Contact details")
    public void iEnterContactDetails() throws InterruptedException {
        ClientManagementPage.ContactDetails();
    }


    @And("i select existing cases")
    public void iSelectExistingCases() throws InterruptedException {
        ClientManagementPage.existingCase();


    }

//    @And("select change Owner")
//    public void selectChangeOwner() throws InterruptedException
//    {
//        ClientManagementPage.ChangeOwner();
//
//    }

    @And("select change Owner and Migrate from Case to Lead")
    public void selectChangeOwnerAndMigrateFromCaseToLead() throws InterruptedException {
        ClientManagementPage.ChangeOwner();
    }

    @And("i enter Contact details and search for and existing name as {string}")
    public void iEnterContactDetailsAndSearchForAndExistingNameAs(String arg0) {


    }

    @And("I Click Search and enter application name as {string}")
    public void iClickSearchAndEnterApplicationNameAs(String arg0)
    {

    }

    @And("I Click Search and enter application name")
    public void iClickSearchAndEnterApplicationName()
    {

    }

    @And("i click existing client Name")
    public void iClickExistingClientName() throws InterruptedException {
ClientManagementPage.ExistingClient_Name();
    }

    @And("i click Existing contact Name")
    public void iClickExistingContactName() throws InterruptedException {
        ClientManagementPage.ExistingContact_Name();
    }
}

