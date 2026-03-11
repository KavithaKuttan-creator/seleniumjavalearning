package Utils;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static String ExcelSheetAccess(String fileName,String sheetName,int row,int col) throws Exception{
		XSSFWorkbook workbook;
	    XSSFSheet sheet;
	
		FileInputStream fis = new FileInputStream(fileName);
		workbook= new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
        String value = sheet.getRow(row).getCell(col).toString();
        workbook.close();
        return value;
	    }
}