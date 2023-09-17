package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MandatoryPermitsPage extends BasePage{

    public MandatoryPermitsPage(WebDriver driver){
        super(driver);
    }

    By confirmButtonLocator =new By.ByCssSelector("[class=\'btn btn-success btm-lg btnRounded btnAgree\']");

    By welcomeLocator =new By.ByCssSelector(".activationSectionContent > b");

    public WebElement findWelcome(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(welcomeLocator));
    }

    public String getExpectedName(){
        String fullName = findWelcome().getText();
        String expectedPrefix = "Hoşgeldin ";

        if (fullName.startsWith(expectedPrefix)) {
            // Metin "Hoşgeldin " ile başlıyorsa, bu önek kısmını kaldır ve geriye kalanı döndür
            return fullName.substring(expectedPrefix.length());
        } else {
            // "Hoşgeldin " öneği yoksa, metni olduğu gibi döndür
            return fullName;
        }
    }

    public WebElement findConfirmButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Bekleme ekleyebilirsiniz, metni kontrol etmek veya başka bir eylem yapmak için
        try {
            Thread.sleep(2000); // 2 saniye bekleyin
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(confirmButtonLocator));
    }
    public void clickConfirmButton(){
        findConfirmButton().click();
    }



}
