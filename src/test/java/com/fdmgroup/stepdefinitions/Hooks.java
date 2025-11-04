package com.fdmgroup.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.fdmgroup.utilities.DriverUtilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverUtilities.getInstance().getDriver();
        System.out.println("Browser launched and ready for test");
    }

    @After
    public void tearDown() {
        System.out.println("After scenario: closing browser");
        DriverUtilities.getInstance().quitDriver();
        System.out.println("Browser closed after scenario");
    }
}