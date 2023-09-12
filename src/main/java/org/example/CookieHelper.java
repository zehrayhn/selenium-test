package org.example;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookieHelper extends BasePage{

    public CookieHelper(WebDriver driver){
        super(driver);
    }

    public void addCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        driver.manage().addCookie(cookie);
    }

    public boolean isCookieValueEqual(String name, String expectedValue) {
        Cookie cookie = driver.manage().getCookieNamed(name); //verilen çereaz adının değerini beklenen değer ile karşılstırır
        if (cookie != null) {
            String actualValue = cookie.getValue();
            return actualValue.equals(expectedValue);
        }
        return false;
    }

}
