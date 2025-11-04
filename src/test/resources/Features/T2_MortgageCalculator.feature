#Author: Ansu Biju
#Date: Oct 24, 2025

Feature: TD Mortgage Payment Calculator navigation
  As a user,
  I want to access the Mortgage Payment Calculator from the TD homepage
  So that I can calculate my mortgage payments

  Scenario Outline: Navigate and enter mortgage details
    Given I navigate to the base URL
    When I open the Mortgages menu
    And I click the Mortgage Payment Calculator link
    Then the Mortgage Payment Calculator page should be visible
    Then I enter the value "<amount>" in MortgageAmount
    And I select "<termInterestRate>" from Term and interest rate dropdown
    And I select "<amortizationperiod>" from Amortization period dropdown
    And I select "Monthly" from Payment frequency dropdown
    And I click the Calculate button
    Then the calculated payment should be "$ 445.56"
	

  Examples:
    | amount | termInterestRate      |	amortizationperiod	|
    | 50000  | 1 year open 9.95%     |	25 years			|
 