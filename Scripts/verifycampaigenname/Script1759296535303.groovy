import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement

// Call login test case
WebUI.callTestCase(findTestCase('Login MCC'), [:], FailureHandling.STOP_ON_FAILURE)

// Navigate to Import Export section
WebUI.click(findTestObject('MCC_Portal_2/Import Export/Page_MyCareCoverage/div_Import  Export'))
WebUI.click(findTestObject('MCC_Portal_2/Import Export/Page_MyCareCoverage/div_'))
WebUI.click(findTestObject('MCC_Portal_2/Import Export/Page_MyCareCoverage/li_Campaign Name'))

// Clear previous input before typing new CampaignName
TestObject searchBox = findTestObject('MCC_Portal_2/Import Export/Page_MyCareCoverage/input__r6')
WebUI.click(searchBox)
WebUI.sendKeys(searchBox, Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(searchBox, Keys.chord(Keys.DELETE))
WebUI.setText(searchBox, CampaignName)

// Wait for results
WebUI.delay(5)

// Check if records are found
TestObject noResultsElement = new TestObject().addProperty(
    'xpath', ConditionType.EQUALS, "//div[text()='No results found.']"
)
boolean noRecords = WebUI.verifyElementPresent(noResultsElement, 3, FailureHandling.OPTIONAL)

if (noRecords) {
    WebUI.comment("❌ No records found for CampaignName: " + CampaignName)
    WebUI.comment("Record count: 0")
} else {
    WebUI.comment("✅ Records found for CampaignName: " + CampaignName)

    // Locate all campaign name cells in the Campaign Name column
    TestObject campaignNameCells = new TestObject().addProperty(
        "xpath",
        ConditionType.EQUALS,
        "//div[@data-field='campaign_name' and contains(@class,'MuiDataGrid-cell')]"
    )

    // Get all elements
    List<WebElement> elements = WebUI.findWebElements(campaignNameCells, 10)

    boolean found = false
    for (WebElement el : elements) {
        String cellText = el.getText()
        WebUI.comment("Row value: " + cellText)
        if (cellText.contains(CampaignName)) {
            found = true
            break
        }
    }

    if (found) {
        WebUI.comment("✅ Campaign column contains: " + CampaignName)
    } else {
        WebUI.comment("❌ Campaign column does NOT contain: " + CampaignName)
        WebUI.takeScreenshot()
        WebUI.verifyMatch(CampaignName, "", true) // force failure
    }

    // Get pagination text and extract count
    TestObject pagination = new TestObject().addProperty(
        'xpath',
        ConditionType.EQUALS,
        "//p[contains(@class, 'MuiTablePagination-displayedRows')]"
    )
    String text = WebUI.getText(pagination, FailureHandling.OPTIONAL)
    int count = text ? text.replaceAll('.*of\\s*', '').replaceAll('[^0-9]', '').toInteger() : elements.size()
    WebUI.comment("Record count for CampaignName: " + count)
}

// Final screenshot
WebUI.takeFullPageScreenshot()
