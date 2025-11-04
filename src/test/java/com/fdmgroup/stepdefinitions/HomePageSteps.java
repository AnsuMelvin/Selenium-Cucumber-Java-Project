package com.fdmgroup.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.fdmgroup.pages.HomePage;
import com.fdmgroup.utilities.ConfigReader;
import com.fdmgroup.utilities.DriverUtilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {

    WebDriver driver = DriverUtilities.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);

   
    @Then("the page title should contain {string}")
    public void the_page_title_should_contain(String expectedTitle) {
        String actualTitle = homePage.getPageTitle();
        Assert.assertTrue("Page title does not contain expected text", actualTitle.contains(expectedTitle));
        System.out.println("Verified page title contains: " + expectedTitle);
    }

    @Then("the TD logo should be displayed")
    public void the_td_logo_should_be_displayed() {
        Assert.assertTrue("TD logo is not visible on homepage", homePage.isTDLogoDisplayed());
        System.out.println("TD logo is displayed on homepage");
    }
}