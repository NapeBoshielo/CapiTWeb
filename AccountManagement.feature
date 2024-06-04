@accountManagement @regression

Feature: 001_SalesForce_AccountManagement

  Scenario Outline: 001_SalesForce_FICA_Validation
   Given I have Logged into Salesforce with username "napeboshielo@capitecbank.co.za.preprod" and password "CRM@123456"
   When i open Client tab
    And I select new Client
    And I check Record Type  as "<Record_type>"
   Then I validate and verify the KYC status "<KYC_Status>"


    Examples:
      | Record_type     |  | KYC_Status |
      | Sole Proprietor |  | Yes        |
      | Sole Proprietor |  | No         |


  Scenario Outline: 001_SalesForce_FICA_CIF
    Given I have Logged into Salesforce with username "napeboshielo@capitecbank.co.za.preprod" and password "CRM@123456"
    When i open Client tab
    And I select new Client
    And I check Record Type  as "<Record_type>"

    And I validate and verify the KYC status "<KYC_Status>"
    Then Verify Updated Consent
    Then I enter CIF number and System Information
   And I fill in Client details
    And I Add a product
    Then verify Added product

    Examples:
      | Record_type     |  | KYC_Status |

      | Sole Proprietor |  | No         |