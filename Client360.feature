@Client360 @regressionTests

Feature: 001_SalesForce_Client360_and_NBA


  Scenario Outline: 001_SalesForce_Client360
  #  Given I have Logged into Salesforce with username "napeboshielo@capitecbank.co.za.preprod" and password "CRM@123456"
  # When i open Client tab
  #  And I select new Client
   # And I check Record Type  as "<Record_type>"
  #  And i click Save
   # Then Verify Milestones as "<MileStonesType>"


    Examples:
      | Record_type         | MileStonesType      |
      | Sole Proprietor     | Life Events         |
      | Registered Business | Business Milestones |

  Scenario Outline: 001_SalesForce_NextBest_Action
    Given I have Logged into Salesforce with username "napeboshielo@capitecbank.co.za.preprod" and password "CRM@123456"
    When i open Client tab
    And I select new Client
   # And I check Record Type  as "<Record_type>"
   # And i click Save
    Then Verify The Next Best Action


    Examples:
      | Record_type     |
      | Sole Proprietor |

