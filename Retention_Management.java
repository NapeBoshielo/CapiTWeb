package stepdefs;


import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.LeadManagementPage;
import pages.RetentionManagementPage;

public class Retention_Management {

    @When("I open Bankers tab")
    public void iOpenBankersTab() throws InterruptedException {

        RetentionManagementPage.Bankers_Tab();

    }
    @And("I select recently viewed option to select all bankers")
    public void iSelectRecentlyViewedOptionToSelectAllBankers() throws InterruptedException {
RetentionManagementPage.RecentlyViewed();

    }

    @And("I Search for an existing banker {string}")
    public void iSearchForAnExistingBanker(String arg0) throws InterruptedException {
        RetentionManagementPage.ExistingBanker(arg0);

    }

    @And("I click the existing name")
    public void iClickTheExistingName() throws InterruptedException {

        RetentionManagementPage.ClickName();
    }


    @And("I Change BankerRole {string}")
    public void iChangeBankerRole(String arg0) throws InterruptedException {
RetentionManagementPage.BankerRole(arg0);

    }

    @And("I Click save button")
    public void iClickSaveButton() throws InterruptedException {
        LeadManagementPage.iClickSave();
    }

    @When("I click open Clients Tab")
    public void iClickOpenClientsTab() throws InterruptedException {
RetentionManagementPage.Clients_Tab();

    }

    @And("I click new Clients")
    public void iClickNewClients() throws InterruptedException {
        RetentionManagementPage.New_client();

    }


    @And("I enter client details")
    public void iEnterClientDetails() throws InterruptedException {

RetentionManagementPage.Clients_details();
    }



    @And("Click Apps and search Financial accounts as {string}")
    public void clickAppsAndSearchFinancialAccountsAs(String arg0) throws InterruptedException {
RetentionManagementPage.SelectApp(arg0);

    }


    @And("I click new Account")
    public void iClickNewAccount() throws InterruptedException {


        RetentionManagementPage.New_Account();
    }

    @And("I enter Financial Account Details as {string}")
    public void iEnterFinancialAccountDetailsAs(String arg0) throws InterruptedException {

RetentionManagementPage.AccountDetails(arg0);

    }





    @And("I select the Primary owner and verify the five day task")
    public void iSelectThePrimaryOwnerAndVerifyTheFiveDayTask() throws InterruptedException {
RetentionManagementPage.primaryOwner();
    }

    @And("I select the Primary owner and verify the five Week and month task")
    public void iSelectThePrimaryOwnerAndVerifyTheFiveWeekAndMonthTask() throws InterruptedException {

        RetentionManagementPage.FiveWeek();

    }
}
