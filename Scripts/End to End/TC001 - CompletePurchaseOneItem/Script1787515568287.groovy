import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Complete the full purchase journey up to order summary verification
WebUI.callTestCase(findTestCase('Checkout/TC005 - VerifyOrderSummary'), [:], FailureHandling.STOP_ON_FAILURE)

// Complete the order
WebUI.click(findTestObject('Object Repository/Checkout/finishButton'))

// Verify order completion message
WebUI.verifyElementText(findTestObject('Object Repository/Checkout/completeHeader'), 'Thank you for your order!')


WebUI.closeBrowser()