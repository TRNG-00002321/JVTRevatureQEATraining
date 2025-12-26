@authentication
Feature: User Authentication
  As a registered user
  I want to log in and out of the application
  So that I can access protected content

  Background:
    Given the user is on the login page

  @smoke @positive
  Scenario: Successful login with valid credentials
    When the user enters username "tomsmith"
    And the user enters password "SuperSecretPassword!"
    And the user clicks the login button
    Then the user should be logged in successfully
    And the user should see welcome message "You logged into a secure area!"

  @negative
  Scenario: Failed login with invalid password
    When the user enters username "tomsmith"
    And the user enters password "BadPassword!"
    And the user clicks the login button
    Then the user should see message "password is invalid"

  @negative
  Scenario: Failed login with invalid username
    When the user enters username "invalidusername"
    And the user enters password "SuperSecretPassword!"
    And the user clicks the login button
    Then the user should see message "username is invalid"

  @logout
  Scenario: Successful logout
    Given the user is logged in as "tomsmith"
    When the user clicks the logout button
    Then the user should be logged out
    And the user should see message "You logged out of the secure area!"

  @data-driven
  Scenario Outline: Login validation with multiple credentials
    When the user enters username "<username>"
    And the user enters password "<password>"
    And the user clicks the login button
    Then the login result should be "<result>"

    Examples:
      | username    | password             | result  |
      | tomsmith    | SuperSecretPassword! | success |
      | invaliduser | SuperSecretPassword! | failed  |
      | tomsmith    | wrongpassword        | failed  |
      |             |                      | failed  |