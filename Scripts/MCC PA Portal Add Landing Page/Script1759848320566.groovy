import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement
// Step 1: Login
WebUI.callTestCase(findTestCase('Login MCC'), [:], FailureHandling.STOP_ON_FAILURE)

// Define reusable "Dashboard" button object
TestObject dashboardButton = new TestObject('Dashboard_Button')

dashboardButton.addProperty('xpath', ConditionType.EQUALS, '//span[text()=\'Dashboard\']/ancestor::div[contains(@class,\'MuiListItemButton-root\')]')

// ---------- TILE 1: Submitted not Reviewed ----------
WebUI.comment('🔹 Verifying: Submitted not Reviewed > Reviewed = No, Progress = Completed')

WebUI.click(findTestObject('Object Repository/MCC - PA Portal Add Landing Page/Page_MyCareCoverage/p_Submitted not Reviewed'))

WebUI.delay(2)

TestObject reviewedNo = new TestObject('Reviewed_No')

reviewedNo.addProperty('xpath', ConditionType.EQUALS, '//div[contains(@class,\'MuiDataGrid-cell\') and text()=\'No\']')

TestObject progressCompleted = new TestObject('Progress_Completed')

progressCompleted.addProperty('xpath', ConditionType.EQUALS, '//div[contains(@class,\'MuiDataGrid-cell\') and text()=\'Completed\']')

WebUI.verifyElementPresent(reviewedNo, 10, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(progressCompleted, 10, FailureHandling.STOP_ON_FAILURE)

WebUI.comment('✅ Verified: Reviewed=No and Progress=Completed for Submitted not Reviewed')

// Go back to Dashboard
WebUI.click(dashboardButton)

WebUI.delay(2)

// ---------- TILE 2: Submitted and Reviewed ----------
WebUI.comment('🔹 Verifying: Submitted and Reviewed > Reviewed = Yes, Progress = Completed')

WebUI.click(findTestObject('Object Repository/MCC - PA Portal Add Landing Page/Page_MyCareCoverage/p_Submitted and Reviewed'))

WebUI.delay(2)

TestObject reviewedYes = new TestObject('Reviewed_Yes')

reviewedYes.addProperty('xpath', ConditionType.EQUALS, '//div[contains(@class,\'MuiDataGrid-cell\') and text()=\'Yes\']')

WebUI.verifyElementPresent(reviewedYes, 10, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(progressCompleted, 10, FailureHandling.STOP_ON_FAILURE)

WebUI.comment('✅ Verified: Reviewed=Yes and Progress=Completed for Submitted and Reviewed')

// Go back to Dashboard
WebUI.click(dashboardButton)

WebUI.delay(2)

// ---------- TILE 3: Processing ----------
WebUI.comment('🔹 Verifying: Processing > Progress = Processing')

WebUI.click(findTestObject('landing page/Page_MyCareCoverage/p_Processing'))

WebUI.delay(2)

TestObject progressProcessing = new TestObject('Progress_Processing')

progressProcessing.addProperty('xpath', ConditionType.EQUALS, '//div[contains(@class,\'MuiDataGrid-cell\') and text()=\'Processing\']')

WebUI.verifyElementPresent(progressProcessing, 10, FailureHandling.STOP_ON_FAILURE)

WebUI.comment('✅ Verified: Progress=Processing for Processing tile')

// Go back to Dashboard
WebUI.click(dashboardButton)

WebUI.delay(2)

// ---------- TILE 4: Not Completed Not Logged In ----------
WebUI.comment('🔹 Verifying: Not Completed Not Logged In > Status = No Event')

// Click the tab
WebUI.click(findTestObject('landing page/Page_MyCareCoverage/p_Not Completed Not Logged In'))

// Wait for table to load fully
WebUI.delay(3)

// Define a dynamic TestObject
TestObject statusNoEvent = new TestObject('Status_NoEvent')
statusNoEvent.addProperty('xpath', ConditionType.EQUALS, "//div[contains(@class,'MuiDataGrid-cell')]//*[normalize-space(text())='No Event']")

// Wait for the element to appear
WebUI.waitForElementPresent(statusNoEvent, 15, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(statusNoEvent, 5, FailureHandling.STOP_ON_FAILURE)

WebUI.comment('✅ Verified: Status=No Event for Not Completed Not Logged In')

// Go back to Dashboard
WebUI.click(dashboardButton)
WebUI.delay(2)

// ---------- TILE 5: Closed Accounts ----------
WebUI.comment('🔹 Verifying: Closed Accounts > Status = Do Not Contact / Exhausted / Duplicate')

// Step 1: Click the Closed Accounts tile
WebUI.click(findTestObject('landing page/Page_MyCareCoverage/p_Closed Accounts'))

// Step 2: Wait for table to load (up to 15 seconds)
TestObject tableObj = new TestObject('ClosedAccountsTable')
tableObj.addProperty('xpath', ConditionType.CONTAINS, "MuiDataGrid")
WebUI.waitForElementVisible(tableObj, 15)
WebUI.delay(2)

// Step 3: Get all visible cells in the Closed Accounts grid
List<WebElement> allStatuses = WebUiCommonHelper.findWebElements(
	new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[contains(@class,'MuiDataGrid-cell')]"),
	10
)

WebUI.comment("🔍 Found ${allStatuses.size()} cells in the Closed Accounts table")

// Step 4: Define expected statuses
List<String> expectedStatuses = ['Do Not Contact', 'Exhausted', 'Duplicate']

boolean found = false

// Step 5: Loop through all cells and compare text
for (WebElement cell : allStatuses) {
	String cellText = cell.getText().trim()
	WebUI.comment("➡️ Cell text: '${cellText}'")

	// Case-insensitive comparison
	for (String status : expectedStatuses) {
		if (cellText.equalsIgnoreCase(status)) {
			WebUI.comment("✅ Verified: Found expected status = '${cellText}'")
			found = true
			break
		}
	}

	if (found) break
}

// Step 6: Final validation
if (!found) {
	WebUI.comment("❌ None of the expected statuses found: ${expectedStatuses}")
	assert false : 'Closed Accounts validation failed'
} else {
	WebUI.comment("🎯 Closed Accounts validation successful.")
}

WebUI.takeScreenshot('Screenshots/Dashboard_Verification_Completed.png')

WebUI.comment('🎯 All dashboard tiles and corresponding column values verified successfully!')

