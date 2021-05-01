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

'\r\n'
WebUI.openBrowser('http://localhost:60030/Login')

WebUI.setText(findTestObject('LoginPage/Username'), 'mduncan')

WebUI.setText(findTestObject('LoginPage/Password'), 'cucumber')

WebUI.click(findTestObject('LoginPage/LoginButton'))

WebUI.click(findTestObject('FlightListPage/CreateNewLink'))

WebUI.setText(findTestObject('CreateFlightPage/FirstName'), 'Jordan')

WebUI.setText(findTestObject('CreateFlightPage/LastName'), 'Peterson')

WebUI.setText(findTestObject('CreateFlightPage/DepartureTime'), '2/2/2009 10:01:00 AM')

WebUI.setText(findTestObject('CreateFlightPage/ArrivalTime'), '2/2/2009 11:51:00 AM')

WebUI.setText(findTestObject('CreateFlightPage/DepartureAirport'), 'Toronto')

WebUI.setText(findTestObject('CreateFlightPage/ArrivalAirport'), 'Chicago')

WebUI.click(findTestObject('CreateFlightPage/CreateButton'))

WebUI.closeBrowser()

response = WS.sendRequest(findTestObject('FlightsApi'))

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'FirstName', 'Jordan')

WS.verifyElementPropertyValue(response, 'LastName', 'Peterson')

WS.verifyElementPropertyValue(response, 'DepartureAirport', 'Toronto')

WS.verifyElementPropertyValue(response, 'ArrivalAirport', 'Chicago')

WS.verifyElementPropertyValue(response, 'DepartureTime', '2009-02-02T10:01:00')

WS.verifyElementPropertyValue(response, 'ArrivalTime', '2009-02-02T11:51:00')

WebUI.openBrowser('http://localhost:60030/Login')

WebUI.setText(findTestObject('LoginPage/Username'), 'mduncan')

WebUI.setText(findTestObject('LoginPage/Password'), 'cucumber')

WebUI.click(findTestObject('LoginPage/LoginButton'))

CustomKeywords.'com.duncan.customkeywords.FlightListPage.clickDeleteLinkForUser'('Jordan', 'Peterson')

WebUI.takeScreenshot()

WebUI.click(findTestObject('DeleteFlightPage/DeleteButton'))

WebUI.closeBrowser()

