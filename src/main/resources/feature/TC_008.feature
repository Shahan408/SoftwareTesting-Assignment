Feature: Dashboard Logout Flow

  Scenario: Verify logout redirects to login page and terminates session
    Given the user logs into the admin dashboard for TC008
    When the user clicks the Log out button for TC008
    Then the user should be redirected to the login page for TC008
    And the user should not be able to access the dashboard via back navigation for TC008