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
    private static final Logger logger = LogManager.getLogger(PhotoShootPage.class);
    private CookieHelper cookieHelper;
    public PhotoShootPage(WebDriver driver){
        super(driver);
        this.cookieHelper = new CookieHelper(driver);
    }
    By photoShootPageHeaderLocator=new By.ByCssSelector("[class=\'sectionTitle textCenter\']");

    By addPhotoButtonLocator=new By.ByCssSelector("[class=\'btn btn-success btm-lg btnRounded btnAgree\']");

    By savePhotoButtonLocator=new By.ByCssSelector("[class=\'btn btnRounded btn-success btn-lg btnFont\']");

    By addIdentityButtonLocator=new By.ByCssSelector("#dashboardMainContent > div > div.dashboardContentMain > div > div > div");

    By saveIdentityButtonLocator=new By.ByCssSelector("[class=\'btn btn-success btm-lg btnRounded btnAgree\']");

    public WebElement photoShootPageHeaderFind(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(photoShootPageHeaderLocator));
    }
    public boolean isDisplayed(){
        return photoShootPageHeaderFind().isDisplayed();
    }
    public void cameraCookieHelper() {
        // CookieHelper'ı kullanarak çerez ekleyin
        cookieHelper.addCookie("qulak_exam_demo_session", "eyJpdiI6ImV3N1Awa20wcFlqNXZjTmJOaDh2SWc9PSIsInZhbHVlIjoibk9SZ3J5VXhYUmF3TlV3SmFpYXlqT2c3ajdlM1JiN1IzU0U3ZklVQjVkVTlWWnI0dGltay9rWGZTU3UvUGRSdEZyTVZzdmd2dlZHQTNLcVp5L3dLT09HVmNzSWViNWJrNjhlUHpTWnkvcm5sWkhlZGpreXlyN1JMaVZEVHhvWnUiLCJtYWMiOiIzMzQ1MGYwZDQ2MTFlOWExOTFkN2QxMWEzNjZjYjVlY2MwMjNkOTI3Y2FlOGU5ZGRjMDk4Y2ZjOWIwYTU3MGI4IiwidGFnIjoiIn0%3D");

        // CookieHelper'ı kullanarak çerez değerini kontrol edin
        boolean isPermissionGranted = cookieHelper.isCookieValueEqual("qulak_exam_demo_session", "eyJpdiI6ImV3N1Awa20wcFlqNXZjTmJOaDh2SWc9PSIsInZhbHVlIjoibk9SZ3J5VXhYUmF3TlV3SmFpYXlqT2c3ajdlM1JiN1IzU0U3ZklVQjVkVTlWWnI0dGltay9rWGZTU3UvUGRSdEZyTVZzdmd2dlZHQTNLcVp5L3dLT09HVmNzSWViNWJrNjhlUHpTWnkvcm5sWkhlZGpreXlyN1JMaVZEVHhvWnUiLCJtYWMiOiIzMzQ1MGYwZDQ2MTFlOWExOTFkN2QxMWEzNjZjYjVlY2MwMjNkOTI3Y2FlOGU5ZGRjMDk4Y2ZjOWIwYTU3MGI4IiwidGFnIjoiIn0%3D");
        if (isPermissionGranted) {
            System.out.println("Kamera izni verildi.");
        } else {
            System.out.println("Kamera izni verilmedi.");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    public WebElement addPhotoButtonFind(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(addPhotoButtonLocator));
    }

    public void addPhotoButtonClick(){

    }

    public WebElement addIdentityButtonFind(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        return wait.until(ExpectedConditions.elementToBeClickable(addIdentityButtonLocator));
    }

    public void addIdentityButtonClick(){
        addIdentityButtonFind().click();
    }



    public void cameracek(){
        String script = "navigator.mediaDevices.getUserMedia({ video: { width: 640, height: 480 }, audio: false })" +
                ".then(function(stream) {" +
                "  var video = document.createElement('video');" +
                "  document.body.appendChild(video);" +
                "  video.srcObject = stream;" +
                "  video.play();" +
                "});";
        ((JavascriptExecutor) driver).executeScript(script);

// Sayfada bir düğmeye tıkla
     //   WebElement captureButton = driver.findElement(By.id("captureButton"));
       // captureButton.click();

    }

    public void saveProfilePhoto(){


        Actions action=new Actions(driver);
        action.moveToElement(addPhotoButtonFind()).click().perform();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        WebElement element= wait.until(ExpectedConditions.elementToBeClickable(savePhotoButtonLocator));
        element.click();
      //  driver.navigate().refresh();

    }

    public void saveIdentityPhoto(){

        Actions action = new Actions(driver);
     ///   actions.sendKeys("K").perform();
       // actions.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();


        addIdentityButtonFind().click();
        System.out.println("tıklama başarılı");
        action.sendKeys(Keys.chord(Keys.ARROW_DOWN )).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element= wait.until(ExpectedConditions.elementToBeClickable(saveIdentityButtonLocator));
        element.click();
        driver.navigate().refresh();

    }


}
