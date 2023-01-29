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

'Send request to get list users for getting the available id'
response = WS.sendRequest(findTestObject('Get list users with all valid value'))

value = WS.getElementPropertyValue(response, 'data[1].id')

'Verify that id is equal to 2'
WS.verifyElementPropertyValue(response, 'data[1].id', 2)

GlobalVariable.idUser = value

println(value)

resp = WS.sendRequest(findTestObject('Get single user with all valid value'))

WS.verifyResponseStatusCode(resp, 200)

'Verify API return body response contains id=2'
WS.verifyElementPropertyValue(resp, 'data.id', 2)

'Verify API return body response contains email=janet.weaver@reqres.in'
WS.verifyElementPropertyValue(resp, 'data.email', 'janet.weaver@reqres.in')

email = WS.getElementPropertyValue(resp, 'data.email')

GlobalVariable.emailUser = email

WS.verifyNotEqual(GlobalVariable.emailUser, '')

response1 = WS.sendRequest(findTestObject('Post register invalid body request with empty password'))

'API should return 400 bad request'
WS.verifyResponseStatusCode(response1, 400)

'API should return error message "Missing password"'
WS.verifyElementPropertyValue(response1, 'error', 'Missing password')

