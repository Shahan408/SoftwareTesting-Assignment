Feature: Login Page - Invalid Password

  Scenario: Login attempt with incorrect password
    Given the user opens the admin login page for TC002
    When the user provides a valid email for TC002
    And the user provides an incorrect password for TC002
    And the user submits the login form for TC002
    Then an error message should be displayed for TC002