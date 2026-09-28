Feature: Login Page - Empty Fields Validation

  Scenario: Login attempt with empty email and password fields
    Given the user opens the admin login page for TC003
    When the user leaves email and password empty for TC003
    And the user submits the login form for TC003
    Then validation errors should be displayed for TC003