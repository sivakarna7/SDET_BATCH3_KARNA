package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import modules.TestData;

public class ExcelUtil {

	public int getRowCount() {
		int rowCount = TestData.sheet.getPhysicalNumberOfRows();
		return rowCount;
	}

	public int getColCount() {
		int colCount = TestData.sheet.getRow(0).getPhysicalNumberOfCells();
		return colCount;
	}

	public String getCellDataString1(int rowNum, int colNum) {
		String cellData = TestData.sheet.getRow(rowNum).getCell(colNum).toString();
		return cellData;
	}

	public String getCellDataString(int rowNum, int colNum) {
		// String cellData1 = TestData.sheet.getRow(rowNum).getCell(colNum).toString();
		DataFormatter dataFormatter = new DataFormatter();
		String cellData = dataFormatter.formatCellValue(TestData.sheet.getRow(rowNum).getCell(colNum));
		return cellData;
	}

	public double getCellDataNumeric(int rowNum, int colNum) {
		Double cellData = TestData.sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		return cellData;
	}

	public String[][] getExcelData(String FileName, String SheetName) {

		try {
			TestData.fis = new FileInputStream(new File(FileName));
			TestData.workbook = null;
			String ext = FileName.substring(FileName.indexOf("."));
			if (ext.equals(".xlsx"))
				TestData.workbook = new XSSFWorkbook(TestData.fis);
			else
				TestData.hworkbook = new HSSFWorkbook(TestData.fis);

			TestData.sheet = TestData.workbook.getSheet(SheetName);
			int rowcnt = TestData.sheet.getPhysicalNumberOfRows();
			System.out.println("Row Count:" + rowcnt);
			int colcnt = TestData.sheet.getRow(0).getLastCellNum();
			System.out.println("Column Count:" + colcnt);
			TestData.arrayExcelData = new String[rowcnt - 1][colcnt];

			for (int i = 1; i < rowcnt; i++)
				for (int j = 0; j < colcnt; j++) {
					// System.out.println(excel.getCellDataString(i, j));
					if (getCellDataString(i, j) == null) {
						TestData.arrayExcelData[i][j] = "";
					} else {
						String cellData = getCellDataString(i, j);
						TestData.arrayExcelData[i - 1][j] = cellData;
					}
				}
			TestData.workbook.close();
			TestData.fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
		return TestData.arrayExcelData;
	}

	public ArrayList<HashMap<String, String>> readInputs(String FileName, String SheetName) {

		//ArrayList<HashMap<String, String>> lst = new ArrayList<HashMap<String, String>>();

		try {
			TestData.fis = new FileInputStream(new File(FileName));
			TestData.workbook = null;
			String ext = FileName.substring(FileName.indexOf("."));
			if (ext.equals(".xlsx"))
				TestData.workbook = new XSSFWorkbook(TestData.fis);
			else
				TestData.hworkbook = new HSSFWorkbook(TestData.fis);

			TestData.sheet = TestData.workbook.getSheet(SheetName);
			int rowcnt = TestData.sheet.getPhysicalNumberOfRows();
			// System.out.println("Row Count:" + rowcnt);
			int colCnt = TestData.sheet.getRow(0).getLastCellNum();

			for (int i = 1; i < rowcnt; i++) {

				HashMap<String, String> hm = new HashMap<String, String>();
				for (int j = 0; j < colCnt; j++) {
					if (TestData.sheet.getRow(i).getCell(j) == null) {
						hm.put(TestData.sheet.getRow(0).getCell(j).toString(), "");
					} else {
						hm.put(TestData.sheet.getRow(0).getCell(j).toString(),
								TestData.sheet.getRow(i).getCell(j).toString());
					}
				}
				TestData.hmInput.add(hm);
			}
			TestData.workbook.close();
			TestData.fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TestData.hmInput;
	}

	public void writeData(String FileName, String SheetName, ArrayList<HashMap<String, String>> lst) {

		try {
			TestData.file = new File(FileName);
			TestData.fis = new FileInputStream(TestData.file);
			String fileExtensionName = FileName.substring(FileName.indexOf("."));
			TestData.workbook = null;
			if (fileExtensionName.equals(".xlsx"))
				TestData.workbook = new XSSFWorkbook(TestData.fis);
			else if (fileExtensionName.equals(".xls"))
				TestData.hworkbook = new HSSFWorkbook(TestData.fis);

			TestData.sheet = TestData.workbook.getSheet(SheetName);

			for (int i = 0; i < lst.size(); i++) {
				Row rw = TestData.sheet.createRow(i);
				HashMap<String, String> hm = lst.get(i);

				int col = 0;
				for (String k : hm.keySet()) {

					rw.createCell(col).setCellValue(hm.get(k));
					col = col + 1;
				}
			}

			TestData.fis.close();

			TestData.fos = new FileOutputStream(TestData.file);
			TestData.workbook.write(TestData.fos);
			TestData.workbook.close();
			TestData.fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}