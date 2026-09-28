Feature: Company Registration Validation

  Scenario: Attempt to register a company with empty required fields
    Given the user logs into the admin dashboard for TC010
    When the user navigates to the register company page for TC010
    And the user submits the registration form without filling any fields for TC010
    Then validation errors should be displayed for TC010
    And no company should be created for TC010