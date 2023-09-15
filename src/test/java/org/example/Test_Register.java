package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test_Register extends BaseTest {

    RegistrationFormPage registerPage;
    MandatoryPermitsPage mandatoryPermitsPage;
    PhotoShootPage photoShootPage;
    EmailHelperPage emailHelperPage;


    @Test(priority = 1)
    public void go_to_Register() {
        startPage = new StartPage(driver);
        startPage.clickRegister();
        registerPage = new RegistrationFormPage(driver);
        //  Assert.assertTrue(registerPage.isDisplayed());
        emailHelperPage = new EmailHelperPage();


        try {
            FileInputStream file = new FileInputStream("Data/register.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Row firstRow = sheet.getRow(1);
            int cellCount = firstRow.getLastCellNum();

            // Verileri Excel'den okuduktan sonra
            String firstName = firstRow.getCell(0).getStringCellValue();
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.CONTROL).sendKeys("K").keyUp(Keys.CONTROL).perform();
            String lastName = firstRow.getCell(1).getStringCellValue();
            double identityNumeric = firstRow.getCell(2).getNumericCellValue();
            String identity = String.valueOf(identityNumeric);

            double mobileNumeric = firstRow.getCell(3).getNumericCellValue();
            String mobile = String.valueOf(mobileNumeric);
            // String email = firstRow.getCell(4).getStringCellValue();
            double dateOfBirthNumeric = firstRow.getCell(5).getNumericCellValue();
            String dateOfBirth = String.valueOf(dateOfBirthNumeric);
            String gender = firstRow.getCell(6).getStringCellValue();
            String address = firstRow.getCell(7).getStringCellValue();
            String password = firstRow.getCell(8).getStringCellValue();
            String passwordConfirmation = firstRow.getCell(9).getStringCellValue();
            String zamandilimi = firstRow.getCell(10).getStringCellValue();

            String randomUsername = emailHelperPage.generateRandomUsername();
            String randomEmail = randomUsername + "@" + "gmail.com";
            Row rowToUpdate = sheet.getRow(1);
            Cell emailCell = rowToUpdate.getCell(4);
            emailCell.setCellValue(randomEmail);
            FileOutputStream outFile = new FileOutputStream("Data/register.xlsx");
            workbook.write(outFile);

            registerPage.fillAllFields(firstName, lastName, identity, mobile, randomEmail, dateOfBirth, gender, address, password, passwordConfirmation, zamandilimi);
            registerPage.buttonClick();
            //  boolean isSuccess = registerPage.isRegistrationSuccessful();
            // Assert.assertTrue(isSuccess, "Kayıt işlemi başarılı değil.");
            //   if (isSuccess) {
            //      System.out.println("Kayıt işlemi başarılı."); // Başarılı olduğunda konsola mesaj yazdırılır
            //    }

            mandatoryPermitsPage = new MandatoryPermitsPage(driver);
            String actualFullName = firstName + " " + lastName;
            String expectedName = mandatoryPermitsPage.getExpectedName();

            Assert.assertEquals(actualFullName, expectedName, "Ad ve soyad bilgileri yanlış");
            if (actualFullName.equals(expectedName)) {
                System.out.println("Kayıt işlemi başarılı \nAd ve soyad bilgileri doğru."); // Başarılı olduğunda konsola mesaj yazdırılır
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void allow_Mandatory_Permissions() {
        mandatoryPermitsPage = new MandatoryPermitsPage(driver);
        mandatoryPermitsPage.successButtonClick();
        photoShootPage = new PhotoShootPage(driver);
        boolean isSuccess = photoShootPage.isDisplayed();
        Assert.assertTrue(isSuccess);
        if (isSuccess) {
            System.out.println("Fotoğraf çekme adımına geçildi."); // Başarılı olduğunda konsola mesaj yazdırılır
        }

    }

    @Test(priority = 3)
    public void allow_Cookies() {

        photoShootPage = new PhotoShootPage(driver);

        photoShootPage.saveProfilePhoto();
        //photoShootPage.addIdentityButtonClick();



       // Set <Cookie> cookies=driver.manage().getCookies();
        //System.out.println("sayı: "+cookies.size());

       // for(Cookie cookie:cookies){
        //    System.out.println(cookie.getName()+":"+cookie.getValue());
      //  }

        photoShootPage.identityPhotoMove();
        try{
            photoShootPage.clickf7();
        }catch (AWTException e){
            throw  new RuntimeException(e);
        }
        photoShootPage.saveIdentityPhoto();

    }


}
