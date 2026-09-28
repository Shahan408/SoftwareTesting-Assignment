Feature: Companies Status Filter

  Scenario: Filter companies by Active status
    Given the user logs into the admin dashboard for TC014
    When the user navigates to the companies page for TC014
    And the user filters by status "Active" for TC014
    Then only companies with status "Active" should be displayed for TC014