package com.fdmgroup.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By tdLogo = By.xpath("(//img[@alt='TD Canada Trust' and contains(@src, 'td-logo-desktop.png')])[1]");
    private By mortgagesMenu = By.xpath("(//a[contains(@class, 'cmp-header-site-navigation-links__menu-link')])[3]");
    private By cookieAcceptButton = By.id("onetrust-accept-btn-handler");
    
    // Locator for the banner close button or the banner element
    private By bannerCloseButton = By.xpath("//span[@id='cmp-emergency-message-close']"); 
    private By bannerElement = By.xpath("//p[contains(text(), 'A Canada Post service disruption is in effect')]");          
    
    public HomePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isTDLogoDisplayed() {
        try {
            return waitForVisibility(tdLogo).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void closeCookieBannerIfPresent() {
        try {
            if (driver.findElement(cookieAcceptButton).isDisplayed()) {
                clickElement(cookieAcceptButton);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            // No banner present, ignore
        }
    }

    public void clickMortgagesMenu() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                clickElement(mortgagesMenu);
                return;
            } catch (StaleElementReferenceException e) {
                attempts++;
                System.out.println("Stale element encountered on Mortgages menu click. Retry " + attempts);
            }
        }
        throw new RuntimeException("Failed to click Mortgages menu due to stale element references");
    }
    
    public boolean isBannerVisible() {
        try {
            return driver.findElement(bannerElement).isDisplayed();
        } catch (Exception e) {
            return true;
        }
    }

    public void closeBannerIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(bannerCloseButton));
            closeBtn.click();
            wait.until(ExpectedConditions.invisibilityOf(closeBtn));
        } catch (TimeoutException e) {
            // Banner or close button not present 
        }
    }
}
