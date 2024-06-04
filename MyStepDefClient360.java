package stepdefs;

import io.cucumber.java.en.Then;
import pages.Client360;

public class MyStepDefClient360
{

    @Then("Verify Milestones as {string}")
    public void verifyMilestonesAs(String arg0) throws InterruptedException {

        Client360.Client(arg0);

    }


    @Then("Verify The Next Best Action")
    public void verifyTheNextBestAction() throws InterruptedException
    {

Client360.NextBestAction();
    }
}
