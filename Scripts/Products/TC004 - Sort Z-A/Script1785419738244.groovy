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
import org.openqa.selenium.WebElement

WebUI.callTestCase(findTestCase('Common/TC001 - LoginAsStandard'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Object Repository/Products/sortDropdown'), 'za', false)

// Get all product names as a list
List<WebElement> productNames = WebUI.findWebElements(findTestObject('Object Repository/Products/productName'), 10)

// Extract text from each element
List<String> actualNames = productNames.collect { it.getText() }

// Define expected order (Z to A) - reverse of A to Z verified order
List<String> expectedNames = [
	'Test.allTheThings() T-Shirt (Red)',
	'Sauce Labs Onesie',
	'Sauce Labs Fleece Jacket',
	'Sauce Labs Bolt T-Shirt',
	'Sauce Labs Bike Light',
	'Sauce Labs Backpack'
]

// Verify actual order matches expected order
WebUI.verifyEqual(actualNames, expectedNames)

WebUI.closeBrowser()

