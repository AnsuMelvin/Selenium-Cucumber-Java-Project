package com.fdmgroup.utilities;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtilities {

    // Singleton instance
    private static DriverUtilities driverUtilities = new DriverUtilities();
    private WebDriver driver;

    // Private constructor
    private DriverUtilities() {}

    // Public static getter for Singleton
    public static DriverUtilities getInstance() {
        return driverUtilities;
    }

    // Get WebDriver instance
    public WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    // Create the WebDriver
    private void createDriver() {
        String driverName = getDriverName().toUpperCase();

        switch (driverName) {
            case "CHROME":
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                break;
            default:
                System.err.println("Unknown browser in config, defaulting to Chrome");
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    // Read browser name from config.properties
    private String getDriverName() {
        Properties config = new Properties();
        try {
            config.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            System.err.println("FATAL: Could not read config.properties. Defaulting to Chrome.");
            return "Chrome";
        }
        return config.getProperty("browser", "Chrome");
    }

    // Quit driver safely
    public void quitDriver() {
        if (driver != null) {
            try {
                driver.quit();
                System.out.println("Browser closed successfully.");
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Exception while closing browser: " + e.getMessage());
            } finally {
                driver = null;
            }
        }
    }
}