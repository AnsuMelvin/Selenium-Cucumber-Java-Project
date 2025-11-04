package com.fdmgroup.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MortgagesMenuPage extends BasePage {

    private By mortgageCalculatorLink = By.xpath("(//a[contains(text(), 'Mortgage Payment Calculator')])[1]");

    public MortgagesMenuPage(WebDriver driver) {
        super(driver);
    }

    public void clickMortgagePaymentCalculatorMenu() throws InterruptedException {
        try {
            Thread.sleep(2000);
            WebElement link = waitForVisibility(mortgageCalculatorLink);
            link.click();
        	} catch (StaleElementReferenceException e) {
            driver.findElement(mortgageCalculatorLink).click();
        }
    }
}