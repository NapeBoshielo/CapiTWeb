package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OpportunityManagementPage;

public class MyStepdefsOpportunityManagement {

    @When("I open Opportunity tab")
    public void iOpenOpportunityTab() throws InterruptedException
    {
        OpportunityManagementPage.Opportunity_Tab();

    }

    @And("I select new Opportunity")
    public void iSelectNewOpportunity() throws InterruptedException
    {
        OpportunityManagementPage.NewOpportunity();
    }

    @And("I fill in opportunity details")
    public void iFillInOpportunityDetails() throws InterruptedException {

        OpportunityManagementPage.OpDetails();
    }
    @And("I click Related tab")
    public void iClickRelatedTab() throws InterruptedException
    {
        OpportunityManagementPage.iClickRelated();
    }

    @And("I Add a product")
    public void iAddAProduct() throws InterruptedException
    {

        OpportunityManagementPage.AddAProduct();
    }


    @Then("verify Added product")
    public void verifyAddedProduct() throws InterruptedException
    {
        OpportunityManagementPage.verifyAddedProduct();
    }



}
