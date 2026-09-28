Feature: Companies Search

  Scenario: Search for a company using its slug
    Given the user logs into the admin dashboard for TC013
    When the user navigates to the companies page for TC013
    And the user searches for slug "test2" for TC013
    Then the company "test2" should be displayed in the results for TC013
