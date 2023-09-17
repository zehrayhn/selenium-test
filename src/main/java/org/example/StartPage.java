package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartPage extends BasePage{

    public StartPage(WebDriver driver){
        super(driver);
    }

    By registerButtonLocator =new By.ByCssSelector("div.buttonItem:nth-child(2) a.loginButton");


    public WebElement findRegister(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(registerButtonLocator));
    }
    public void clickRegister(){
        findRegister().click();
    }

}
