package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable
import utils.XlsxWriter
import java.util.ArrayList
import java.util.List

public class Xlsx {
	/*
	 * write file to specific path
	 * */
	@Keyword
	def static void writeToXlsx(String[] headers, List<String[]> data, String filePath=null) {
		/*
		 *sample definition:
		 String[] headers1 = ["deleted_keys","code","error message"];
		 List<String[]> list = new ArrayList<>();
		 list.add(["as","200","the server is ok"] as String[]);
		 list.add(["res","500","server down"] as String[]);
		 * */	
		if(filePath == null) {
			filePath = "Reports/result.xlsx"
		}
		try {
			XlsxWriter.writeToXlsx(filePath, headers, data);
			KeywordUtil.markPassed("write file to 'Reports/result.xlsx' susccessfully")
		}catch (IOException e) {
			System.err.println("write file error: " + e.getMessage());
			KeywordUtil.markFailed('"write file error: " + e.getMessage()')
			e.printStackTrace();
		}
	}
}
