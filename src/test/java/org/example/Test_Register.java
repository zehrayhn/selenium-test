package org.example;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

public class Test_Register extends BaseTest{

    RegisterPage registerPage;

    MandatoryPermitsPage mandatoryPermitsPage;

    PhotoShootPage photoShootPage;


    @Test(priority = 1)
    public void go_to_Register(){
        startPage=new StartPage(driver);
    //    Assert.assertTrue(startPage.isDisplayed());
        startPage.registerClick();
        registerPage=new RegisterPage(driver);
      //  Assert.assertTrue(registerPage.isDisplayed());

        try {
            FileInputStream file = new FileInputStream("Data/register.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Row firstRow = sheet.getRow(1);
            int cellCount = firstRow.getLastCellNum();

            // Verileri Excel'den okuduktan sonra
            String firstName = firstRow.getCell(0).getStringCellValue();
            String lastName = firstRow.getCell(1).getStringCellValue();
            double identityNumeric = firstRow.getCell(2).getNumericCellValue();
            String identity = String.valueOf(identityNumeric);

            double mobileNumeric = firstRow.getCell(3).getNumericCellValue();
            String mobile = String.valueOf(mobileNumeric);
            String email = firstRow.getCell(4).getStringCellValue();
            double dateOfBirthNumeric = firstRow.getCell(5).getNumericCellValue();
            String dateOfBirth = String.valueOf(dateOfBirthNumeric);
            String gender = firstRow.getCell(6).getStringCellValue();
            String address = firstRow.getCell(7).getStringCellValue();
            String password = firstRow.getCell(8).getStringCellValue();
            String passwordConfirmation = firstRow.getCell(9).getStringCellValue();
            String zamandilimi=firstRow.getCell(10).getStringCellValue();

            registerPage.fillAllFields(firstName, lastName, identity, mobile, email, dateOfBirth, gender, address, password, passwordConfirmation,zamandilimi);
            registerPage.buttonClick();
          //  boolean isSuccess = registerPage.isRegistrationSuccessful();
           // Assert.assertTrue(isSuccess, "Kayıt işlemi başarılı değil.");
         //   if (isSuccess) {
          //      System.out.println("Kayıt işlemi başarılı."); // Başarılı olduğunda konsola mesaj yazdırılır
        //    }

            mandatoryPermitsPage=new MandatoryPermitsPage(driver);
            String actualFullName = firstName + " " + lastName;
            String expectedName = mandatoryPermitsPage.getExpectedName();

            Assert.assertEquals(actualFullName, expectedName, "Ad ve soyad bilgileri yanlış");
            if (actualFullName.equals(expectedName)) {
                System.out.println("Kayıt işlemi başarılı \nAd ve soyad bilgileri doğru."); // Başarılı olduğunda konsola mesaj yazdırılır
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

     @Test(priority = 2)
     public void allow_Mandatory_Permissions(){
        mandatoryPermitsPage=new MandatoryPermitsPage(driver);
        mandatoryPermitsPage.successButtonClick();
        photoShootPage=new PhotoShootPage(driver);
        boolean isSuccess=photoShootPage.isDisplayed();
        Assert.assertTrue(isSuccess);
         if (isSuccess) {
             System.out.println("Fotoğraf çekme adımına geçildi."); // Başarılı olduğunda konsola mesaj yazdırılır
         }

    }

    @Test(priority = 3)
    public void allow_Cookies(){

        photoShootPage=new PhotoShootPage(driver);

      //  photoShootPage.cameracek();


     //   photoShootPage.cameraCookieHelper();
     //   photoShootPage.addPhotoButtonClick();
        photoShootPage.saveProfilePhoto();
        // photoShootPage.addIdentityButtonClick();
         photoShootPage.saveIdentityPhoto();
       // photoShootPage.savePhoto();

       // Set< Cookie> cookies=driver.manage().getCookies();
       // System.out.println("cookie ssayısı: "+cookies.size());

       // for(Cookie cookie:cookies){
         //   System.out.println(cookie.getName()+":"+cookie.getValue());
        //}

    }






}
