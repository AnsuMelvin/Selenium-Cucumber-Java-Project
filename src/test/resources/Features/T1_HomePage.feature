#Author: Ansu Biju
#Date: Oct 24, 2025

Feature: Verify TD Canada homepage
As a user,
I want to verify the TD Canada homepage loads correctly
So that I can trust the application is accessible.

Scenario: Verify TD Canada Site Access and Title
Given I navigate to the base URL
Then the page title should contain "TD Canada Trust"

Scenario: Verify TD logo on the page
Given I navigate to the base URL
Then the TD logo should be displayed

Scenario Outline: Verify page title contains expected text with different inputs
Given I navigate to the base URL
Then the page title should contain "<expectedTitle>"


Examples:
  | expectedTitle         |
  | TD Canada Trust       |
