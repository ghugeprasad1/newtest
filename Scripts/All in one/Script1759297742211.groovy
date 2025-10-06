import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import org.openqa.selenium.Keys as Keys

// ----------- DYNAMIC COLUMN SELECTION ------------
def selectColumn(String columnName) {
    // Create TestObject for the column header by matching its label text
    TestObject column = new TestObject().addProperty(
        "xpath", ConditionType.EQUALS,
        "//div[contains(@class,'MuiDataGrid-columnHeader')]" +
        "[.//div[text()='" + columnName + "']]"
    )
    WebUI.scrollToElement(column, 3)
    WebUI.click(column)
    WebUI.delay(2)
}

// ----------- REUSABLE SEARCH METHOD ------------
def clearAndSearch(String columnName, String value, String label) {

    // Select the column dynamically
    selectColumn(columnName)

    // Locate the search input box above the grid
    TestObject inputBox = new TestObject().addProperty(
        "xpath", ConditionType.EQUALS,
        "//div[contains(@class,'MuiDataGrid-toolbar')]//input[@type='text']"
    )

    // Click input and clear previous value
    WebUI.click(inputBox)
    for (int i = 0; i < 3; i++) {
        WebUI.sendKeys(inputBox, Keys.chord(Keys.CONTROL, 'a'))
        WebUI.sendKeys(inputBox, Keys.chord(Keys.BACK_SPACE))
        WebUI.delay(1)
    }

    // Double-check input is empty
    String currentValue = WebUI.getAttribute(inputBox, "value")
    if (currentValue != null && currentValue.trim() != "") {
        WebUI.sendKeys(inputBox, Keys.chord(Keys.CONTROL, 'a'))
        WebUI.sendKeys(inputBox, Keys.chord(Keys.DELETE))
    }

    // Enter the new value
    WebUI.setText(inputBox, value)
    WebUI.delay(5)

    // Check for "No results found."
    TestObject noResultsElement = new TestObject().addProperty(
        'xpath', ConditionType.EQUALS, '//div[text()="No results found."]'
    )
    boolean noRecords = WebUI.verifyElementPresent(noResultsElement, 3, FailureHandling.OPTIONAL)

    if (noRecords) {
        WebUI.comment("No records found for ${label}: " + value)
        WebUI.comment("${label} count: 0")

        // Refresh page and re-navigate to Import Export
        WebUI.refresh()
        WebUI.delay(5)
        WebUI.click(findTestObject('Object Repository/MCC_Portal_2/Import Export/Page_MyCareCoverage/div_Import  Export'))
        WebUI.delay(3)
    } else {
        WebUI.comment("Record(s) found for ${label}: " + value)

        // Get pagination text
        TestObject pagination = new TestObject().addProperty(
            'xpath', ConditionType.EQUALS, '//p[contains(@class, "MuiTablePagination-displayedRows")]'
        )
        String text = WebUI.getText(pagination, FailureHandling.OPTIONAL)
        int count = text ? text.replaceAll('.*of\\s*', '').replaceAll('[^0-9]', '').toInteger() : 0
        WebUI.comment("${label} count: " + count)
    }

    WebUI.takeFullPageScreenshot()
}

// ----------- MAIN TEST CASE ------------

// Login
WebUI.callTestCase(findTestCase('Login MCC'), [:], FailureHandling.STOP_ON_FAILURE)

// Navigate to Import Export
WebUI.click(findTestObject('Object Repository/MCC_Portal_2/Import Export/Page_MyCareCoverage/div_Import  Export'))

// ===== RUN SEARCHES FOR ALL PARAMETERS =====
clearAndSearch("Campaign Name", CampaignName, "Campaign Name")
clearAndSearch("File Name", FileName, "File Name")
clearAndSearch("Batch ID", BatchID, "Batch ID")
clearAndSearch("Total Records", TotalRecords, "Total Records")
clearAndSearch("Success Records", SuccessRecords, "Success Records")
clearAndSearch("Failed Records", FailedRecords, "Failed Records")
clearAndSearch("Status", Status, "Status")
