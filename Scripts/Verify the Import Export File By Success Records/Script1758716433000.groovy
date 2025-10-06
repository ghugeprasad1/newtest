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

//Call login test case
WebUI.callTestCase(findTestCase('Login MCC'), [:], FailureHandling.STOP_ON_FAILURE)

// Navigate to Import Export section
WebUI.click(findTestObject('Object Repository/MCC_Portal_2/Import Export/Page_MyCareCoverage/div_Import  Export'))

WebUI.click(findTestObject('Object Repository/MCC_Portal_2/Import Export/Page_MyCareCoverage/div_'))

WebUI.click(findTestObject('MCC_Portal_2/Import Export/Page_MyCareCoverage/li_Success Records'))

// Set filename from variable - make sure 'filename' is defined
WebUI.setText(findTestObject('Object Repository/MCC_Portal_2/Import Export/Page_MyCareCoverage/input__r6'), SuccessRecords)

// Wait for results
WebUI.delay(5)

// Check if records are found
// Direct check for the "No results found." text
TestObject noResultsElement = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//div[text()=\'No results found.\']')

boolean noRecords = WebUI.verifyElementPresent(noResultsElement, 3, FailureHandling.OPTIONAL)

if (noRecords) {
    WebUI.comment('No records found for filename:' + SuccessRecords)

    WebUI.comment('File count: 0') // Get pagination text and extract count
} else {
    WebUI.comment('File record found for filename:' + SuccessRecords)

    TestObject pagination = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//p[contains(@class, \'MuiTablePagination-displayedRows\')]')

    String text = WebUI.getText(pagination, FailureHandling.OPTIONAL)

    int count = text ? text.replaceAll('.*of\\s*', '').replaceAll('[^0-9]', '').toInteger() : 0

    WebUI.comment('File count:' + count)
}

WebUI.takeFullPageScreenshot()

