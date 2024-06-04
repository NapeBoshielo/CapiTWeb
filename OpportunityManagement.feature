@OpportunityManagementSalesForce @regression

Feature: 001_SalesForce_Opportunity_Management

  Scenario: 001_SalesForce_Opportunity
    Given I have Logged into Salesforce with username "napeboshielo@capitecbank.co.za.preprod" and password "CRM@123456"
    When I open Opportunity tab
    And I select new Opportunity
    And I fill in opportunity details
    And I click Related tab
    And I Add a product
    Then verify Added product


 # And I select new Lead
  #And I Mark Status as Contacted
 # And I click convert Lead
   # And I click Go to Leads
  #Then verify that a new Lead is created and converted

