#Author: Ansu Biju
#Date: Oct 24, 2025

Feature: Dismiss Canada Post Service Disruption Banner
  As a user,
  I want to close the Canada Post service disruption banner
  So that the banner does not interfere with other page elements during testing

  Scenario: Close the service disruption banner if present
    Given I am on the TD Canada homepage
    When I close the Canada Post service disruption banner
    Then the banner should no longer be visible