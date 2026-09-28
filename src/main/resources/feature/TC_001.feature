Feature: Testing Functionality of a Logout Feature

  Scenario: Successful login with valid admin credentials
Given the user is on the admin login page
When the user enters a valid email address
And the user enters the correct password
And the user clicks the Sign in button
Then the user should be redirected to the admin dashboard
