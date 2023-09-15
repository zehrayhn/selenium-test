package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;


@Listeners(TestListenerAdapter.class)
public class BaseTest {
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    BasePage basePage;
    static StartPage startPage;
    static WebDriver driver;



    @BeforeTest
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();


        options.addArguments("use-fake-ui-for-media-stream");
       driver = new ChromeDriver(options);
       // driver.get("https://test.qulak.com/");
        //System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe"); // Geckodriver'in yolunu ayarlayın

      //  FirefoxOptions options = new FirefoxOptions();
     //   options.addPreference("dom.webnotifications.enabled", false); // Bildirimleri devre dışı bırak

       // driver = new FirefoxDriver(options);


        driver.get("https://demo.qulakexam.com/");// Örnek olarak 10 saniye bekleme süresi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        Log.info("hello");

        driver.navigate().refresh();


    }




    //@AfterTest
    //  public static void tearDown(){
    //    driver.quit();
    //  }
}
