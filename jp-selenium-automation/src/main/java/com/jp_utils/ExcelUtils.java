package com.jp_utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static String getCellData(String filePath,
                                     String sheetName,
                                     int rowNum,
                                     int colNum) {

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.out.println("Sheet not found: " + sheetName);
                return "";
            }

            Row row = sheet.getRow(rowNum);
            if (row == null) {
                System.out.println("Row not found: " + rowNum);
                return "";
            }

            Cell cell = row.getCell(colNum);
            if (cell == null) {
                System.out.println("Cell not found at column: " + colNum);
                return "";
            }

            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
