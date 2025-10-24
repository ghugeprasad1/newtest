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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper

WebUI.callTestCase(findTestCase('Login MCC'), [:], FailureHandling.STOP_ON_FAILURE)

// Function to click "No" for any question
// Function to select No for specific question by label ID
def selectNoByQuestion(String labelId) {
    TestObject noOption = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@aria-labelledby='${labelId}']//span[text()='No']")
    WebUI.click(noOption)
    WebUI.delay(1)
}
// Helper method
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

WebUI.setText(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Zip Code_zip'), '88888')

// Health Insurance
scrollAndClick(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/label_Do you currently have health insuranc_53ac67'))

scrollAndClick(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Yes_rm'))

// Accident related
scrollAndClick(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/label_Does this visit relate to an accident'))

scrollAndClick(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Yes_rn'))

// Incarcerated
scrollAndClick(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/label_Are you currently incarcerated'))

scrollAndClick(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Yes_ro'))

// Foster care
scrollAndClick(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/label_Were you ever in foster care'))

scrollAndClick(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Yes_rp'))

// Last 60 days / upcoming 6 months
scrollAndClick(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/label_In the last 60 days or the upcoming 6_5b7b04'))

scrollAndClick(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Yes_rq'))

// Income Source
scrollAndClick(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/div_Income SourceYour income is an importan_f6d6f4'))

scrollAndClick(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/button_No Income Source'))

// Job loss in last 6 months
scrollAndClick(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/label_Did you lose your job in the last 6 months'))

scrollAndClick(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/input_Yes_ru'))

WebUI.click(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/button_Continue'))

WebUI.delay(4)

// Create dynamic TestObject
TestObject addMemberButton = new TestObject('Add_Member_Button')

addMemberButton.addProperty('xpath', ConditionType.EQUALS, '//button[normalize-space()=\'Add Member\']')

// Scroll to the button
WebUI.scrollToElement(addMemberButton, 5)

// Click the button
WebUI.click(addMemberButton)

WebUI.setText(findTestObject('household/Page_MyCareCoverage/input_First Name_first'), 'test')

WebUI.setText(findTestObject('household/Page_MyCareCoverage/input_Middle Name_middle'), 'd')

WebUI.setText(findTestObject('household/Page_MyCareCoverage/input_Last Name_last'), 'test')

TestObject dobField = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//input[@placeholder=\'MM/DD/YYYY\']')

CustomKeywords.'com.utilities.Helper.fillTheDateField'(dobField)

WebUI.delay(4)

/*WebUI.click(findTestObject('household/Page_MyCareCoverage/div_Are you a citizen of the USA'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('add patient test case/Page_MyCareCoverage/li_Yes'))

WebUI.click(findTestObject('household/Page_MyCareCoverage/div_Social Security Number'))

WebUI.setText(findTestObject('household/Page_MyCareCoverage/input_Social Security Number_ssn-Thu Oct 23 2025 022239 GMT0530 (India Standard Time)'), 
    '888-88-8888')*/
WebUI.click(findTestObject('household/Page_MyCareCoverage/div_Relationship to Patient'))

WebUI.click(findTestObject('household/Page_MyCareCoverage/li_Spouse'))

WebUI.click(findTestObject('household/Page_MyCareCoverage/div_Gender'))

WebUI.click(findTestObject('household/Page_MyCareCoverage/li_Male'))

WebUI.click(findTestObject('household/Page_MyCareCoverage/label_Do you currently have health insurance, including Medicare or Medicaid'))

WebUI.click(findTestObject('household/Page_MyCareCoverage/label_No'))

WebUI.click(findTestObject('household/Page_MyCareCoverage/label_Are you currently incarcerated'))

// 2. Incarcerated
selectNoByQuestion("incarcerated-label")
println("✓ Incarcerated: No")

WebUI.click(findTestObject('household/Page_MyCareCoverage/label_Were you ever in foster care'))

// 3. Foster care
selectNoByQuestion("foster-care-label")
println("✓ Foster care: No")

WebUI.click(findTestObject('household/Page_MyCareCoverage/label_In the last 60 days or the upcoming 60 days, have you lost, or will you lose health insurance'))

// 4. Health insurance loss
selectNoByQuestion("lost-health-insurance-label")
println("✓ Health insurance loss: No")

WebUI.click(findTestObject('household/Page_MyCareCoverage/button_No Income Source'))

WebUI.click(findTestObject('household/Page_MyCareCoverage/label_Did you lose your job in the last 6 months'))

selectNoByQuestion("lost-job-label")

//WebUI.click(findTestObject('hous/Page_MyCareCoverage/input_Yes_r26'))

WebUI.click(findTestObject('hous/Page_MyCareCoverage/button_Add Household Member'))

WebUI.delay(4)

TestObject continueButton = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[text()='Continue']")
WebUI.click(continueButton)
println("✓ Continue button clicked")

//WebUI.click(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/button_Continue_1'))

WebUI.delay(4)

WebUI.click(findTestObject('Add Patient Information/Page_MyCareCoverage/button_Submit (1)'))

WebUI.delay(4)

WebUI.click(findTestObject('Object Repository/add patient test case/Page_MyCareCoverage/div_Submitted Information'))

// Log step
WebUI.comment('🔹 Verifying: No income sources selected message is displayed')

// Create a TestObject for the overlay message
TestObject noIncomeMessage = new TestObject('No_Income_Message')

noIncomeMessage.addProperty('xpath', ConditionType.EQUALS, '//div[contains(@class,\'MuiBox-root\') and text()=\'No income sources have been selected by the individual.\']')

// Scroll to the element first
WebUI.scrollToElement(noIncomeMessage, 5)

// Wait for message to appear (up to 10 seconds)
WebUI.waitForElementVisible(noIncomeMessage, 10)

// Verify the message is present
WebUI.verifyElementPresent(noIncomeMessage, 5)

WebUI.comment('✅ Verified: "No income sources have been selected by the individual." message is displayed')

def scrollAndClick(TestObject to, int timeout = 5) {
    WebUI.scrollToElement(to, timeout)

    WebUI.click(to)
}

