Feature: Login Page - Password Visibility Toggle

  Scenario: Toggle password visibility using the eye icon
    Given the user opens the admin login page for TC005
    When the user enters a password for TC005
    And the user clicks the show password icon for TC005
    Then the password should be visible as plain text for TC005
    When the user clicks the show password icon again for TC005
    Then the password should be masked again for TC005