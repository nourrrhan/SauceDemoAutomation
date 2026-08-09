import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement

// Call the predefined login test case
WebUI.callTestCase(findTestCase('Common/TC001 - LoginAsStandard'), [:], FailureHandling.STOP_ON_FAILURE)

// Select sort option Name (A to Z)
WebUI.selectOptionByValue(findTestObject('Object Repository/Products/sortDropdown'), 'az', false)

// Get all product names as a list
List<WebElement> productNames = WebUI.findWebElements(findTestObject('Object Repository/Products/productName'), 10)

// Extract text from each element
List<String> actualNames = productNames.collect { it.getText() }

// Define expected order (A to Z) - verified manually on the site
List<String> expectedNames = [
    'Sauce Labs Backpack',
    'Sauce Labs Bike Light',
    'Sauce Labs Bolt T-Shirt',
    'Sauce Labs Fleece Jacket',
    'Sauce Labs Onesie',
    'Test.allTheThings() T-Shirt (Red)'
]

// Verify actual order matches expected order
WebUI.verifyEqual(actualNames, expectedNames)

WebUI.closeBrowser()