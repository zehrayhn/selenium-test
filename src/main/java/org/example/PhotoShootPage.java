package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

public class PhotoShootPage extends BasePage {
    ///private static final Logger logger = LogManager.getLogger(PhotoShootPage.class);
    Log log;
    private CookieHelper cookieHelper;

    public PhotoShootPage(WebDriver driver) {
        super(driver);
        this.cookieHelper = new CookieHelper(driver);
    }
    By headerLocator = new By.ByCssSelector("[class=\'sectionTitle textCenter\']");
    By takePhotoButtonLocator = new By.ByCssSelector("[class=\'btn btn-success btm-lg btnRounded btnAgree\']");
    By savePhotoButtonLocator = new By.ByCssSelector("[class=\'btn btnRounded btn-success btn-lg btnFont\']");
    //By addIdentityButtonLocator=By.xpath("//*[@id=\'dashboardMainContent\']/div/div[4]/div/div/div/div[3]/button");
    //  By addIdentityButtonLocator=new By.ByCssSelector("[class=\'btn btn-success btm-lg btnRounded btnAgree\']");
    By addIdentityButtonLocator = new By.ByCssSelector("#dashboardMainContent > div > div.dashboardContentMain > div > div > div > div.activationSectionFooter.flexCenter.borderTop.paddingTop > button");
    By saveIdentityButtonLocator = new By.ByCssSelector(".btnAgree:nth-child(1)");
    By identityHeaderLocator = new By.ByCssSelector("[class=\'sectionTitle textCenter\']");
    public WebElement findHeader() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(headerLocator));
    }

    public boolean isHeaderDisplayed() {
        return findHeader().isDisplayed();
    }

    public WebElement findIdentityHeader() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(identityHeaderLocator));
    }

    public boolean isIdentityHeaderDisplayed() {
        try {
            return findIdentityHeader().isDisplayed();
        } catch (Exception e) {
            Log.error("hata mesajı displayed:" + e.getMessage());
            Log.info("hata mesajı veriyor");
            System.out.println(e.getMessage());
            return false;
        }

    }

    public WebElement findTakePhotoButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        return wait.until(ExpectedConditions.elementToBeClickable(takePhotoButtonLocator));
    }

    public WebElement findSavePhotoButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000000));
        return wait.until(ExpectedConditions.elementToBeClickable(savePhotoButtonLocator));
    }

    public WebElement findAddIdentityButton() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        return wait.until(ExpectedConditions.elementToBeClickable(saveIdentityButtonLocator));
    }


    public void saveProfilePhoto() {
        //fotograf çek işlemi
        findTakePhotoButton().click();

        //fotoğraf kayydet işlemi
        findSavePhotoButton().click();

    }

    public void clickf7() throws AWTException {

        // Java Robot'u başlatın
        Robot robot = new Robot();

        // F7 tuşuna basın
        try{
        robot.keyPress(KeyEvent.VK_F7);
        allowCookie();
        robot.keyRelease(KeyEvent.VK_F7);

        }
        catch (Exception e){
            Log.error("robot hata"+e.getMessage());
        }
    }

    public void allowCookie(){

        Set<Cookie> cookies = driver.manage().getCookies();

        // Çerezleri döngü içinde tek tek kabul edin
        for (Cookie cookie : cookies) {
            System.out.println("Çerez Adı: " + cookie.getName());
            System.out.println("Çerez Değeri: " + cookie.getValue());

            // Çerezi kabul etmek için:
            driver.manage().addCookie(cookie);
        }
    }
    public void clickAddIdentity() {

        //kimlikfotoğraf ekleme işlemi
        if (findTakePhotoButton().isDisplayed() && findTakePhotoButton().isEnabled()) {
            System.out.println("Buton mevcut ve etkin (tıklanabilir) durumda.");
            try {
                //  identity.click();
                findTakePhotoButton().click();
            } catch (Exception e) {
                Log.error("addPhotoFind butona tıklarken hata: " + e.getMessage());
            }
            findTakePhotoButton().click();

        } else {
            System.out.println("Buton etkin değil (tıklanamaz).");
        }

    }

    public void clickOnSaveIdentity() {

        try {
            if (findSavePhotoButton().isDisplayed() && findSavePhotoButton().isEnabled()) {
                System.out.println("Buton mevcut ve etkin (tıklanabilir) durumda.");

                findSavePhotoButton().click();

            } else {
                System.out.println("tıklanamaz");
            }
          //  saveIdentityButtonFind().click();
        } catch (Exception e) {
            System.out.println("hataaa");
            Log.error("kimlik kaydedilemedi:" + e.getMessage());
        }
    }


}
