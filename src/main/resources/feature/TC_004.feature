Feature: Login Page - Invalid Email Format Validation

  Scenario: Login attempt with incorrectly formatted email
    Given the user opens the admin login page for TC004
    When the user enters a malformed email for TC004
    And the user enters a password for TC004
    And the user submits the login form for TC004
    Then an email format validation error should be displayed for TC004