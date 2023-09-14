package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PhotoShootPage extends BasePage{
   ///private static final Logger logger = LogManager.getLogger(PhotoShootPage.class);
    Log log;
    private CookieHelper cookieHelper;
    public PhotoShootPage(WebDriver driver){
        super(driver);
        this.cookieHelper = new CookieHelper(driver);
    }
    By photoShootPageHeaderLocator=new By.ByCssSelector("[class=\'sectionTitle textCenter\']");

    By addPhotoButtonLocator=new By.ByCssSelector("[class=\'btn btn-success btm-lg btnRounded btnAgree\']");

    By savePhotoButtonLocator=new By.ByCssSelector("[class=\'btn btnRounded btn-success btn-lg btnFont\']");

    By addIdentityButtonLocator=new By.ByCssSelector("[class=\'btn btn-success btm-lg btnRounded btnAgree\']");

    By saveIdentityButtonLocator=new By.ByCssSelector(".btnAgree:nth-child(1)");

    By identityHeaderLocator=new By.ByCssSelector("[class=\'sectionTitle textCenter\']");



    public WebElement photoShootPageHeaderFind(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(photoShootPageHeaderLocator));
    }
    public boolean isDisplayed(){
        return photoShootPageHeaderFind().isDisplayed();
    }

    public WebElement identityHeaderFind(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(identityHeaderLocator));
    }
    public boolean isIdentityHeaderDisplayed(){
        try{
        return identityHeaderFind().isDisplayed();}
        catch (Exception e){
            Log.error("hata mesajı displayed:" +e.getMessage());
            Log.info("hata mesajı veriyor");
            System.out.println(e.getMessage());
            return false;
        }

    }

    public WebElement addPhotoButtonFind(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(addPhotoButtonLocator));
    }
    public void addPhotoButtonClick(){

    }
    public WebElement addIdentityButtonFind(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
            return wait.until(ExpectedConditions.presenceOfElementLocated(addIdentityButtonLocator));
        } catch (TimeoutException e) {

            System.err.println("Element bulunamadı: " + e.getMessage());
            Log.error("Element bulunamıyor cunku: " +e.getMessage());
            return null;
        }
        catch (Exception er) {
            System.err.println("Exception Element bulunamadı: " + er.getMessage());
            Log.error("exception Element bulunamıyor cunku: " +er.getMessage());
            return null;
        }
    }
    public void addIdentityButtonClick(){
        Log.info("butona tıklama işlemi başlıyor");

        addIdentityButtonFind().click();
        Log.info("tıklandı");
        System.out.println("tıklama başarılı");
    }
    public void saveProfilePhoto(){

        //fotograf ekle işlemi
        Actions action=new Actions(driver);
        action.moveToElement(addPhotoButtonFind()).click().perform();

        //fotoğraf kaydetme işlemi
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        WebElement element= wait.until(ExpectedConditions.elementToBeClickable(savePhotoButtonLocator));
        element.click();
      //  driver.navigate().refresh();

    }
    public void saveIdentityPhoto(){


     ///   actions.sendKeys("K").perform();
       // actions.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

        //kimlikfotoğraf ekleme işlemi

      //  action.moveToElement(addIdentityButtonFind()).click().perform();
        if(isIdentityHeaderDisplayed())
        addIdentityButtonClick();
        else{

            System.out.println("if basarısız");
        }

        //Actions action = new Actions(driver);
        System.out.println("tıklama başarılı");
        //action.sendKeys(Keys.chord(Keys.ARROW_DOWN )).perform();

        //kimlikfotoğraf kaydetme işlemi
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        //WebElement element= wait.until(ExpectedConditions.elementToBeClickable(saveIdentityButtonLocator));
       // element.click();
       // driver.navigate().refresh();

    }


}
