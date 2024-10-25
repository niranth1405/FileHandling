package com.tripillar.filehandling.excel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelFile {
    private static final String FILE_NAME = "data.xlsx";

    public static void main(String[] args) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sample Data");

        // Create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Name");
        header.createCell(2).setCellValue("Age");

        // Add sample data
        Object[][] data = {
                {1, "John Doe", 25},
                {2, "Jane Smith", 30},
                {3, "Emily Johnson", 22}
        };

        int rowNum = 1;
        for (Object[] rowData : data) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : rowData) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream(FILE_NAME)) {
            workbook.write(outputStream);
            System.out.println("Excel file created successfully.");
        } catch (IOException e) {
            System.out.println("Error writing Excel file.");
            e.printStackTrace();
        }
    }
}

