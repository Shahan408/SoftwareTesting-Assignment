Feature: Dashboard Sidebar Navigation

  Scenario: Verify all sidebar links navigate correctly
    Given the user logs into the admin dashboard for TC007
    When the user clicks the Companies link for TC007
    Then the user should land on the Companies page for TC007
    When the user clicks the Platform Admins link for TC007
    Then the user should land on the Platform Admins page for TC007
    When the user clicks the Audit link for TC007
    Then the user should land on the Audit page for TC007
    When the user clicks the Settings link for TC007
    Then the user should land on the Settings page for TC007
    When the user clicks the Overview link for TC007
    Then the user should land on the Overview page for TC007