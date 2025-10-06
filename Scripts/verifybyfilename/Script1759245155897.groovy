import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys as Keys
// Call login test case
WebUI.callTestCase(findTestCase('Login MCC'), [:], FailureHandling.STOP_ON_FAILURE)

// Navigate to Import Export section
WebUI.click(findTestObject('Object Repository/MCC_Portal_2/Import Export/Page_MyCareCoverage/div_Import  Export'))
WebUI.click(findTestObject('Object Repository/MCC_Portal_2/Import Export/Page_MyCareCoverage/div_'))
WebUI.click(findTestObject('Object Repository/MCC_Portal_2/Import Export/Page_MyCareCoverage/li_File Name'))

// Clear any previous value in the search box
TestObject searchBox = findTestObject('Object Repository/MCC_Portal_2/Import Export/Page_MyCareCoverage/input__r6')
WebUI.click(searchBox)
WebUI.sendKeys(searchBox, Keys.chord(Keys.CONTROL, 'a')) // select all
WebUI.sendKeys(searchBox, Keys.chord(Keys.DELETE))       // clear

// Now enter the new filename
WebUI.setText(searchBox, filename)

// Wait for results
WebUI.delay(5)

// Check if records are found
TestObject noResultsElement = new TestObject().addProperty(
    'xpath', ConditionType.EQUALS, "//div[text()='No results found.']"
)
boolean noRecords = WebUI.verifyElementPresent(noResultsElement, 3, FailureHandling.OPTIONAL)

if (noRecords) {
    WebUI.comment("No records found for filename: " + filename)
    WebUI.comment("File count: 0")
} else {
    WebUI.comment("File record(s) found for filename: " + filename)

    // Locate all file name cells in the File Name column
    TestObject fileNameCells = new TestObject().addProperty(
        "xpath",
        ConditionType.EQUALS,
        "//div[@data-field='file_name' and contains(@class,'MuiDataGrid-cell')]"
    )

    // Get all elements matching the locator
    List<WebElement> elements = WebUI.findWebElements(fileNameCells, 10)

    boolean found = false
    for (WebElement el : elements) {
        String cellText = el.getText()
        WebUI.comment("Row value: " + cellText)
        if (cellText.contains(filename)) {
            found = true
            break
        }
    }

    if (found) {
        WebUI.comment("✅ The column contains the searched filename: " + filename)
    } else {
        WebUI.comment("❌ The column does NOT contain the searched filename: " + filename)
        WebUI.takeScreenshot()
        WebUI.verifyMatch(filename, "", true) // force test failure
    }

    // Get pagination text and extract count
    TestObject pagination = new TestObject().addProperty(
        'xpath',
        ConditionType.EQUALS,
        "//p[contains(@class, 'MuiTablePagination-displayedRows')]"
    )
    String text = WebUI.getText(pagination, FailureHandling.OPTIONAL)
    int count = text ? text.replaceAll('.*of\\s*', '').replaceAll('[^0-9]', '').toInteger() : elements.size()
    WebUI.comment("File count: " + count)
}

// Take final screenshot
WebUI.takeFullPageScreenshot()
