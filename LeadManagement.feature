@LeadManagementSalesForce @regressionTests

Feature: 001_SalesForce_Lead_Management


  Scenario Outline: 001_SalesForce_New_Lead_Creation_and_Conversion_SoleProp
    Given I have Logged into Salesforce with username "napeboshielo@capitecbank.co.za.preprod" and password "CRM@123456"
    When I open Leads tab
    And I click new Lead button
    And I Select Business Type as "<Business_Type>" with  "<Lead_Source>" and "<Product_interest>"
    And I select new added Lead
    And I Mark Status as Contacted
    And I click convert Lead
    And I click Go to Leads
    Then verify that a new Lead is created and converted "<Business_Type>" and "<Product_interest>"

    Examples:
      | Business_Type   | Last_name | firstName | Email | Phone | Lead_Source         | Product_interest         | Scenario |
      | Sole Proprietor |           |           |       |       | Assisted Onboarding | Business Current Account | Positive |


  Scenario Outline: 001_SalesForce_New_Lead_Creation_and_Conversion_Registered_Business
    Given I have Logged into Salesforce with username "napeboshielo@capitecbank.co.za.preprod" and password "CRM@123456"
    When I open Leads tab
    And I click new Lead button
    And I Select Business Type as "<Business_Type>" with  "<Lead_Source>" and "<Product_interest>"
    And I select new added Lead
    And I Mark Status as Contacted
    And I click convert Lead
    And I click Go to Leads
    Then verify that a new Lead is created and converted "<Business_Type>" and "<Product_interest>"

    Examples:
      | Business_Type                        | Last_name | firstName | Email | Phone | Lead_Source       | Product_interest         | Scenario |
      | Simple Structure/Registered Business |           |           |       |       | Remote Onboarding | Business Current Account | Positive |


  Scenario: 001_SalesForce_Clone_Lead
    Given I have Logged into Salesforce with username "napeboshielo@capitecbank.co.za.preprod" and password "CRM@123456"
    When I click open Leads Tab
    And I click existing Lead
    And I click clone button
    And I click save button
    Then I verify a successful clone


 # Scenario: 001_SalesForce_Convert_Lead
  # Given I have logged into SalesForce
  #  When I open Leads tab
  #  And I click open LeadsLink
   # And I click Convert
   # Then Verify conversion of the Lead


#add Qs
  #Scenario Outline: 001_SalesForce_Edit_Lead
   # Given I have logged into SalesForce
  #  When I open Leads tab
   # And I click open LeadsLink
    #And I click Edit button
    #And I select Business Type as <Business_Type>
    #And I Select Lead Status as <Lead_Status>
    #And I enter Email as <Email>
    #And I enter Phone as <Phone>
    #And I select a Lead Source as <Lead_Source>
    #And I select Product Interest as <Product_interest>
    #Then Verify lead editing
    #Examples:


 # Scenario: 001_SalesForce_change_Lead_Owner
  #  Given I have Login to Salesforce
   # When I click open cases Tab
    #And I click open
    #And I click Change Owner
    #And I search Users
      #search for Qs ,assign leads to Qs
    #And I click notification email checkbox
    #And I click Submit
    #Then Verify the added Lead Owner

  #Scenario: 001_SalesForce_Follow_Lead
   # Given Given I have Logged into Salesforce with my username "napeboshielo@capitecbank.co.za.int" and password "Gomora@1234"
    #When I click open Leads Tab
    #And I click existing Lead
    #And I click Follow
      #Verify notification
    #Then I verify a successful following

#move to clients
 # Scenario: 001_SalesForce_Send_Account_Closure_Survey
  #  Given I have Login to Salesforce
   # When I click open cases Tab
    #And I click open Lead link
    #And I click Send Account closure Survey button
    #Then Verify successful sending of the survey


 # Scenario: 001_SalesForce_Clone_Lead
  #  Given Given I have Logged into Salesforce with my username "napeboshielo@capitecbank.co.za.int" and password "Gomora@1234"
   # When I click open Leads Tab
    #And I click existing Lead
    #And I click clone button
    #And I select the close reason<Clone_Reason>#add Clone reason <2 options>
    #And I click save button
    #Then I verify a successful clone


