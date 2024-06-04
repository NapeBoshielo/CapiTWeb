

@AutomatedEmailToCase @regression

Feature: 001_SalesForce_AutomatedEmailToCaseCreation
  Scenario : 001_SalesForce_New_Lead_Creation_and_Conversion
    Given I have Logged into Salesforce with my username "napeboshielo@capitecbank.co.za.int" and password "Gomora@1234"
    When I click open Clients Tab
    And I select a new client
    And create a related contact
    And I click select the email icon
    And I enter the email addresses
    And I enter Email Template
    And I send  the email
    Then verify Added product