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

// 🔐 Login first
WebUI.callTestCase(findTestCase('Login MCC'), [:], FailureHandling.STOP_ON_FAILURE)
// ✅ Check and click each menu safely
checkAndClick('Object Repository/Verify All menu link/Page_MyCareCoverage/div_Dashboard', 'Dashboard')
checkAndClick('Object Repository/Verify All menu link/Page_MyCareCoverage/div_Patients', 'Patients')
checkAndClick('Object Repository/Verify All menu link/Page_MyCareCoverage/div_Add Patient', 'AddPatient')
checkAndClick('Object Repository/Verify All menu link/Page_MyCareCoverage/div_Import  Export', 'ImportExport')
checkAndClick('Object Repository/Verify All menu link/Page_MyCareCoverage/div_Account', 'Account')

/**
 * Helper method: verifies, clicks, takes screenshot, or logs "not present"
 */
def checkAndClick(String objectPath, String menuName) {
    TestObject obj = findTestObject(objectPath)

    if (WebUI.waitForElementPresent(obj, 5, FailureHandling.OPTIONAL)) {
        WebUI.click(obj)
        WebUI.delay(5)
        WebUI.takeScreenshot("C:\\Users\\PrasadGhuge\\Katalon Studio\\NewTestCasesMCC\\Screenshots\\${menuName}_${System.currentTimeMillis()}.png")
        println("✅ Clicked and captured screenshot for: " + menuName)
    } else {
        println("❌ Menu not present: " + menuName)
    }
}
