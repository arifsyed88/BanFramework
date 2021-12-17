Feature: LoginFeature
  This feature deals wit the login functionality of the application

  Scenario: Login with correct username and password
    Given I navigate to the login page
    And I enter the following details for login information
      | username  | password  |
      | adminUser | adminPass |
    And I click on login button
    Then I should see the userform page

  Scenario: Login with correct username and password with another user
    Given I navigate to the login page
    And I enter the following details for login information
      | username   | password   |
      | adminUser2 | adminPass2 |
    And I click on login button
    Then I should see the userform page