##  001_assisted_landing Field Validations -invalid ID number
#  Scenario Outline: 001_assisted_landing
#    Given I am on the assisted onboarding landing page
#    When I click the Sole Proprietor radio button
#    And I enter First Name  as "<First_name>"
#    And I enter Last Name as "<Last_name>"
#    And I click ID number radio button
#    And I enter ID number as "<ID_number>"
#    And I enter Phone Number as "<Phone_number>"
#    And I enter email as "<Email>"
#    And i select Product interest
#    And I enter annual turnover as "<Annual_turnover>"
#    And i click Submit button
#    Then verify successful submission
#
#    Examples:
#      |scenario| First_name | Last_name| ID_number |Email|Annual_turnover|
#      |positive| Hamelton   |Mashele | 9404245449082 |hameltonmashele@capitecbank.co.za|500000|
#
#
#
##  001_assisted_landing Field Validations -invalid email
#  Scenario Outline: 001_assisted_landing
#    Given I am on the assisted onboarding landing page
#    When I click the Sole Proprietor radio button
#    And I enter First Name  as "<First_name>"
#    And I enter Last Name as "<Last_name>"
#    And I click ID number radio button
#    And I enter ID number as "<ID_number>"
#    And I enter Phone Number as "<Phone_number>"
#    And I enter email as "<Email>"
#    And i select Product interest
#    And I enter annual turnover as "<Annual_turnover>"
#    And i click Submit button
#    Then verify successful submission
#
#    Examples:
#      |scenario| First_name | Last_name| ID_number |Email|Annual_turnover|
#      |positive| Hamelton   |Mashele | 9404245449082 |hameltonmashele@capitecbank.co.za|500000|
#
##  001_assisted_landing Field Validations -No first name
#  Scenario Outline: 001_assisted_landing
#    Given I am on the assisted onboarding landing page
#    When I click the Sole Proprietor radio button
#    And I enter First Name  as "<First_name>"
#    And I enter Last Name as "<Last_name>"
#    And I click ID number radio button
#    And I enter ID number as "<ID_number>"
#    And I enter Phone Number as "<Phone_number>"
#    And I enter email as "<Email>"
#    And i select Product interest
#    And I enter annual turnover as "<Annual_turnover>"
#    And i click Submit button
#    Then verify successful submission
#
#    Examples:
#      |scenario| First_name | Last_name| ID_number |Email|Annual_turnover|
#      |positive| Hamelton   |Mashele | 9404245449082 |hameltonmashele@capitecbank.co.za|500000|
#
##  001_assisted_landing Field Validations -No lastname
#  Scenario Outline: 001_assisted_landing
#    Given I am on the assisted onboarding landing page
#    When I click the Sole Proprietor radio button
#    And I enter First Name  as "<First_name>"
#    And I enter Last Name as "<Last_name>"
#    And I click ID number radio button
#    And I enter ID number as "<ID_number>"
#    And I enter Phone Number as "<Phone_number>"
#    And I enter email as "<Email>"
#    And i select Product interest
#    And I enter annual turnover as "<Annual_turnover>"
#    And i click Submit button
#    Then verify successful submission
#
#    Examples:
#      |scenario| First_name | Last_name| ID_number |Email|Annual_turnover|
#      |positive| Hamelton   |Mashele | 9404245449082 |hameltonmashele@capitecbank.co.za|500000|
#
#
##  001_assisted_landing Field Validations -No ID
#  Scenario Outline: 001_assisted_landing
#    Given I am on the assisted onboarding landing page
#    When I click the Sole Proprietor radio button
#    And I enter First Name  as "<First_name>"
#    And I enter Last Name as "<Last_name>"
#    And I click ID number radio button
#    And I enter ID number as "<ID_number>"
#    And I enter Phone Number as "<Phone_number>"
#    And I enter email as "<Email>"
#    And i select Product interest
#    And I enter annual turnover as "<Annual_turnover>"
#    And i click Submit button
#    Then verify successful submission
#
#    Examples:
#      |scenario| First_name | Last_name| ID_number |Email|Annual_turnover|
#      |positive| Hamelton   |Mashele | 9404245449082 |hameltonmashele@capitecbank.co.za|500000|
#
#
##  001_assisted_landing Field Validations -No Phone_number
#  Scenario Outline: 001_assisted_landing
#    Given I am on the assisted onboarding landing page
#    When I click the Sole Proprietor radio button
#    And I enter First Name  as "<First_name>"
#    And I enter Last Name as "<Last_name>"
#    And I click ID number radio button
#    And I enter ID number as "<ID_number>"
#    And I enter Phone Number as "<Phone_number>"
#    And I enter email as "<Email>"
#    And i select Product interest
#    And I enter annual turnover as "<Annual_turnover>"
#    And i click Submit button
#    Then verify successful submission
#
#    Examples:
#      |scenario| First_name | Last_name| ID_number |Email|Annual_turnover|
#      |positive| Hamelton   |Mashele | 9404245449082 |hameltonmashele@capitecbank.co.za|500000|
#
#    #  001_assisted_landing Field Validations -No Annual_turnover
#  Scenario Outline: 001_assisted_landing
#    Given I am on the assisted onboarding landing page
#    When I click the Sole Proprietor radio button
#    And I enter First Name  as "<First_name>"
#    And I enter Last Name as "<Last_name>"
#    And I click ID number radio button
#    And I enter ID number as "<ID_number>"
#    And I enter Phone Number as "<Phone_number>"
#    And I enter email as "<Email>"
#    And i select Product interest
#    And I enter annual turnover as "<Annual_turnover>"
#    And i click Submit button
#    Then verify successful submission
#
#    Examples:
#      |scenario| First_name | Last_name| ID_number |Email|Annual_turnover|
#      |positive| Hamelton   |Mashele | 9404245449082 |hameltonmashele@capitecbank.co.za|500000|
#
# #  001_assisted_landing Field Validations -Annual_turnover greater than zero (negative value)
#  Scenario Outline: 001_assisted_landing
#    Given I am on the assisted onboarding landing page
#    When I click the Sole Proprietor radio button
#    And I enter First Name  as "<First_name>"
#    And I enter Last Name as "<Last_name>"
#    And I click ID number radio button
#    And I enter ID number as "<ID_number>"
#    And I enter Phone Number as "<Phone_number>"
#    And I enter email as "<Email>"
#    And i select Product interest
#    And I enter annual turnover as "<Annual_turnover>"
#    And i click Submit button
#    Then verify successful submission
#    Examples:
#      |scenario| First_name | Last_name| ID_number |Email|Annual_turnover|
#      |positive| Hamelton   |Mashele | 9404245449082 |hameltonmashele@capitecbank.co.za|500000|


#    The use of alphabet in number fields