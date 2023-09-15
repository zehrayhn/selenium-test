package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PhotoShootPage extends BasePage {
    ///private static final Logger logger = LogManager.getLogger(PhotoShootPage.class);
    Log log;
    private CookieHelper cookieHelper;

    public PhotoShootPage(WebDriver driver) {
        super(driver);
        this.cookieHelper = new CookieHelper(driver);
    }

    By photoShootPageHeaderLocator = new By.ByCssSelector("[class=\'sectionTitle textCenter\']");
    By addPhotoButtonLocator = new By.ByCssSelector("[class=\'btn btn-success btm-lg btnRounded btnAgree\']");
    By savePhotoButtonLocator = new By.ByCssSelector("[class=\'btn btnRounded btn-success btn-lg btnFont\']");
    //By addIdentityButtonLocator=By.xpath("//*[@id=\'dashboardMainContent\']/div/div[4]/div/div/div/div[3]/button");
    //  By addIdentityButtonLocator=new By.ByCssSelector("[class=\'btn btn-success btm-lg btnRounded btnAgree\']");
    By addIdentityButtonLocator = new By.ByCssSelector("#dashboardMainContent > div > div.dashboardContentMain > div > div > div > div.activationSectionFooter.flexCenter.borderTop.paddingTop > button");
    By saveIdentityButtonLocator = new By.ByCssSelector(".btnAgree:nth-child(1)");
    By identityHeaderLocator = new By.ByCssSelector("[class=\'sectionTitle textCenter\']");

    public WebElement photoShootPageHeaderFind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(photoShootPageHeaderLocator));
    }

    public boolean isDisplayed() {
        return photoShootPageHeaderFind().isDisplayed();
    }

    public WebElement identityHeaderFind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(identityHeaderLocator));
    }

    public boolean isIdentityHeaderDisplayed() {
        try {
            return identityHeaderFind().isDisplayed();
        } catch (Exception e) {
            Log.error("hata mesajı displayed:" + e.getMessage());
            Log.info("hata mesajı veriyor");
            System.out.println(e.getMessage());
            return false;
        }

    }

    public WebElement addPhotoButtonFind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(addPhotoButtonLocator));
    }

    public WebElement savePhotoButtonFind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        return wait.until(ExpectedConditions.elementToBeClickable(savePhotoButtonLocator));
    }

    public WebElement addIdentityButtonFind() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100000));
            Log.info("locator bulunuyorr..");
            return wait.until(ExpectedConditions.presenceOfElementLocated(addIdentityButtonLocator));
        } catch (TimeoutException e) {

            System.err.println("Element bulunamadı: " + e.getMessage());
            Log.error("Element bulunamıyor cunku: " + e.getMessage());
            return null;
        } catch (Exception er) {
            System.err.println("Exception Element bulunamadı: " + er.getMessage());
            Log.error("exception Element bulunamıyor cunku: " + er.getMessage());
            return null;
        }
    }

    public WebElement saveIdentityButtonFind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        return wait.until(ExpectedConditions.elementToBeClickable(saveIdentityButtonLocator));
    }


    public void saveProfilePhoto() {
        //fotograf ekle işlemi
        Actions action = new Actions(driver);
        action.moveToElement(addPhotoButtonFind()).click().perform();

        savePhotoButtonFind().click();

    }

    public void identityPhotoMove() {

        //kimlikfotoğraf ekleme işlemi
        if (addPhotoButtonFind().isDisplayed() && addPhotoButtonFind().isEnabled()) {
            System.out.println("Buton mevcut ve etkin (tıklanabilir) durumda.");
            try {
                //  identity.click();
                addPhotoButtonFind().click();
            } catch (Exception e) {
                Log.error("addPhotoFind butona tıklarken hata: " + e.getMessage());
            }
            addPhotoButtonFind().click();

        } else {
            System.out.println("Buton etkin değil (tıklanamaz).");
        }

    }

    public void saveIdentityPhoto() {

        //   WebElement popup = driver.findElement(new By.ByCssSelector("[class=\'modal-content\']"));

        // JavascriptExecutor executor = (JavascriptExecutor) driver;
        //   executor.executeScript("document.dispatchEvent(new KeyboardEvent('keydown', {'key': 'K'}));");
        //  executor.executeScript("document.dispatchEvent(new KeyboardEvent('keyup', {'key': 'K'}));");

        //action.sendKeys(Keys.chord(Keys.ARROW_DOWN)).perform();
        //   actions.sendKeys(Keys.ARROW_DOWN).perform();
        Actions act = new Actions(driver);
        //actions.keyDown(Keys.CONTROL).sendKeys("K").keyUp(Keys.CONTROL).perform();
        //  act.pause(1000).sendKeys("V").click(popup).perform();
        act.pause(1000).sendKeys(Keys.F5).perform();


        try {
            if (saveIdentityButtonFind().isDisplayed() && saveIdentityButtonFind().isEnabled()) {
                System.out.println("Buton mevcut ve etkin (tıklanabilir) durumda.");

                saveIdentityButtonFind().click();
            } else {
                System.out.println("tıklanamaz");
            }
        } catch (Exception e) {
            System.out.println("hataaa");
            Log.error("kimlik kaydedilemedi:" + e.getMessage());
        }
    }


}
