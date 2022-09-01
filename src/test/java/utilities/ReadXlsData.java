package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadXlsData {

	public static String projectDirectory = System.getProperty("user.dir");
	
	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException {
		ReadXlsData xlsData = new ReadXlsData();
		// Provide the name of the sheet in the .xls file you want to get the data from
		xlsData.getData("login");
	}
	
	// Create an object (String array) to store data from .xls sheet.
	// Get data, pass in name of excel file
	private String[][] getData(String excelSheetName) throws 
		EncryptedDocumentException, FileNotFoundException, IOException {
			// Create file object 
			File file = new File(projectDirectory + "/src/test/resources/testdata/LoginTestData.xlsx");
			// Read in the file
			FileInputStream stream = new FileInputStream(file);
			// Create workbook object from file stream
			Workbook wb = WorkbookFactory.create(stream);
			// Create a an object like the xlsx sheet 
			Sheet sheet = wb.getSheet(excelSheetName);
			// Calculate how many rows there are
			int totalRows = sheet.getLastRowNum();
			System.out.println("TOTAL ROWS: " + totalRows);
			// Get a count of how many cells are in a row
			Row rowCells =  sheet.getRow(0);
			// Store the total number of cells 
			int totalCols = rowCells.getLastCellNum();
			System.out.println("TOTAL COLS: " + totalCols);
			
			DataFormatter format = new DataFormatter();
			// Create a 2D string array the size of the spread sheet to hold the data
			String testData[][] = new String[totalRows][totalCols];
			
			// Loop through the rows and format a testData object
			// Start on row 1 because row 0 is the header with the column names
			// Create the testData object beginning on row 0  because we are removing the headers of the columns
			for(int i=1; i<=totalRows; i++) {
				for(int j=0; j<totalCols; j++) {
					// Get the row and the cell and store that value in the testData object.
					testData[i-1][j] = format.formatCellValue(sheet.getRow(i).getCell(j));
					// Print out each cell
					System.out.println(testData[i-1][j]);
				}
			}
			
			return testData;
			
	}
}
