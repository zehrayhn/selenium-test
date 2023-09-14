package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

        //Add chrome switch to disable notification - "**--disable-notifications**"
        options.addArguments("use-fake-ui-for-media-stream");
        driver = new ChromeDriver(options);
        //driver.get("https://test.qulak.com/");
        driver.get("https://demo.qulakexam.com/");// Örnek olarak 10 saniye bekleme süresi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //Cookie cookie = new Cookie("qulak_exam_demo_session", "eyJpdiI6ImV3N1Awa20wcFlqNXZjTmJOaDh2SWc9PSIsInZhbHVlIjoibk9SZ3J5VXhYUmF3TlV3SmFpYXlqT2c3ajdlM1JiN1IzU0U3ZklVQjVkVTlWWnI0dGltay9rWGZTU3UvUGRSdEZyTVZzdmd2dlZHQTNLcVp5L3dLT09HVmNzSWViNWJrNjhlUHpTWnkvcm5sWkhlZGpreXlyN1JMaVZEVHhvWnUiLCJtYWMiOiIzMzQ1MGYwZDQ2MTFlOWExOTFkN2QxMWEzNjZjYjVlY2MwMjNkOTI3Y2FlOGU5ZGRjMDk4Y2ZjOWIwYTU3MGI4IiwidGFnIjoiIn0%3D");
        // driver.manage().addCookie(cookie);
      //  String logFilePath = LogFilePathHelper.getLogFilePath();
        Log.info("hello");

        driver.navigate().refresh();
        //  startPage=new StartPage(driver);
        //Assert.assertTrue(startPage.isDisplayed());
        // startPage.registerClick();

    }




    //@AfterTest
    //  public static void tearDown(){
    //    driver.quit();
    //  }
}
