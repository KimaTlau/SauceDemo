package com.saucedemo.utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataProvider {

    XSSFWorkbook wb;

    public ExcelDataProvider() {

        File src = new File("src/TestData/TestData.xlsx");

        try {
            FileInputStream fis = new FileInputStream(src);

            wb = new XSSFWorkbook(fis);
        } catch (IOException e) {
            System.out.println("Error in reading excel file" +e.getMessage());
        }
    }

    public String getStringData(String sheetName, int row, int col) {
        return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
    }

    public double getNumericData(String sheetName, int row, int col) {
        return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
    }
}
