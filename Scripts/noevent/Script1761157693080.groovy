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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://community-dev.revone.io/mcc_portal/?path=sign_in')

WebUI.setText(findTestObject('Object Repository/noevent/Page_MyCareCoverage/input_Username_last'), 'cromero@getwrecked.com')

WebUI.click(findTestObject('Object Repository/noevent/Page_MyCareCoverage/div_Password'))

WebUI.setEncryptedText(findTestObject('Object Repository/noevent/Page_MyCareCoverage/input_Password_last'), 'fxXraTyUd3BXw/TvXh12Oxj0SBbKZ0bO')

WebUI.click(findTestObject('Object Repository/noevent/Page_MyCareCoverage/katalon-div_id(katalon-rec_elementInfoDiv)'))

WebUI.click(findTestObject('Object Repository/noevent/Page_MyCareCoverage/button_Login'))

WebUI.click(findTestObject('Object Repository/noevent/Page_MyCareCoverage/div_97Not Completed Not Logged In'))

WebUI.click(findTestObject('Object Repository/noevent/Page_MyCareCoverage/div_Status'))

WebUI.click(findTestObject('Object Repository/noevent/Page_MyCareCoverage/button_Status_r1t'))

WebUI.click(findTestObject('Object Repository/noevent/Page_MyCareCoverage/div_Status'))

WebUI.click(findTestObject('Object Repository/noevent/Page_MyCareCoverage/svg_Status_MuiSvgIcon-root MuiSvgIcon-fontS_a82224'))

WebUI.click(findTestObject('Object Repository/noevent/Page_MyCareCoverage/button_Status_r1t'))

WebUI.click(findTestObject('Object Repository/noevent/Page_MyCareCoverage/svg_Yes_MuiSvgIcon-root MuiSvgIcon-fontSize_b8fb31'))

WebUI.click(findTestObject('Object Repository/noevent/Page_MyCareCoverage/div_Dashboard'))

WebUI.click(findTestObject('Object Repository/noevent/Page_MyCareCoverage/div_97Not Completed Not Logged In'))

WebUI.click(findTestObject('Object Repository/noevent/Page_MyCareCoverage/div_Status'))

WebUI.click(findTestObject('Object Repository/noevent/Page_MyCareCoverage/div_No Event'))

WebUI.click(findTestObject('Object Repository/noevent/Page_MyCareCoverage/p_197 of 97'))

