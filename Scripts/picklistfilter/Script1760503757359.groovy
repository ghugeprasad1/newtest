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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import java.util.Arrays as Arrays

WebUI.callTestCase(findTestCase('Login MCC'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/popfilter/Page_MyCareCoverage/div_Patients'))

// Try different XPath variations for the Reviewed header
// Hover over the header
// Now look for the 3-dot button
// Usage
clickReviewedColumnThreeDot()

WebUI.click(findTestObject('Object Repository/popfilter/Page_MyCareCoverage/li_Filter'))
// Step 1: Click on the input box and set text "Y" - verify "Yes"
TestObject valueInput = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id=':r35:']")
WebUI.click(valueInput)
WebUI.setText(valueInput, "Y")
WebUI.delay(2)

TestObject yesSuggestion = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[contains(., 'Yes')]")
WebUI.verifyElementPresent(yesSuggestion, 5)
println("✓ Successfully set 'Y' and verified 'Yes' suggestion appears")

// Step 2: Clear field, set text "N" - verify "No"
WebUI.click(valueInput)
WebUI.sendKeys(valueInput, "\u0008") // Backspace to clear
WebUI.setText(valueInput, "N")
WebUI.delay(2)

TestObject noSuggestion = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[contains(., 'No')]")
WebUI.verifyElementPresent(noSuggestion, 5)
println("✓ Successfully set 'N' and verified 'No' suggestion appears")

// Step 3: Clear field and just click - verify both "Yes" and "No" appear automatically
WebUI.click(valueInput)
WebUI.sendKeys(valueInput, "\u0008") // Backspace to clear
WebUI.delay(2) // Wait for dropdown to appear automatically

// Verify both options are present without clicking dropdown arrow
WebUI.verifyElementPresent(yesSuggestion, 5)
WebUI.verifyElementPresent(noSuggestion, 5)
println("✓ Successfully verified both 'Yes' and 'No' appear when field is empty and clicked")

println("All tests completed successfully! 🎉")

def clickReviewedColumnThreeDot() {
    try {
        def headerSelectors = ['//div[contains(@class, \'MuiDataGrid-columnHeaderTitle\') and text()=\'Reviewed\']', '//div[contains(@class, \'MuiDataGrid-columnHeaderTitle\') and contains(text(), \'Reviewed\')]'
            , '//div[@role=\'columnheader\' and .//div[text()=\'Reviewed\']]', '//div[contains(@class, \'MuiDataGrid-columnHeader\') and .//div[text()=\'Reviewed\']]'
            , '//div[text()=\'Reviewed\']/ancestor::div[contains(@class, \'MuiDataGrid-columnHeader\')]', '//div[contains(@class, \'columnHeaderTitle\') and text()=\'Reviewed\']']

        TestObject reviewedHeader = null

        for (String selector : headerSelectors) {
            reviewedHeader = new TestObject().addProperty('xpath', ConditionType.EQUALS, selector)

            if (WebUI.verifyElementPresent(reviewedHeader, 2, FailureHandling.OPTIONAL)) {
                println("✓ Found Reviewed header with selector: $selector")

                break
            }
        }
        
        if (!(WebUI.verifyElementPresent(reviewedHeader, 5, FailureHandling.OPTIONAL))) {
            throw new Exception('Could not locate Reviewed column header')
        }
        
        WebUI.mouseOver(reviewedHeader)

        WebUI.delay(2)

        def buttonSelectors = ['//button[@aria-label=\'Menu\']', '//button[contains(@aria-label, \'menu\') or contains(@aria-label, \'Menu\')]'
            , '//button[contains(@class, \'MuiIconButton-root\') and not(@aria-label=\'Sort\')]', '//div[contains(@class, \'MuiDataGrid-menuIcon\')]//button'
            , '//button[.//*[local-name()=\'svg\'][not(contains(@data-testid, \'Arrow\'))]]']

        for (String btnSelector : buttonSelectors) {
            TestObject threeDotButton = new TestObject().addProperty('xpath', ConditionType.EQUALS, btnSelector)

            if (WebUI.verifyElementPresent(threeDotButton, 2, FailureHandling.OPTIONAL)) {
                WebUI.click(threeDotButton)

                println('✓ Successfully clicked 3-dot button')

                return true
            }
        }
        
        throw new Exception('Could not find 3-dot button after hover')
    }
    catch (Exception e) {
        println("Error: $e.message")

        return false
    } 
}

