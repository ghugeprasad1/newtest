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

WebUI.click(findTestObject('HospitalSelector/Page_MyCareCoverage/div_Hospital ClientCommunityGo'))

WebUI.click(findTestObject('HospitalSelector/Page_MyCareCoverage/div__MuiBackdrop-root MuiBackdrop-invisible MuiModal-backdrop css-esi9ax'))

WebUI.click(findTestObject('HospitalSelector/Page_MyCareCoverage/li_Deaconess'))

WebUI.click(findTestObject('Object Repository/HospitalSelector/Page_MyCareCoverage/button_Go'))

// Wait for navigation to complete
WebUI.waitForPageLoad(30)

// Get the current URL after navigation
String currentUrl = WebUI.getUrl()

// Verify that the current URL contains the expected hospital identifier
WebUI.verifyMatch(currentUrl, '.*deaconess.*', true)

// Alternative verification methods:
// Method 1: Verify URL contains specific text (case-insensitive)
// WebUI.verifyMatch(currentUrl.toLowerCase(), ".*deaconess.*", true)
// Method 2: Verify specific URL pattern (if you know the exact pattern)
// WebUI.verifyMatch(currentUrl, ".*deaconess.*revone.*", true)
// Method 3: Check if we're no longer on the login/selection page
// WebUI.verifyNotMatch(currentUrl, ".*sign_in.*", true)
// WebUI.verifyNotMatch(currentUrl, ".*mcc_portal.*path.*", true)
// Method 4: Verify page title or specific element exists for Deaconess hospital
// WebUI.verifyElementPresent(findTestObject('Object Repository/DeaconessSpecificElement'), 10)
println('Expected URL pattern: ' + expectedUrlPattern)

println('Actual URL: ' + currentUrl)

