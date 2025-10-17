import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

// Step 1: Login
WebUI.callTestCase(findTestCase('Login MCC'), [:], FailureHandling.STOP_ON_FAILURE)

// Step 2: Navigate to “Submitted not Reviewed”
WebUI.click(findTestObject('Object Repository/MCC - PA Portal Add Landing Page/Page_MyCareCoverage/p_Submitted not Reviewed'))

// Step 3: Click on “Reviewed” column
WebUI.click(findTestObject('Object Repository/MCC - PA Portal Add Landing Page/Page_MyCareCoverage/div_Reviewed'))

// Step 4: Click on “Progress” column
WebUI.click(findTestObject('Object Repository/MCC - PA Portal Add Landing Page/Page_MyCareCoverage/div_Progress'))

// Step 5: Verify Reviewed column value is “No”
TestObject reviewedValue = new TestObject('ReviewedValue')
reviewedValue.addProperty('xpath', ConditionType.EQUALS, "//div[contains(@class,'MuiDataGrid-cell') and (text()='No')]")

WebUI.verifyElementPresent(reviewedValue, 10, FailureHandling.STOP_ON_FAILURE)
WebUI.comment('Verified Reviewed column value is No')

// Step 6: Verify Progress column value is “Completed”
TestObject progressValue = new TestObject('ProgressValue')
progressValue.addProperty('xpath', ConditionType.EQUALS, "//div[contains(@class,'MuiDataGrid-cell') and (text()='Completed')]")

WebUI.verifyElementPresent(progressValue, 10, FailureHandling.STOP_ON_FAILURE)
WebUI.comment('Verified Progress column value is Completed')

// Step 7: (Optional) Take screenshot for verification
WebUI.takeScreenshot('Screenshots/Reviewed_Progress_Verified.png')

WebUI.comment('✅ Successfully verified Reviewed=No and Progress=Completed columns')

// ---------- TILE 2: Submitted and Reviewed ----------
WebUI.comment('🔹 Verifying: Submitted and Reviewed > Reviewed = Yes, Progress = Completed')
WebUI.click(findTestObject('Object Repository/MCC - PA Portal Add Landing Page/Page_MyCareCoverage/p_Submitted and Reviewed'))

TestObject reviewedYes = new TestObject('Reviewed_Yes')
reviewedYes.addProperty('xpath', ConditionType.EQUALS, "//div[contains(@class,'MuiDataGrid-cell') and text()='Yes']")

WebUI.verifyElementPresent(reviewedYes, 10, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(progressCompleted, 10, FailureHandling.STOP_ON_FAILURE)
WebUI.comment('✅ Verified: Reviewed=Yes and Progress=Completed for Submitted and Reviewed')