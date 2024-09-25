package utils;
 
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class ExcelUtils {
    private Workbook workbook;
    private Sheet sheet;
 
    public ExcelUtils(String excelPath) throws IOException {
        FileInputStream inputStream = new FileInputStream(excelPath);
        workbook = new XSSFWorkbook(inputStream);
    }
 
    public String getCellData(String sheetName, int row, int column) {
        sheet = workbook.getSheet(sheetName);
        Row rowObj = sheet.getRow(row);
        return rowObj.getCell(column).getStringCellValue();
    }
 
    public int getRowCount(String sheetName) {
        return workbook.getSheet(sheetName).getPhysicalNumberOfRows();
    }
 
    public void setCellData(String sheetName, int row, int column, String value) {
        sheet = workbook.getSheet(sheetName);
        Row rowObj = sheet.getRow(row);
        rowObj.createCell(column).setCellValue(value);
    }
 
    public void save(String outputPath) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(outputPath);
        workbook.write(outputStream);
        outputStream.close();
    }
 
    public void closeWorkbook() throws IOException {
        workbook.close();
    }
}