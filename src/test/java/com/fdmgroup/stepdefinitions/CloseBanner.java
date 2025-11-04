package com.fdmgroup.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.fdmgroup.pages.HomePage;
import com.fdmgroup.utilities.ConfigReader;
import com.fdmgroup.utilities.DriverUtilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CloseBanner {
	 WebDriver driver = DriverUtilities.getInstance().getDriver();
	 HomePage homePage = new HomePage(driver);
    
	@Given("I am on the TD Canada homepage")
	    public void i_navigate_to_the_base_url() {
	        String baseUrl = ConfigReader.getProperty("baseUrl");
	        driver.get(baseUrl);
	    }

	@When("I close the Canada Post service disruption banner")
	public void i_close_the_service_disruption_banner() {
		homePage.closeBannerIfPresent();
	}

	@Then("the banner should no longer be visible")
	public void the_banner_should_no_longer_be_visible() {
	    Assert.assertFalse("Banner is still visible", homePage.isBannerVisible());
	}

}
