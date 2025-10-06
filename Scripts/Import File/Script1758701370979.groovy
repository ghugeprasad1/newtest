import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Login MCC'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/import file/Page_MyCareCoverage/div_Import  Export'))

WebUI.click(findTestObject('Object Repository/import file/Page_MyCareCoverage/button_Import'))

WebUI.setText(findTestObject('Object Repository/import file/Page_MyCareCoverage/input_Username_last'), filename)

WebUI.click(findTestObject('Object Repository/import file/Page_MyCareCoverage/button_Browse'))

WebUI.click(findTestObject('Object Repository/import file/Page_MyCareCoverage/button_Import_1'))

WebUI.click(findTestObject('Object Repository/import file/Page_MyCareCoverage/button_Import_MuiButtonBase-root MuiIconBut_225a85'))

WebUI.click(findTestObject('importfile/Page_MyCareCoverage/td_imported_accounts.csv'))

WebUI.click(findTestObject('Object Repository/import file/Page_MyCareCoverage/div_'))

WebUI.click(findTestObject('Object Repository/import file/Page_MyCareCoverage/li_Campaign Name'))

WebUI.click(findTestObject('Object Repository/import file/Page_MyCareCoverage/div__1'))

WebUI.setText(findTestObject('Object Repository/import file/Page_MyCareCoverage/input__r6'), filename)

WebUI.click(findTestObject('Object Repository/import file/Page_MyCareCoverage/p_12 of 2'))

