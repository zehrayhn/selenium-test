package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MandatoryPermitsPage extends BasePage{

    public MandatoryPermitsPage(WebDriver driver){
        super(driver);
    }
    By mandatoryPermitsHeaderLocator=new By.ByCssSelector("div.activationSectionContent");

    By successButtonLocator=new By.ByCssSelector("[class=\'btn btn-success btm-lg btnRounded btnAgree\']");

    By nameLocator= new By.ByCssSelector("[class=\'title\']");

    By nameDemoLocator=new By.ByCssSelector(".activationSectionContent > b");
    public WebElement mandatoryPermitsHeaderFind(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(mandatoryPermitsHeaderLocator));
    }
    public WebElement nameFind(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(nameDemoLocator));
    }

    public String getExpectedName(){
        String fullName = nameFind().getText();
        String expectedPrefix = "Hoşgeldin ";

        if (fullName.startsWith(expectedPrefix)) {
            // Metin "Hoşgeldin " ile başlıyorsa, bu önek kısmını kaldır ve geriye kalanı döndür
            return fullName.substring(expectedPrefix.length());
        } else {
            // "Hoşgeldin " öneği yoksa, metni olduğu gibi döndür
            return fullName;
        }
    }
    public boolean isNameDisplayed(){
        return nameFind().isDisplayed();
    }

    public boolean isDisplayed(){
        return mandatoryPermitsHeaderFind().isDisplayed();
    }
    public WebElement successButtonFind(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Bekleme ekleyebilirsiniz, metni kontrol etmek veya başka bir eylem yapmak için
        try {
            Thread.sleep(2000); // 2 saniye bekleyin
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(successButtonLocator));
    }
    public void successButtonClick(){
        successButtonFind().click();
    }



}
