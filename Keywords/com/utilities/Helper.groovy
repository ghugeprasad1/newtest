package com.utilities
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.assertj.core.api.Assertions.catchNullPointerException

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import java.text.SimpleDateFormat
import java.util.Date

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import java.io.File

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys

public class Helper {

	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}

	@Keyword
	public void writecsv (String filePath, String first_name, String last_name, String date_of_birth, String phone_number, String street, String city_name, String state, String zip_code) throws IOException {

		File file = new File(filePath);
		//		FileWriter outputfile = new FileWriter(file);
		//	    CSVWriter writer = new CSVWriter(outputfile);
		//	  	String[] data1 = { first_name,last_name,date_of_birth,phone_number,street,city_name,state,zip_code };
		//		List<String[]> data = new ArrayList<String[]>();
		//		data.add(new String[] { "Name", "Class", "Marks" });
		//		data.add(new String[] { "Aman", "10", "620" })
		//		writer.writeNext(data);
		//		writer.close();
		def data = [
			first_name,
			last_name,
			date_of_birth,
			phone_number,
			street,
			city_name,
			state,
			zip_code
		]
		file.withWriter { w ->
			//			new CSVWriter(w).writeAll(data.collect{ it as String[] })
		}
	}

	@Keyword
	boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		String lastAttempt = '';
		if (dirContents.length > 0) {
			for (int i = 0; i < dirContents.length; i++) {
				if (dirContents[i].getName().startsWith(fileName)) {
					// File has been found, it can now be deleted:
					dirContents[i].delete();
					KeywordUtil.markPassed(fileName + ' exist in ' + downloadPath + ' and was deleted')
					return true;
				}
				lastAttempt = dirContents[i].getName().startsWith(fileName);
			}
			if (lastAttempt != fileName) {
				KeywordUtil.markFailed(fileName + ' does not exist in ' + downloadPath)
				return false;
			}
		}
		return false;
	}

	@Keyword
	def fillTheDateField(TestObject inputField) {
		WebUI.click(inputField);

		WebUI.sendKeys(inputField, Keys.chord(Keys.ARROW_UP))
		WebUI.sendKeys(inputField, Keys.chord(Keys.ARROW_UP))
		WebUI.sendKeys(inputField, Keys.chord(Keys.NUMPAD2))
		WebUI.sendKeys(inputField, Keys.chord(Keys.NUMPAD0))
		WebUI.sendKeys(inputField, Keys.chord(Keys.NUMPAD2))
		WebUI.sendKeys(inputField, Keys.chord(Keys.NUMPAD2))
		WebUI.sendKeys(inputField, Keys.chord(Keys.NUMPAD0))
		WebUI.sendKeys(inputField, Keys.chord(Keys.NUMPAD2))
		WebUI.sendKeys(inputField, Keys.chord(Keys.NUMPAD4))
	}
}