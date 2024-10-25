package com.tripillar.filehandling.excel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFile {
    private static final String FILE_NAME = "data.xlsx";

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        default:
                            System.out.print("Unknown Value" + "\t");
                    }
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Error reading Excel file.");
            e.printStackTrace();
        }
    }
}

