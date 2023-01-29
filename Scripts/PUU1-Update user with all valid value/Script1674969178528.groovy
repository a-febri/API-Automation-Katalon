import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

output = WS.sendRequest(findTestObject('Get list users with all valid value'))
value = WS.getElementPropertyValue(output, 'data[1].id')

'Verify that id is equal to 2'
WS.verifyElementPropertyValue(output, 'data[1].id', 2)

GlobalVariable.idUser = value

response = WS.sendRequest(findTestObject('Put update user with all valid value'))

WS.verifyResponseStatusCode(response, 200)

'API should return body response contains name = morpheus'
WS.verifyElementPropertyValue(response, 'name', 'morpheus')

'API should return body response contains job = zion resident'
WS.verifyElementPropertyValue(response, 'job', 'zion resident')

