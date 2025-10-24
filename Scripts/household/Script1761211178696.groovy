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

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Username_last'), 'cromero@getwrecked.com')

WebUI.setEncryptedText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Password_last'), 'fxXraTyUd3BXw/TvXh12Oxj0SBbKZ0bO')

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/div_reCAPTCHA_recaptcha-checkbox-border'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/form_UsernameUsernamePasswordPasswordLogin'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/button_Login'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/svg_Patients_MuiSvgIcon-root MuiSvgIcon-fon_bc22d4'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/div_Date of BirthDate of Birth'))

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_First Name_first'), 'wddwa')

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Username_last'), 'dwa')

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Date of Birth_r8'), 'MM/DD/YYYY')

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Date of Birth_r8'))

WebUI.doubleClick(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Date of Birth_r8'))

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Date of Birth_r8'), '09/08/2000')

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Are you a citizen of the USA_citizen'), '')

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Are you a citizen of the USA_citizen'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/li_Yes'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Social Security Number_ssn-Thu Oct 23_a130d5'))

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Social Security Number_ssn-Thu Oct 23_9cb201'), 
    '*')

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Social Security Number_ssn-Thu Oct 23_e3d9e8'), 
    '***-**-4')

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Social Security Number_ssn-Thu Oct 23_d050d0'), 
    '***-**-4444')

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Gender_gender'), '')

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Gender_gender'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/li_Male'))

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Address_addressline1'), 'daw')

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_City_city'), 'dwa')

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_State_state'), 'i')

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/li_Illinois'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/div_Zip CodeZip Code'))

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Zip Code_zip'), '55555')

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/label_Do you currently have health insuranc_53ac67'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Yes_rm'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/label_Does this visit relate to an accident'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Yes_rn'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/label_Are you currently incarcerated'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Yes_ro'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/label_Were you ever in foster care'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Yes_rp'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/label_In the last 60 days or the upcoming 6_5b7b04'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Yes_rq'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/button_No Income Source'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Yes_ru'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/button_Continue'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/button_Add Member'))

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_First Name_first'), 'sad')

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Username_last'), 'adw')

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Date of Birth_r1m'), '03/02/2000')

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/div_Are you a citizen of the USA'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/li_Yes'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Social Security Number_ssn-Thu Oct 23_6641f1'))

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Social Security Number_ssn-Thu Oct 23_ad9e67'), 
    '***-**-')

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Social Security Number_ssn-Thu Oct 23_5875d7'), 
    '***-**-3333')

WebUI.setText(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Relationship to Patient_relationship'), '')

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Relationship to Patient_relationship'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/li_Spouse'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/div_Gender'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/li_Male'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/label_Do you currently have health insuranc_53ac67'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Yes_r1u'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/label_Are you currently incarcerated'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Yes_r1v'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/label_Were you ever in foster care'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Yes_r20'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/label_In the last 60 days or the upcoming 6_5b7b04'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Yes_r21'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/button_No Income Source'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/label_Did you lose your job in the last 6 months'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/input_Yes_r26'))

WebUI.click(findTestObject('Object Repository/hous/Page_MyCareCoverage/button_Add Household Member'))

