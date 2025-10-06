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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.callTestCase(findTestCase('Login MCC'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/div_Add Patient'))

WebUI.setText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_First Name_first'), 'Tester')

WebUI.setText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Middle Name_middle'), 'testre')

WebUI.setText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Username_last'), 'testre')

//TestObject inputField = WebUI.click(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/div_Date of Birth'))
//WebUI.setText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Date of Birth_r8'), '09/08/1990')
TestObject inputField = findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Date of Birth_r8')

CustomKeywords.'com.utilities.Helper.fillTheDateField'(inputField)

WebUI.delay(4)

WebUI.setText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Mobile Number_IMaskInput-Wed Sep 24 2_b2f579'),
	'(999) 999-9999')

WebUI.setText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Email_email'), 'Test.test@gmail.com')

WebUI.setText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Hospital Account Record_hospital_acc_record'),
	'2276387123')

WebUI.click(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/div_Admittance Date'))

WebUI.setText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Admittance Date_rb'), '09/09/2025')

WebUI.click(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/div_Are you a citizen of the USA'))

WebUI.click(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/li_Yes'))

WebUI.click(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/div_Social Security Number'))

WebUI.setText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Social Security Number_ssn-Wed Sep 24_1df0b7'),
	'888-88-8888')

WebUI.click(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/div_Gender'))

WebUI.click(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/li_Male'))

WebUI.setText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Address_addressline1'),
	'test')

WebUI.setText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Apartment, Suite, Etc_addressline2'),
	'test')

WebUI.setText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_City_city'), 'mumbai')

WebUI.click(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/div_State'))

WebUI.setText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_State_state'), 'illinois')

WebUI.click(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/li_Illinois'))

WebUI.setText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Zip Code_zip'), '88')

// Reusable method
def scrollAndClick(String objectPath) {
	TestObject obj = findTestObject(objectPath)
	WebUI.scrollToElement(obj, 5)
	WebUI.click(obj)
}

// Now just call the method for each object
scrollAndClick('Object Repository/add patient test case/Page_MyCareCoverage/label_Do you currently have health insuranc_53ac67')
scrollAndClick('Object Repository/add patient test case/Page_MyCareCoverage/input_Yes_rm')

scrollAndClick('Object Repository/add patient test case/Page_MyCareCoverage/label_Does this visit relate to an accident')
scrollAndClick('Object Repository/add patient test case/Page_MyCareCoverage/input_Yes_rn')

scrollAndClick('Object Repository/add patient test case/Page_MyCareCoverage/label_Are you currently incarcerated')
scrollAndClick('Object Repository/add patient test case/Page_MyCareCoverage/input_Yes_ro')

scrollAndClick('Object Repository/add patient test case/Page_MyCareCoverage/label_Were you ever in foster care')
scrollAndClick('Object Repository/add patient test case/Page_MyCareCoverage/input_Yes_rp')

scrollAndClick('Object Repository/add patient test case/Page_MyCareCoverage/label_In the last 60 days or the upcoming 6_5b7b04')
scrollAndClick('Object Repository/add patient test case/Page_MyCareCoverage/input_Yes_rq')

scrollAndClick('Object Repository/add patient test case/Page_MyCareCoverage/div_Income SourceYour income is an importan_f6d6f4')
scrollAndClick('Object Repository/add patient test case/Page_MyCareCoverage/button_No Income Source')

scrollAndClick('Object Repository/add patient test case/Page_MyCareCoverage/label_Did you lose your job in the last 6 months')
scrollAndClick('Object Repository/add patient test case/Page_MyCareCoverage/input_Yes_ru')

scrollAndClick('Object Repository/add patient test case/Page_MyCareCoverage/button_Continue')

// Build a dynamic object to locate the zip input
TestObject zipInput = new TestObject('zipInput')
zipInput.addProperty("id", ConditionType.EQUALS, "zip")

// Check if aria-invalid is true
String ariaInvalid = WebUI.getAttribute(zipInput, "aria-invalid")

if (ariaInvalid == "true") {
	WebUI.comment("❌ Invalid ZIP detected. Fixing it now...")

	// Clear and enter valid ZIP
	WebUI.clearText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Zip Code_zip'))
	WebUI.setText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Zip Code_zip'), '55555')

	// Retry continue
	scrollAndClick('Object Repository/add patient test case/Page_MyCareCoverage/button_Continue')
} else {
	WebUI.comment("✅ ZIP is valid. Proceeding...")
}
/*
WebUI.delay(4)

WebUI.clearText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Email_email')); WebUI.setText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Email_email'), 'Test.test@gmail.com')
WebUI.clearText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Zip Code_zip')); WebUI.setText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Zip Code_zip'), '88888')

WebUI.click(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/button_Continue'))*/