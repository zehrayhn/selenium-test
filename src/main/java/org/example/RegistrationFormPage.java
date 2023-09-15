package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationFormPage extends BasePage {
    public RegistrationFormPage(WebDriver driver) {
        super(driver);
    }

    By registerHeaderLocator = new By.ByCssSelector("div.activationSectionTitle");
    By firstNameLocator = new By.ByCssSelector("[id=\'first_name\']");
    By lastNameLocator = new By.ByCssSelector("[id=\'last_name\']");
    By identityLocator = new By.ByCssSelector("[id=\'IDnumber\']");
    By mobileLocator = new By.ByCssSelector("[id=\'mobile\']");
    By emailLocator = new By.ByCssSelector("[id=\'email\']");
    By dateOfBirth = new By.ByCssSelector("[id=\'date_of_birth\']");
    By genderLocator = new By.ByCssSelector("[id=\'gender\']");
    By addressLocator = new By.ByCssSelector("[id=\'address\']");
    By passwordLocator = new By.ByCssSelector("[id=\'password\']");
    By passwordConfirmationLocator = new By.ByCssSelector("[id=\'password_confirmation\']");
    By successButtonLocator = new By.ByCssSelector(".btn-primary");

    By zamandilimiLocator = new By.ByCssSelector("[name=\'user_timezone\']");

    public WebElement registerHeaderFind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(registerHeaderLocator));
    }

    public boolean isDisplayed() {
        try {
            return registerHeaderFind().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement firstNameFind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.elementToBeClickable(firstNameLocator));
    }

    public boolean isFirstNameDisplayed() {
        try {
            return firstNameFind().isDisplayed();
        } catch (TimeoutException e) {
            return false;

        }
    }

    public WebElement lastNameFind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(lastNameLocator));
    }

    public boolean isLastNameDisplayed() {
        try {
            return lastNameFind().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement identityFind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(identityLocator));
    }

    public boolean isIdentityDisplayed() {
        try {
            return identityFind().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement mobileFind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(mobileLocator));
    }

    public boolean isMobileDisplayed() {
        try {
            return mobileFind().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement emailFind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(emailLocator));
    }

    public boolean isEmailDisplayed() {
        try {
            return emailFind().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement dateOfBirthFind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(dateOfBirth));
    }

    public boolean isdateOfBirthDisplayed() {
        try {
            return dateOfBirthFind().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement genderFind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(genderLocator));
    }

    public boolean isGenderDisplayed() {
        try {
            return genderFind().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement addressFind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(addressLocator));
    }

    public boolean isAddressDisplayed() {
        try {
            return addressFind().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement passwordFind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.elementToBeClickable(passwordLocator));
    }


    public boolean isPasswordDisplayed() {
        try {
            return passwordFind().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement passwordConfirmationFind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(passwordConfirmationLocator));
    }

    public boolean isPasswordConfirmationDisplayed() {
        try {
            return passwordConfirmationFind().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement buttonFind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(successButtonLocator));
    }

    public void buttonClick() {
        buttonFind().click();
    }

    public void firstNameType(String text) {
        WebElement firstNameElement = firstNameFind();
        if (firstNameElement.isDisplayed()) {
            firstNameElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("Ad alanı görünmez.");
        }
    }

    public void lastNameType(String text) {
        WebElement lastNameElement = lastNameFind();
        if (lastNameElement.isDisplayed()) {
            lastNameElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("soyad alanı görünmez.");
        }
    }

    public void identityType(String text) {
        WebElement identityElement = identityFind();
        if (identityElement.isDisplayed()) {
            identityElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("soyad alanı görünmez.");
        }
    }

    public void mobileType(String text) {
        WebElement mobileElement = mobileFind();
        if (mobileElement.isDisplayed()) {
            mobileElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("soyad alanı görünmez.");
        }
    }

    public void emailType(String text) {
        WebElement mobileElement = emailFind();
        if (mobileElement.isDisplayed()) {
            mobileElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("soyad alanı görünmez.");
        }
    }

    public void dateOfBirthType(String text) {
        WebElement dateOfBirthElement = dateOfBirthFind();
        if (dateOfBirthElement.isDisplayed()) {
            dateOfBirthElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("soyad alanı görünmez.");
        }
    }

    public void genderType(String text) {
        WebElement genderElement = genderFind();
        if (genderElement.isDisplayed()) {
            genderElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("soyad alanı görünmez.");
        }
    }

    public void addressType(String text) {
        WebElement addressElement = addressFind();
        if (addressElement.isDisplayed()) {
            addressElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("soyad alanı görünmez.");
        }
    }

    public void passwordType(String text) {
        WebElement passwordElement = passwordFind();
        if (passwordElement.isDisplayed()) {
            passwordElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("soyad alanı görünmez.");
        }
    }

    public void passwordConfirmationType(String text) {
        WebElement passwordConfirmationElement = passwordConfirmationFind();
        if (passwordConfirmationElement.isDisplayed()) {
            passwordConfirmationElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("soyad alanı görünmez.");
        }
    }

    public WebElement zamandilimiFind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(zamandilimiLocator));
    }

    public boolean iszamandiliimiDisplayed() {
        try {
            return zamandilimiFind().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void zamandilimiType(String text) {
        WebElement element = zamandilimiFind();
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }


    public boolean fillAllFields(String firstName, String lastName, String identity, String mobile, String email, String dateOfBirth, String gender, String address, String password, String passwordConfirmation, String zamandilimi) {
        boolean success = true; // Başlangıçta başarılı kabul edelim

        try {
            if (isFirstNameDisplayed()) {
                firstNameType(firstName);
            } else {
                System.out.println("Ad alanı görünmez.");
                success = false;
            }

            if (isLastNameDisplayed()) {
                lastNameType(lastName);
            } else {
                System.out.println("Soyad alanı görünmez.");
                success = false;
            }

            if (isEmailDisplayed()) {
                emailType(email);
            } else {
                System.out.println("E-posta alanı görünmez.");
                success = false;
            }
            if (isPasswordDisplayed()) {
                passwordType(password);
            } else {
                System.out.println("password alanı görünmez.");
                success = false;
            }
            if (isPasswordConfirmationDisplayed()) {
                passwordConfirmationType(passwordConfirmation);
            } else {
                System.out.println("password alanı görünmez.");
                success = false;
            }

            if (iszamandiliimiDisplayed()) {
                zamandilimiType(zamandilimi);
            } else {
                System.out.println("zamandiliimi alanı görünmez.");
                success = false;
            }

            if (isdateOfBirthDisplayed()) {
                dateOfBirthType(dateOfBirth);
            } else {
                System.out.println("Telefon numarası alanı görünmez.");
                success = false;
            }
            if (isGenderDisplayed()) {
                genderType(gender);
            } else {
                System.out.println("Cinsiyet alanı görünmez.");
                success = false;
            }
            if (isAddressDisplayed()) {
                addressType(address);
            } else {
                System.out.println("Adres alanı görünmez.");
                success = false;
            }


            if (isIdentityDisplayed()) {
                identityType(identity);
            } else {
                System.out.println("Kimlik numarası alanı görünmez.");
                success = false;
            }

            if (isMobileDisplayed()) {
                mobileType(mobile);
            } else {
                System.out.println("Telefon numarası alanı görünmez.");
                success = false;
            }


        } catch (org.openqa.selenium.NoSuchElementException e) {
            // NoSuchElementException hatası görmezden gelinir ve işlem devam eder
            System.out.println("Element bulunamadı.");
            success = false;
        }

        return success;
    }

    public boolean isRegistrationSuccessful() {
        return registerHeaderFind().isDisplayed();
    }


}
