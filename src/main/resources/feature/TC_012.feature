Feature: Companies Search

  Scenario: Search for a non-existing company

    Given the user logs into the admin dashboard for TC012
    When the user navigates to the companies page for TC012
    And the user searches for "ABCXYZ999" for TC012
    Then the company "ABCXYZ999" should not be displayed in the results for TC012