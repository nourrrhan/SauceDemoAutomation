import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Navigate to checkout overview page
WebUI.callTestCase(findTestCase('Common/TC003 - NavigateToOrderSummary'), [:], FailureHandling.STOP_ON_FAILURE)

// Click Cancel button
WebUI.click(findTestObject('Object Repository/Checkout/cancelCheckoutButton'))

// Verify we're back on the products page
WebUI.verifyEqual(WebUI.getUrl(), 'https://www.saucedemo.com/inventory.html')

WebUI.closeBrowser()