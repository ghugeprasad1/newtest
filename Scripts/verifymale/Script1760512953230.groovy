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

WebUI.delay(2)

// Check if SSN field is visible and enter value if it is
TestObject ssnField = findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Social Security Number_ssn-Wed Sep 24_1df0b7')

if (WebUI.verifyElementVisible(ssnField, FailureHandling.OPTIONAL)) {
    println("SSN field is visible - entering value")
    WebUI.setText(ssnField, '888-88-8888')
    println("SSN value entered successfully")
} else {
    println("SSN field is not visible")
}

WebUI.click(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/div_Are you a citizen of the USA'))

WebUI.click(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/li_No (1)'))

WebUI.delay(2)

// Verify if Entry Date box is visible when answer is No
if (WebUI.verifyElementVisible(findTestObject('Object Repository/ssn/Page_MyCareCoverage/div_What is your Entry Date'), FailureHandling.OPTIONAL)) {
	println("Entry Date box is visible when USA citizen answer is No")
} else {
	println("Entry Date box is NOT visible when USA citizen answer is No")
}

TestObject inputFields = findTestObject('Object Repository/ssn/Page_MyCareCoverage/input_What is your Entry Date_rt')
CustomKeywords.'com.utilities.Helper.fillTheDateField'(inputFields)
// Gender and Pregnancy test
WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/div_Gender'))
WebUI.click(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/li_Male'))
WebUI.delay(2)

// Check if pregnancy question is NOT visible when Male is selected
if (WebUI.verifyElementNotVisible(findTestObject('Object Repository/ssn/Page_MyCareCoverage/div_Are you currently pregnantAre you curre_e38504'), FailureHandling.OPTIONAL)) {
    println("PASS: Pregnancy question not visible for Male")
} else {
    println("FAIL: Pregnancy question visible for Male")
}

// Select Female and check if pregnancy question is visible
WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/div_Gender'))
WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/li_Female'))
WebUI.delay(2)

// Check if pregnancy question IS visible when Female is selected
if (WebUI.verifyElementVisible(findTestObject('Object Repository/ssn/Page_MyCareCoverage/div_Are you currently pregnantAre you curre_e38504'), FailureHandling.OPTIONAL)) {
    println("PASS: Pregnancy question visible for Female")
    
    // Select "No" for pregnancy question
    WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/div_Are you currently pregnantAre you curre_e38504'))
    WebUI.click(findTestObject('Object Repository/ssn/Page_MyCareCoverage/li_No'))
    println("Selected 'No' for pregnancy question")
} else {
    println("FAIL: Pregnancy question not visible for Female")
}

println("Test completed")