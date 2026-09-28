Feature: Company Registration

  Scenario: Successfully register a new company with all required details
    Given the user logs into the admin dashboard for TC009
    When the user navigates to the register company page for TC009
    And the user fills in valid company information for TC009
    And the user fills in valid initial owner details for TC009
    And the user submits the registration form for TC009
    Then the new company should be created successfully for TC009