Feature: Companies Search

  Scenario: Search for an existing company by name
    Given the user logs into the admin dashboard for TC011
    When the user navigates to the companies page for TC011
    And the user searches for "Test" for TC011
    Then the company "Test" should be displayed in the results for TC011
