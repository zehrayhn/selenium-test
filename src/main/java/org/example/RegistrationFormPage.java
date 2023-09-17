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

    By headerLocator = new By.ByCssSelector("div.activationSectionTitle");
    By firstNameLocator = new By.ByCssSelector("[id=\'first_name\']");
    By lastNameLocator = new By.ByCssSelector("[id=\'last_name\']");
    By identityLocator = new By.ByCssSelector("[id=\'IDnumber\']");
    By mobileLocator = new By.ByCssSelector("[id=\'mobile\']");
    By emailLocator = new By.ByCssSelector("[id=\'email\']");
    By dateOfBirthLocator = new By.ByCssSelector("[id=\'date_of_birth\']");
    By genderLocator = new By.ByCssSelector("[id=\'gender\']");
    By addressLocator = new By.ByCssSelector("[id=\'address\']");
    By passwordLocator = new By.ByCssSelector("[id=\'password\']");
    By passwordConfirmationLocator = new By.ByCssSelector("[id=\'password_confirmation\']");
    By confirmButtonLocator = new By.ByCssSelector(".btn-primary");
    By timePeriodLocator = new By.ByCssSelector("[name=\'user_timezone\']");

    public WebElement findHeader() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(headerLocator));
    }

    public boolean isHeaderDisplayed() {
        try {
            return findHeader().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement findFirstName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.elementToBeClickable(firstNameLocator));
    }

    public boolean isFirstNameDisplayed() {
        try {
            return findFirstName().isDisplayed();
        } catch (TimeoutException e) {
            return false;

        }
    }

    public WebElement findLastName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(lastNameLocator));
    }

    public boolean isLastNameDisplayed() {
        try {
            return findLastName().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement findIdentity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(identityLocator));
    }

    public boolean isIdentityDisplayed() {
        try {
            return findIdentity().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement findMobile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(mobileLocator));
    }

    public boolean isMobileDisplayed() {
        try {
            return findMobile().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement findEmail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(emailLocator));
    }

    public boolean isEmailDisplayed() {
        try {
            return findEmail().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement findDateOfBirth() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(dateOfBirthLocator));
    }

    public boolean isdateOfBirthDisplayed() {
        try {
            return findDateOfBirth().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement findGender() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(genderLocator));
    }

    public boolean isGenderDisplayed() {
        try {
            return findGender().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement findAddress() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(addressLocator));
    }

    public boolean isAddressDisplayed() {
        try {
            return findAddress().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement findPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.elementToBeClickable(passwordLocator));
    }


    public boolean isPasswordDisplayed() {
        try {
            return findPassword().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement findPasswordConfirmation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(passwordConfirmationLocator));
    }

    public boolean isPasswordConfirmationDisplayed() {
        try {
            return findPasswordConfirmation().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement findConfirmButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(confirmButtonLocator));
    }

    public WebElement findTimePeriod() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(timePeriodLocator));
    }
    public void clickConfirmButton() {
        findConfirmButton().click();
    }

    public void enterFirstName(String text) {
        WebElement firstNameElement = findFirstName();
        if (firstNameElement.isDisplayed()) {
            firstNameElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("Ad alanı görünmez.");
        }
    }

    public void enterLastName(String text) {
        WebElement lastNameElement = findLastName();
        if (lastNameElement.isDisplayed()) {
            lastNameElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("soyad alanı görünmez.");
        }
    }

    public void enterIdentity(String text) {
        WebElement identityElement = findIdentity();
        if (identityElement.isDisplayed()) {
            identityElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("soyad alanı görünmez.");
        }
    }

    public void enterMobile(String text) {
        WebElement mobileElement = findMobile();
        if (mobileElement.isDisplayed()) {
            mobileElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("soyad alanı görünmez.");
        }
    }

    public void enterEmail(String text) {
        WebElement mobileElement = findEmail();
        if (mobileElement.isDisplayed()) {
            mobileElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("soyad alanı görünmez.");
        }
    }

    public void enterDateOfBirth(String text) {
        WebElement dateOfBirthElement = findDateOfBirth();
        if (dateOfBirthElement.isDisplayed()) {
            dateOfBirthElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("soyad alanı görünmez.");
        }
    }

    public void enterGender(String text) {
        WebElement genderElement = findGender();
        if (genderElement.isDisplayed()) {
            genderElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("soyad alanı görünmez.");
        }
    }

    public void enterAddress(String text) {
        WebElement addressElement = findAddress();
        if (addressElement.isDisplayed()) {
            addressElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("soyad alanı görünmez.");
        }
    }

    public void enterPassword(String text) {
        WebElement passwordElement = findPassword();
        if (passwordElement.isDisplayed()) {
            passwordElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("soyad alanı görünmez.");
        }
    }

    public void enterPasswordConfirmation(String text) {
        WebElement passwordConfirmationElement = findPasswordConfirmation();
        if (passwordConfirmationElement.isDisplayed()) {
            passwordConfirmationElement.sendKeys(text);
        } else {
            // Eğer ad alanı görünmezse bir hata veya uyarı mesajı yazdırabilirsiniz.
            System.out.println("soyad alanı görünmez.");
        }
    }



    public boolean iszamandiliimiDisplayed() {
        try {
            return findTimePeriod().isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void enterTimePeriod(String text) {
        WebElement element = findTimePeriod();
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }


    public boolean fillAllFields(String firstName, String lastName, String identity, String mobile, String email, String dateOfBirth, String gender, String address, String password, String passwordConfirmation, String zamandilimi) {
        boolean success = true; // Başlangıçta başarılı kabul edelim

        try {
            if (isFirstNameDisplayed()) {
                enterFirstName(firstName);
            } else {
                System.out.println("Ad alanı görünmez.");
                success = false;
            }

            if (isLastNameDisplayed()) {
                enterLastName(lastName);
            } else {
                System.out.println("Soyad alanı görünmez.");
                success = false;
            }

            if (isEmailDisplayed()) {
                enterEmail(email);
            } else {
                System.out.println("E-posta alanı görünmez.");
                success = false;
            }
            if (isPasswordDisplayed()) {
                enterPassword(password);
            } else {
                System.out.println("password alanı görünmez.");
                success = false;
            }
            if (isPasswordConfirmationDisplayed()) {
                enterPasswordConfirmation(passwordConfirmation);
            } else {
                System.out.println("password alanı görünmez.");
                success = false;
            }

            if (iszamandiliimiDisplayed()) {
                enterTimePeriod(zamandilimi);
            } else {
                System.out.println("zamandiliimi alanı görünmez.");
                success = false;
            }

            if (isdateOfBirthDisplayed()) {
                enterDateOfBirth(dateOfBirth);
            } else {
                System.out.println("Telefon numarası alanı görünmez.");
                success = false;
            }
            if (isGenderDisplayed()) {
                enterGender(gender);
            } else {
                System.out.println("Cinsiyet alanı görünmez.");
                success = false;
            }
            if (isAddressDisplayed()) {
                enterAddress(address);
            } else {
                System.out.println("Adres alanı görünmez.");
                success = false;
            }


            if (isIdentityDisplayed()) {
                enterIdentity(identity);
            } else {
                System.out.println("Kimlik numarası alanı görünmez.");
                success = false;
            }

            if (isMobileDisplayed()) {
                enterMobile(mobile);
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


}
