package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Test_Register extends BaseTest {

    RegistrationFormPage registerPage;
    MandatoryPermitsPage mandatoryPermitsPage;
    PhotoShootPage photoShootPage;
    EmailHelperPage emailHelperPage;
    ExcelDataReader excelDataReader;
    HomePage homePage;


    @Test(priority = 1)
    public void fill_Out_Registration_Form() {
        startPage = new StartPage(driver);
        startPage.clickRegister();
        registerPage = new RegistrationFormPage(driver);
        emailHelperPage = new EmailHelperPage();
        excelDataReader = new ExcelDataReader("Data/register.xlsx");
        String firstName = excelDataReader.getCellValue(1, 0);
        String lastName = excelDataReader.getCellValue(1, 1);
        String identity = excelDataReader.getCellValue(1, 2);
        String mobile = excelDataReader.getCellValue(1, 3);
        String dateOfBirth = excelDataReader.getCellValue(1, 5);
        String gender = excelDataReader.getCellValue(1, 6);
        String address = excelDataReader.getCellValue(1, 7);
        String password = excelDataReader.getCellValue(1, 8);
        String passwordConfirmation = excelDataReader.getCellValue(1, 9);
        String timePeriod = excelDataReader.getCellValue(1, 10);
        String randomEmail = excelDataReader.rowToUpdate(1, 4);
        excelDataReader.close();

        registerPage.fillAllFields(firstName, lastName, identity, mobile, randomEmail, dateOfBirth, gender, address, password, passwordConfirmation, timePeriod);
        registerPage.clickConfirmButton();

        mandatoryPermitsPage = new MandatoryPermitsPage(driver);
        String actualFullName = firstName + " " + lastName;
        String expectedName = mandatoryPermitsPage.getExpectedName();

        Assert.assertEquals(actualFullName, expectedName, "Ad ve soyad bilgileri yanlış");
        if (actualFullName.equals(expectedName)) {
            System.out.println("Kayıt işlemi başarılı \nAd ve soyad bilgileri doğru."); // Başarılı olduğunda konsola mesaj yazdırılır
        }

    }

    @Test(priority = 2)
    public void allow_Mandatory_Permissions() {
        mandatoryPermitsPage = new MandatoryPermitsPage(driver);
        mandatoryPermitsPage.clickConfirmButton();
        photoShootPage = new PhotoShootPage(driver);
        boolean isSuccess = photoShootPage.isHeaderDisplayed();
        Assert.assertTrue(isSuccess);
        if (isSuccess) {
            System.out.println("Fotoğraf çekme adımına geçildi."); // Başarılı olduğunda konsola mesaj yazdırılır
        }

    }

    @Test(priority = 3)
    public void allow_Cookies() {

        photoShootPage = new PhotoShootPage(driver);

        photoShootPage.saveProfilePhoto();

        boolean isSuccess = photoShootPage.isIdentityHeaderDisplayed();
        Assert.assertTrue(isSuccess);
        if (isSuccess) {
            System.out.println("Kimlik adımına geçildi."); // Başarılı olduğunda konsola mesaj yazdırılır
        }

        photoShootPage.clickAddIdentity();
        try {
            photoShootPage.clickf7();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        photoShootPage.clickOnSaveIdentity();
        homePage=new HomePage(driver);

        boolean isOpened = homePage.isHeaderDisplayed();
        Assert.assertTrue(isOpened);
        if (isSuccess) {
            System.out.println("Kimlik adımına geçildi."); // Başarılı olduğunda konsola mesaj yazdırılır
        }
    }


}
