package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataReader {
    private String excelFilePath;
    private FileInputStream fileInputStream;
    private Workbook workbook;
    private Sheet sheet;

    public ExcelDataReader(String excelFilePath) {
        this.excelFilePath = excelFilePath;
        try {
            fileInputStream = new FileInputStream(excelFilePath);
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheetAt(0); // ilk sayfa
        } catch (IOException e) {
            e.printStackTrace();
        } }

    public String getCellValue(int rowNumber, int cellNumber) {
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(cellNumber);
        return cell.toString();
    }

    public String rowToUpdate(int rowNumber, int cellNumber){
        EmailHelperPage emailHelperPage=new EmailHelperPage();
        String randomUsername = emailHelperPage.generateRandomUsername();
        String randomEmail = randomUsername + "@" + "gmail.com";
        Row rowToUpdate = sheet.getRow(rowNumber);
        Cell emailCell = rowToUpdate.getCell(cellNumber);
        emailCell.setCellValue(randomEmail);
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(cellNumber);
        return cell.toString();
    }

    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public void close() {
        try {
            fileInputStream.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
