package reusableComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	private XSSFWorkbook workbook;
	private XSSFSheet worksSheet;
	
	//public List<Map<String,String>>
	
	
	private XSSFWorkbook getWorkBookInstance(String excelFilePath) {
		
		if(workbook==null) {
		try {
			return new XSSFWorkbook(new FileInputStream(new File(excelFilePath)));
			
		} catch (EncryptedDocumentException e) {			
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		return workbook;		
	}
	
	private XSSFSheet getSheetByName(String sheetName) {
		return workbook.getSheet(sheetName);
	}
	
	public List<Map<String,String>> readDataFromExcel(String excelFilePath,String sheetName){
		workbook=getWorkBookInstance(excelFilePath);
		worksSheet=getSheetByName(sheetName);
		
		int totalRowsCount=worksSheet.getPhysicalNumberOfRows();
		List<Map<String,String>> excelRows= new ArrayList<Map<String,String>>();
		List<String> headersList= new ArrayList<>();
		
		//fetch all headers in list
		XSSFRow  headerRow=worksSheet.getRow(0);
		int cellCount=headerRow.getPhysicalNumberOfCells();
		
		for(int cellIndex=0;cellIndex<cellCount;cellIndex++) {
			XSSFCell  cell=headerRow.getCell(cellIndex);	
			headersList.add(cell.getStringCellValue());
		}
		//fetch cell corresponding to those headers
		for(int rowIndex=1;rowIndex<totalRowsCount;rowIndex++) {
			Map<String,String> keyValueMap= new HashMap<>();
			for(int columnIndex=0;columnIndex<headersList.size();columnIndex++) {				
				String cellValue=worksSheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();
				String cellHeader=headersList.get(columnIndex);
				keyValueMap.put(cellHeader, cellValue);
			}
			excelRows.add(keyValueMap);
		}
		return excelRows;		
	}

}
