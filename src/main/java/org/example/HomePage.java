package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By homePageHeaderLocator = new By.ByCssSelector("[class=\'userAccountTitle\']");

    public WebElement findHeader() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(homePageHeaderLocator));
    }

    public boolean isHeaderDisplayed() {

        return findHeader().isDisplayed();

    }

}
