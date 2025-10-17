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
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.callTestCase(findTestCase('Login MCC'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/popfilter/Page_MyCareCoverage/div_Patients'))

TestObject reviewedButton = findTestObject('Object Repository/popfilter/Page_MyCareCoverage/button_Reviewed_rk')

// Wait for the element to be present in DOM
WebUI.waitForElementPresent(reviewedButton, 10)

// Wait for the element to be visible
WebUI.waitForElementVisible(reviewedButton, 10)

// Scroll into view to make sure it’s clickable
WebUI.scrollToElement(reviewedButton, 5)

// Small pause (MUI animations need this sometimes)
WebUI.delay(1)

// Now click
WebUI.click(reviewedButton)


WebUI.click(findTestObject('Object Repository/popfilter/Page_MyCareCoverage/li_Filter'))

// Wait until both column and filter box are visible
WebUI.waitForElementVisible(findTestObject('Object Repository/popfilter/Page_MyCareCoverage/div_ColumnHeader_Reviewed'), 10)
WebUI.waitForElementVisible(findTestObject('Object Repository/popfilter/Page_MyCareCoverage/div_FilterBox'), 10)

// Get WebDriver instance
def driver = DriverFactory.getWebDriver()

// Fetch both WebElements
WebElement columnHeader = WebUI.findWebElement(findTestObject('Object Repository/popfilter/Page_MyCareCoverage/div_ColumnHeader_Reviewed'))
WebElement filterBox = WebUI.findWebElement(findTestObject('Object Repository/popfilter/Page_MyCareCoverage/div_FilterBox'))

// Get positions and sizes
int columnX = columnHeader.getLocation().getX()
int filterX = filterBox.getLocation().getX()
int columnY = columnHeader.getLocation().getY()
int filterY = filterBox.getLocation().getY()
int columnWidth = columnHeader.getSize().getWidth()
int filterWidth = filterBox.getSize().getWidth()

// Log for debugging
WebUI.comment("Column X=${columnX}, Y=${columnY}, width=${columnWidth}")
WebUI.comment("Filter X=${filterX}, Y=${filterY}, width=${filterWidth}")

// Alignment validation
int margin = 10
boolean horizontalAligned = Math.abs(columnX - filterX) <= margin
boolean verticalBelow = filterY > columnY

if (horizontalAligned && verticalBelow) {
    WebUI.comment("✅ Filter box appears directly under 'Reviewed' column (alignment OK).")
} else {
    WebUI.comment("❌ Filter box misaligned with 'Reviewed' column.")
    WebUI.takeScreenshot()
}
