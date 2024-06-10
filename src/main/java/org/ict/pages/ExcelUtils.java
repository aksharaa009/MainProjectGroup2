package org.ict.pages;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.text.DecimalFormat;

public class ExcelUtils {

    private Workbook workbook;
    private Sheet sheet;

    public ExcelUtils(String filePath, String sheetName) {
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCellData(int rowNumber, int colNumber) {
        Row row = sheet.getRow(rowNumber);
        if (row == null) {
            return "";  // Return an empty string or handle it as needed
        }
        Cell cell = row.getCell(colNumber);
        if (cell == null) {
            return "";  // Return an empty string or handle it as needed
        }
        return cell.toString().trim(); // Trim the cell value to remove leading/trailing spaces
    }

    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public int getColumnCount() {
        Row row = sheet.getRow(0);
        if (row == null) {
            return 0;  // If the first row is null, return 0
        }
        return row.getPhysicalNumberOfCells();
    }
    
    public  String getCellData(int sheetIndex, int rowIndex, int colIndex) {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row row = sheet.getRow(rowIndex);
        Cell cell = row.getCell(colIndex);

        if (cell.getCellType() == CellType.NUMERIC) {
            // Use DecimalFormat to avoid scientific notation
            DecimalFormat df = new DecimalFormat("#");
            return df.format(cell.getNumericCellValue());
        } else if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else {
            return "";
        }
    }

    public void close() {
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}