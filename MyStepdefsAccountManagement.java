package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountManagementPage;

public class MyStepdefsAccountManagement
{

    @When("i open Client tab")
    public void iOpenClientTab() throws InterruptedException
    {
        AccountManagementPage.Client_Tab();

    }

    @And("I select new Client")
    public void iSelectNewClient() throws InterruptedException
    {

AccountManagementPage.NewClient();
    }



    @And("I check Record Type  as {string}")
    public void iCheckRecordTypeAs(String arg0) throws InterruptedException
    {
        AccountManagementPage.CheckRecordType(arg0);
    }
    @And("I enter CIF number and System Information")
    public void iEnterCIFNumberAndSystemInformation()
    {
        AccountManagementPage.SystemInformation();

    }
    @And("I validate and verify the KYC status {string}")
    public void iValidateTheKYCStatusAndSelectAnd(String arg0) throws InterruptedException {

AccountManagementPage.KYC_Validation(arg0);
    }


    @Then("Verify Updated Consent")
    public void verifyUpdatedConsent() throws InterruptedException
    {

AccountManagementPage.Consent();


    }


}
