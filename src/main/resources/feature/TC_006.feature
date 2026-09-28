Feature: Dashboard Access Control

  Scenario: Attempt to access admin dashboard without logging in
    Given the user has not logged in for TC006
    When the user directly navigates to the dashboard URL for TC006
    Then the user should be redirected to the login page for TC006