package utils;

import internal.GlobalVariable;
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint;
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase;
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData;
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject;
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject;

import com.kms.katalon.core.annotation.Keyword;
import com.kms.katalon.core.checkpoint.Checkpoint;
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords;
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords;
import com.kms.katalon.core.model.FailureHandling;
import com.kms.katalon.core.testcase.TestCase;
import com.kms.katalon.core.testdata.TestData;
import com.kms.katalon.core.testobject.TestObject;
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class XlsxWriter {
	/**
	 * write data to xlsx
	 * 
	 * @param filePath
	 * @param headers
	 * @param data
	 * @throws IOException
	 */
	public static void writeToXlsx(String filePath, String[] headers, List<String[]> data) throws IOException {

		File file = new File(filePath);
		Workbook workbook;
		Sheet sheet;

		if (file.exists()) {
			try (FileInputStream fis = new FileInputStream(file)) {
				workbook = new XSSFWorkbook(fis);
			}
			sheet = workbook.getSheet("Sheet1");
			if (sheet == null) {
				sheet = workbook.createSheet("Sheet1");
			}
			
			int lastRowNum = sheet.getLastRowNum();
			for (int i = 0; i < data.size(); i++) {
				Row dataRow = sheet.createRow(lastRowNum + i + 1);
				String[] rowData = data.get(i);
				for (int j = 0; j < rowData.length; j++) {
					Cell cell = dataRow.createCell(j);
					cell.setCellValue(rowData[j]);
				}
			}
			
			int columnCount = data.isEmpty() ? 0 : data.get(0).length;
			for (int i = 0; i < columnCount; i++) {
				sheet.autoSizeColumn(i);
			}
			
		} else {
			workbook = new XSSFWorkbook();
			sheet = workbook.createSheet("Sheet1");
			
			Row headerRow = sheet.createRow(0);
			for (int i = 0; i < headers.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(headers[i]);
			}

			for (int i = 0; i < data.size(); i++) {
				Row dataRow = sheet.createRow(i + 1);
				String[] rowData = data.get(i);
				for (int j = 0; j < rowData.length; j++) {
					Cell cell = dataRow.createCell(j);
					cell.setCellValue(rowData[j]);
				}
			}

			for (int i = 0; i < headers.length; i++) {
				sheet.autoSizeColumn(i);
			}
		}
		
		try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
			workbook.write(fileOut);
		} finally {
			workbook.close();
		}
	}
}
