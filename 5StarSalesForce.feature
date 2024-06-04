@5StarSalesForce @regression_

Feature: 001_SalesForce_5_Star_Management_Program


  Scenario Outline: 001_SalesForce_5_Star_Program_Account_Executive
    Given I have Logged into Salesforce with username "napeboshielo@capitecbank.co.za.preprod" and password "Loyiso@123456"
    When I open Bankers tab
    And I select recently viewed option to select all bankers
   And I Search for an existing banker "<BankerName>"
    And I click the existing name
    And I Change BankerRole "<BankerRole>"
    And I Click save button

    Examples:
      | BankerRole        | BankerName | BankerRole | Email | Phone | Scenario |
      | Account Executive | Nape       |            |       |       | Positive |


  Scenario Outline: 001_SalesForce_Create_New_Client
    Given I have Logged into Salesforce with username "napeboshielo@capitecbank.co.za.preprod" and password "Loyiso@123456"
    When I click open Clients Tab
    And I click new Clients
    And I enter client details
    And Click Apps and search Financial accounts as "<FinancialAccount>"
    And I click new Account
    And I enter Financial Account Details as "<AccountName>"
    And I select the Primary owner and verify the five day task

    Examples:
      | FinancialAccount   | AccountName | Task period |
      | Financial Accounts | TestAccount |             |

  Scenario Outline: 001_SalesForce_5_Star_Program_Relationship_Banker
    Given I have Logged into Salesforce with username "napeboshielo@capitecbank.co.za.preprod" and password "Loyiso@123456"
    When I open Bankers tab
    And I select recently viewed option to select all bankers
    And I Search for an existing banker "<BankerName>"
    And I click the existing name
    And I Change BankerRole "<BankerRole>"
    And I Click save button



    Examples:
      | BankerRole          | BankerName | BankerRole | Email | Phone | Scenario |
      | Relationship Banker | Nape       |            |       |       | Positive |


  Scenario Outline: 001_SalesForce_Create_New_Client
    Given I have Logged into Salesforce with username "napeboshielo@capitecbank.co.za.preprod" and password "Loyiso@123456"
    When I click open Clients Tab
    And I click new Clients
    And I enter client details
    And Click Apps and search Financial accounts as "<FinancialAccount>"
    And I click new Account
    And I enter Financial Account Details as "<AccountName>"
    And I select the Primary owner and verify the five Week and month task

    Examples:
      | FinancialAccount   | AccountName | Task period |
      | Financial Accounts | TestAccount |             |