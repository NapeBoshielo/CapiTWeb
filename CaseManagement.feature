@caseManagement @regressionTests

Feature: 001_SalesForce_Case_Management

  Scenario Outline: 001_SalesForce_Milestones
    Given I have Logged into Salesforce with username "napeboshielo@capitecbank.co.za.preprod" and password "CRM@123456"
    When i open cases Tab
    And i click New Button
    And i click existing client Name
    And i click Existing contact Name
    And i select case type as "<Case_Type>"
    And i click Save button

    Then Verify Milestones

    Examples:
      | Title | firstName | lastName | SA_ID         | Registration_number | Record_type         | Case_Type | Phone      | EmailAddress   | Scenerio |
      | Mr    | Steve     | Molamo   | 9807194980081 | 193091              | Sole Proprietor     | Query     | 0123657483 | nape@gmail.com | Postive  |



  Scenario Outline: 001_SalesForce_Migrate_Case_To_Lead
    Given I have Logged into Salesforce with username "napeboshielo@capitecbank.co.za.preprod" and password "CRM@123456"
    When i open cases Tab
    And i select existing cases
    And select change Owner and Migrate from Case to Lead
    And i click new contact Name
    And i enter Contact details
    And i click Save button
    Then Verify successful case creation

    Examples:
      | Title | firstName | lastName | SA_ID         | Registration_number | Record_type         | Scenerio |
      | Mr    | Junior    | Kgomo    | 9807194980081 | 193091              | Sole Proprietor     | Postive  |
      | Ms    | Mary      | Nkwe     | 9807191208080 | 470010              | Registered Business | Postive  |





 Scenario Outline: 001_SalesForce_New_Case
    Given I have Logged into Salesforce with username "napeboshielo@capitecbank.co.za.preprod" and password "CRM@123456"
    When i open cases Tab
    And i click New Button
    And i click client Name
    And i check Record Type  as "<Record_type>"
    And i click new contact Name
   And i enter Contact details
   And i click Save button
   Then Verify successful case creation

    Examples:
      | Title | firstName | lastName | SA_ID         | Registration_number | Record_type         | Scenerio |
      | Mr    | Junior    | Kgomo    | 9807194980081 | 193091              | Sole Proprietor     | Postive  |
      | Ms    | Mary      | Nkwe     | 9807191208080 | 470010              | Registered Business | Postive  |





  Scenario Outline: 001_SalesForce_Case_History_Verification
    Given I have Logged into Salesforce with username "napeboshielo@capitecbank.co.za.preprod" and password "CRM@123456"
    When i open cases Tab
    And i click existing case number
    And i edit case Status as "<status>"and Case type as "<Case_type>"
    And i edit Case priority "<priority>" and Case origin "<Case_origin>"
    And i edit Case category as "<Case_Category>" and Case sub as "<Case_sub>" and Case issue as "<Case_Issue>"
    And i enter Case Subject as "<Subject>"
    And i click Save
    Then Verify Case History

    Examples:
      | status   | Case_type | Case_Category  | Case_sub      | Case_Issue        | priority | Case_origin | Subject | Scenerio |
      | Assigned | Query     | Credit (Query) | Bond Accounts | Audit Certificate | Low     | Email       | Test    | Postive  |







  #change ownership Request




#search existing contact and search existing clients -> Cases -> New -> Search Name->Search Contact Name ->Case Type Clasification
  # -> #->Verify Milestones(No milestones for compliments-cant be clasified)->

  #check Milestones/SLAs ,escalations 50%,75%,100% > Cases -> New -> Search Name->Search Contact Name ->Case Type Clasification->
  #->Verify Milestones(No milestones for compliments-cant be clasified)->





  #email

  #activities(Email event)- next best action(NBA) - pending customer feedback->NB only applicable on existing Case
  #->Cases -> Click list view->Select All Cases->Searchg for a case -> select case ->click feed->click email->select from->enter email address
  #-> verify sent email->

  #Log a call

   #activities(Email event)- next best action(NBA) - pending customer feedback->NB only applicable on existing Case
  #->Cases -> Click list view->Select All Cases->Searchg for a case -> select case ->click feed->Log a call->enter details ->verify logged call
#post
  #activities(Email event)- next best action(NBA) - pending customer feedback->NB only applicable on existing Case
  #->Cases -> Click list view->Select All Cases->Searchg for a case -> select case ->click feed->Post -> verify post->verify notification

  #Event

 #activities(Email event)- next best action(NBA) - pending customer feedback->NB only applicable on existing Case
  #->Cases -> Click list view->Select All Cases->Searchg for a case -> select case ->click feed->New Event->/task ->populate details and save
  ##

#Task->home page

  #Case History
#search existing contact and search existing clients -> Cases -> New /existing that you own-> Search Name->Search Contact Name ->Case Type Clasification
  # -> #->make changes to cases that you own-> edit ->make changes to fields->save->click related tab-> select case history->

  #



  #Case history- eg current user -
    # i select Case type as"<CaseType>" with case Category "<CaseCategory>" Case Sub Category





  #Resolution(Case closure)- Emails

  #select existing case->check type->check resolution/closure details->edit -if there is no resolution ->add resolution->select closed-> select marked status
  #->Verify case Closure email




  #Knowledge management
#escalations 50%,75%,100%
