Feature: Company Industry Filter

  Scenario: Filter companies by industry
    Given the user logs into the admin dashboard for TC015
    When the user navigates to the companies page for TC015
    And the user filters by industry "Technology" for TC015
    Then only companies with industry "Technology" should be displayed for TC015