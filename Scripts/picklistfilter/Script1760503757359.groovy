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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import java.util.Arrays

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

// ========== STEP 3: Check for Dropdown or Input Field ==========
TestObject dropdownList = new TestObject("dropdownList")
dropdownList.addProperty("xpath", ConditionType.CONTAINS, "//ul[contains(@class,'MuiAutocomplete-listbox')]")

TestObject inputBox = new TestObject("inputBox")
inputBox.addProperty("xpath", ConditionType.CONTAINS, "//input[contains(@class,'MuiInputBase-input')]")

boolean dropdownVisible = WebUI.verifyElementPresent(dropdownList, 3, FailureHandling.OPTIONAL)
boolean inputVisible = WebUI.verifyElementPresent(inputBox, 3, FailureHandling.OPTIONAL)

assert dropdownVisible || inputVisible : "❌ Neither dropdown nor input field found for Reviewed column filter"


// ========== STEP 4: Validate Dropdown Options ==========
if (dropdownVisible) {
	List<String> expectedValues = ["Yes", "No"]
	for (String value : expectedValues) {
		TestObject optionItem = new TestObject("option_" + value)
		optionItem.addProperty("xpath", ConditionType.CONTAINS, "//li[contains(text(),'" + value + "')]")
		boolean optionFound = WebUI.verifyElementPresent(optionItem, 3, FailureHandling.OPTIONAL)
		assert optionFound : "❌ Dropdown option '${value}' not found"
	}
	WebUI.comment("✅ Dropdown contains expected values: Yes, No")
}


// ========== STEP 5: Validate Auto-complete (if input visible) ==========
if (inputVisible) {
	WebUI.setText(inputBox, "Y")
	WebUI.delay(1)
	TestObject suggestionYes = new TestObject("suggestionYes")
	suggestionYes.addProperty("xpath", ConditionType.CONTAINS, "//li[contains(text(),'Yes')]")

	boolean suggestionVisible = WebUI.verifyElementPresent(suggestionYes, 3, FailureHandling.OPTIONAL)
	assert suggestionVisible : "❌ Auto-complete suggestion not appearing when typing 'Y'"
	WebUI.comment("✅ Auto-complete suggestions appear correctly for input value 'Y'")
}


// ========== STEP 6: Apply Filter and Validate Results ==========
if (dropdownVisible) {
	// Select 'Yes' from dropdown
	TestObject yesOption = new TestObject("yesOption")
	yesOption.addProperty("xpath", ConditionType.CONTAINS, "//li[contains(text(),'Yes')]")
	WebUI.click(yesOption)
} else if (inputVisible) {
	WebUI.setText(inputBox, "Yes")
	WebUI.sendKeys(inputBox, Keys.ENTER)
}

WebUI.delay(2)

// Verify grid results have 'Yes' in Reviewed column
TestObject reviewedCells = new TestObject("reviewedCells")
reviewedCells.addProperty("xpath", ConditionType.EQUALS, "//div[@data-field='Reviewed']")

List<WebElement> cells = WebUI.findWebElements(reviewedCells, 10)
assert cells.size() > 0 : "❌ No rows found after applying filter"

for (WebElement cell : cells) {
	assert cell.getText().equalsIgnoreCase("Yes") : "❌ Found non-Yes value in filtered results"
}

WebUI.comment("✅ All rows have 'Yes' in the Reviewed column after applying filter")

WebUI.comment("🎉 Filter functionality validated successfully for Reviewed column!")