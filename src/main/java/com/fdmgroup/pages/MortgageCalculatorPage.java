package com.fdmgroup.pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MortgageCalculatorPage extends BasePage {

    private By calculatorIframe = By.id("MPCIframe");
    private By mortgageAmountInput = By.xpath("//input[@name='amount']");
    private By termInterestRateDropdown = By.xpath("//select[@aria-label='Term and interest rate']");
    private By amortizationPeriodDropdown = By.xpath("//select[@aria-label='Amortization period']");
    private By paymentFrequencyDropdown = By.xpath("//select[@aria-label='Payment frequency']");
    private By calculateButton = By.xpath("//button[contains(@class, 'td-btn-primary-light') and text()='Calculate']");
    private By cookieAcceptButton = By.id("onetrust-accept-btn-handler");
    private By cookieBanner = By.id("onetrust-policy-text");
    private By calculatedPayment = By.cssSelector("p.display-1");

    public MortgageCalculatorPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void dismissCookieBannerIfPresent() {
        try {
            WebElement acceptBtn = new WebDriverWait(driver, Duration.ofSeconds(5))
                                        .until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
            acceptBtn.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(cookieBanner));
        } catch (TimeoutException e) {
            // Banner not present
        }
    }

    public void enterMortgageAmount(int amount) {
        dismissCookieBannerIfPresent();
        switchToIframe(calculatorIframe);
        sendKeys(mortgageAmountInput, String.valueOf(amount));
        switchToDefaultContent();
    }

    public void selectTermInterestRate(String visibleText) {
        dismissCookieBannerIfPresent();
        switchToIframe(calculatorIframe);
        Select dropdown = new Select(waitForVisibility(termInterestRateDropdown));
        dropdown.selectByVisibleText(visibleText);
        switchToDefaultContent();
    }

    public void selectAmortizationPeriod(String visibleText) {
        dismissCookieBannerIfPresent();
        switchToIframe(calculatorIframe);
        Select dropdown = new Select(waitForVisibility(amortizationPeriodDropdown));
        dropdown.selectByVisibleText(visibleText);
        switchToDefaultContent();
    }

    public void selectPaymentFrequency(String visibleText) {
        dismissCookieBannerIfPresent();
        switchToIframe(calculatorIframe);
        Select dropdown = new Select(waitForVisibility(paymentFrequencyDropdown));
        dropdown.selectByVisibleText(visibleText);
        switchToDefaultContent();
    }

    public void clickCalculateButton() {
        dismissCookieBannerIfPresent();
        switchToIframe(calculatorIframe);
        WebElement button = waitForVisibility(calculateButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        try {
            button.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }
        switchToDefaultContent();
    }

    public String getCalculatedPayment() {
        switchToIframe(calculatorIframe);
        String result = waitForVisibility(calculatedPayment).getText();
        switchToDefaultContent();
        return result;
    }

    private void switchToCalculatorIframe() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(calculatorIframe));
    }

    public boolean isMortgageAmountInputVisible() {
        try {
            switchToIframe(calculatorIframe);
            boolean visible = waitForVisibility(mortgageAmountInput).isDisplayed();
            switchToDefaultContent();
            return visible;
        } catch (Exception e) {
            switchToDefaultContent();
            return false;
        }
    }
}
