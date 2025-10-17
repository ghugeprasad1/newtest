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

WebUI.setText(findTestObject('Object Repository/ssn/Page_MyCareCoverage/input_Username_last'), 'cromero@getwrecked.com')

WebUI.setEncryptedText(findTestObject('Object Repository/ssn/Page_MyCareCoverage/input_Password_last'), 'fxXraTyUd3BXw/TvXh12Oxj0SBbKZ0bO')

WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/katalon-div_id(katalon-rec_elementInfoDiv)'))

WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/img_stairs_rc-image-tile-44'))

WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/img_stairs_rc-image-tile-44'))

WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/img_stairs_rc-image-tile-44'))

WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/img_stairs_rc-image-tile-44'))

WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/button_Verify'))

WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/div_reCAPTCHA_recaptcha-checkbox-checkmark'))

WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/button_Login'))

WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/div_Add Patient'))

WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/div_Gender'))

WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/li_Female'))

WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/form_Personal Information Required FieldsFi_f09c15'))

WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/div_Are you currently pregnantAre you curre_e38504'))

WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/svg_Gender_MuiSvgIcon-root MuiSvgIcon-fontS_3dda03'))

WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/div_Gender'))

WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/li_Female'))

WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/div_Are you currently pregnantAre you curre_e38504'))

WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/li_No'))

