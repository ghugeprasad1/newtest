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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://community-dev.revone.io/mcc_portal/?path=sign_in')

WebUI.setText(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Username_last'), 'cromero@getwrecked.com')

WebUI.setEncryptedText(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Password_last'), 'fxXraTyUd3BXw/TvXh12Oxj0SBbKZ0bO')

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/div_reCAPTCHA_recaptcha-checkbox-border'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/img_If there are none, click skip_rc-image-tile-44'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/img_If there are none, click skip_rc-image-tile-44'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/img_If there are none, click skip_rc-image-tile-44'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/img_If there are none, click skip_rc-image-tile-44'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/img_If there are none, click skip_rc-image-tile-44'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/img_If there are none, click skip_rc-image-tile-44'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/button_Next'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/img_If there are none, click skip_rc-image-tile-44_1'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/img_If there are none, click skip_rc-image-tile-44_1'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/img_If there are none, click skip_rc-image-tile-44_1'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/img_If there are none, click skip_rc-image-tile-44_1'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/img_If there are none, click skip_rc-image-tile-44_1'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/img_If there are none, click skip_rc-image-tile-44_1'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/img_If there are none, click skip_rc-image-tile-44_1'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/img_If there are none, click skip_rc-image-tile-44_1'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/button_Verify'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/button_Login'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/div_Add Patient'))

WebUI.setText(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_First Name_first'), 'efw')

WebUI.setText(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Username_last'), 'ewr')

WebUI.setText(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Date of Birth_r8'), 'MM/DD/YYYY')

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Date of Birth_r8'))

WebUI.doubleClick(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Date of Birth_r8'))

WebUI.setText(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Date of Birth_r8'), '09/07/2020')

WebUI.setText(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Email_email'), 'abc@gmail.com')

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/li_Yes'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Social Security Number_ssn-Thu Oct 16_40ff97'))

WebUI.setText(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Social Security Number_ssn-Thu Oct 16_2a9417'), 
    '***-**-88')

WebUI.setText(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Social Security Number_ssn-Thu Oct 16_d75d0b'), 
    '***-**-8888')

WebUI.setText(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Gender_gender'), '')

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Gender_gender'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/li_Male'))

WebUI.setText(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Address_addressline1'), 'test')

WebUI.setText(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_City_city'), 'test')

WebUI.setText(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_State_state'), 'il')

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/li_Illinois'))

WebUI.setText(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Zip Code_zip'), '88888')

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Yes_rm'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Does this visit relate to an accident_rn'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Yes_ro'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Yes_rp'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Yes_rq'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/button_No Income Source'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Yes_ru'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/button_Continue'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/div_Required FieldsIn what type of accident_556242'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/p_In what type of accident were you involved'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/div_In what type of accident were you invol_d81f94'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/div_Accident Type'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/li_Auto'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/h3_Auto Accident Details'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/div_Number of vehicles involvedNumber of ve_54872e'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/div_Number of vehicles involved'))

WebUI.setText(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Number of vehicles involved_number_of_d95dc0'), 
    '64')

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/div_Who was responsible for the accidentWho_d4ee59'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/div_Who was responsible for the accident'))

WebUI.setText(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Who was responsible for the accident__afa22a'), 
    'ters')

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/label_Were you the driver or a passenger'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/label_Passenger'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Driver_r1s'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/div_Attorney InformationDo you have an atto_bf7361'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/h3_Attorney Information'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/label_Do you have an attorney involved for _8684dd'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/div_YesNo'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Yes_r1h'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/div_Signature of Patient  Legal Representat_4d54af'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/p_Signature of Patient  Legal Representative'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/canvas__sigPad'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Phone_IMaskInput-Thu Oct 16 2025 1250_aa0fb6'))

WebUI.setText(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Phone_IMaskInput-Thu Oct 16 2025 1250_0cf929'), 
    '(88')

WebUI.setText(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Phone_IMaskInput-Thu Oct 16 2025 1250_9e3474'), 
    '(888) 888-8888')

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/label_Do you authorize us to contact you by_a4a43a'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Do you authorize us to contact you by_353c7e'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/label_Do you authorize us to contact you by_d82ab3'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Do you authorize us to contact you by_ca5f47'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Do you authorize us to contact you by_353c7e'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Do you authorize us to contact you by_ca5f47'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Do you authorize us to contact you by_353c7e'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/input_Do you authorize us to contact you by_ca5f47'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/button_Continue'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/button_Continue_1'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/button_Submit'))

WebUI.click(findTestObject('Object Repository/accvisit/Page_MyCareCoverage/div_Relate to AccidentYes'))

