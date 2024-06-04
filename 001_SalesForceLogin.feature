@loginSalesForce

Feature: 001_SalesForce_Login

  Scenario Outline: 001_SalesForce_Login
    Given I am on the SalesForce login page
    When I enter the channel username as "<username>"
    And I enter the channel password as "<password>"
    And I click the login  button
    Then verify successful login

    Examples:
      | username                               | password      | scenario |
      | napeboshielo@capitecbank.co.za.preprod | Loyiso@123456 | postive  |


#   Attempt to Login without capturing Password
  Scenario Outline: 001_SalesForce_Login field validations
    Given I am on the SalesForce login page
    When I enter the channel username as "<username>"
    And I enter the channel password as "<password>"
    And I click the login  button
    Then verify successful login

    Examples:
      | username                               | password | scenario |
      | napeboshielo@capitecbank.co.za.preprod |          | Negative |

#   Attempt Login without capturing Username

  Scenario Outline: 001_SalesForce_Login field validations
    Given I am on the SalesForce login page
    When I enter the channel username as "<username>"
    And I enter the channel password as "<password>"
    And I click the login  button
    Then verify successful login


    Examples:
      | username | password      | scenario |
      |          | Loyiso@123456 | Negative |



#   Remember me checkbox test

  Scenario Outline: 001_SalesForce_Login_And_Checks_RememberMe
    Given I am on the SalesForce login page
    When I enter the channel username as "<username>"
    And I enter the channel password as "<password>"
    And I click the login  button
 #   And i checkbox remember me
    Then verify successful login

    Examples:
      | username                               | password      | scenario |
      | napeboshielo@capitecbank.co.za.preprod | Loyiso@123456 | postive  |