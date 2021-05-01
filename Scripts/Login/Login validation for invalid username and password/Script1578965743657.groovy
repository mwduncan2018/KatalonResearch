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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

'Given I navigate to the login page\r\n'
WebUI.openBrowser('http://localhost:60030/Login')

'And I enter a valid username\r\n'
WebUI.setText(findTestObject('LoginPage/Username'), 'mduncan')

'And I enter an invalid password'
WebUI.setText(findTestObject('LoginPage/Password'), 'katalon')

'When the login form is submitted'
WebUI.click(findTestObject('LoginPage/LoginButton'))

WebUI.verifyElementPresent(findTestObject('LoginPage/ValidationMessageInvalidUsernamePassword'), 0)

'Then a validation message is displayed stating the username is required'
WebUI.verifyElementText(findTestObject('LoginPage/ValidationMessageInvalidUsernamePassword'), 'The username/password combination is invalid.')

WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)

