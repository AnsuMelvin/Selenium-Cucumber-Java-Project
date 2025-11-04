package com.fdmgroup.stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.fdmgroup.pages.HomePage;
import com.fdmgroup.pages.MortgageCalculatorPage;
import com.fdmgroup.pages.MortgagesMenuPage;
import com.fdmgroup.utilities.DriverUtilities;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class MortgageCalculatorSteps {
	 WebDriver driver = DriverUtilities.getInstance().getDriver();
	    HomePage homePage = new HomePage(driver);
	    MortgagesMenuPage menuPage = new MortgagesMenuPage(driver);
	    MortgageCalculatorPage calculatorPage = new MortgageCalculatorPage(driver);
	    

	    @When("I open the Mortgages menu")
	    public void i_open_the_mortgages_menu() {
	        homePage.clickMortgagesMenu();
	    }

	    @When("I click the Mortgage Payment Calculator link")
	    public void i_click_the_mortgage_payment_calculator_link() throws InterruptedException {
	    	menuPage.clickMortgagePaymentCalculatorMenu();
	    }

	    @Then("the Mortgage Payment Calculator page should be visible")
	    public void the_mortgage_payment_calculator_page_should_be_visible() {
	    	
	        boolean visible = calculatorPage.isMortgageAmountInputVisible();
	        Assert.assertTrue("Mortgage amount input is not visible", visible);
	    }
	    
	    @Then("I enter the value {string} in MortgageAmount")
	    public void i_enter_the_value_in_mortgage_amount(String amount) {
	        // Convert amount String to int if page method expects int
	        int mortgageAmount = Integer.parseInt(amount);
	        calculatorPage.enterMortgageAmount(mortgageAmount);
	    }
	    
	    @And("I select {string} from Term and interest rate dropdown")
	    public void i_select_from_term_and_interest_rate_dropdown(String termInterestRate) {
	        calculatorPage.selectTermInterestRate(termInterestRate);
	    }
	    
	    @And("I select {string} from Amortization period dropdown")
	    public void i_select_from_amortization_period_dropdown(String amortizationPeriod) {
	        calculatorPage.selectAmortizationPeriod(amortizationPeriod);
	    }
	    
	    @And("I select {string} from Payment frequency dropdown")
	    public void i_select_from_payment_frequency_dropdown(String paymentFrequency) {
	        calculatorPage.selectPaymentFrequency(paymentFrequency);
	    }
	    @And("I click the Calculate button")
	    public void i_click_the_calculate_button() {
	        calculatorPage.clickCalculateButton();
	    }
	    @Then("the calculated payment should be {string}")
	    public void the_calculated_payment_should_be(String expectedValue) {
	        String actual = calculatorPage.getCalculatedPayment();
	        assertEquals("Calculated payment value mismatch", expectedValue, actual);
	    }

}