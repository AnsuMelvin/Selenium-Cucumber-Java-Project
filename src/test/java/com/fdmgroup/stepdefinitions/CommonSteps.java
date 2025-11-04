package com.fdmgroup.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.fdmgroup.utilities.ConfigReader;
import com.fdmgroup.utilities.DriverUtilities;

import io.cucumber.java.en.Given;

public class CommonSteps {
	WebDriver driver = DriverUtilities.getInstance().getDriver();

    @Given("I navigate to the base URL")
    public void i_navigate_to_the_base_url() {
        String baseUrl = ConfigReader.getProperty("baseUrl");
        driver.get(baseUrl);
    }
}