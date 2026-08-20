import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Navigate to checkout step one page
WebUI.callTestCase(findTestCase('Cart/TC004 - ProceedToCheckout'), [:], FailureHandling.STOP_ON_FAILURE)

// Fill shipping information
WebUI.setText(findTestObject('Object Repository/Checkout/inputFirstName'), firstName)
WebUI.setText(findTestObject('Object Repository/Checkout/inputLastName'), lastName)
WebUI.setText(findTestObject('Object Repository/Checkout/inputZipCode'), zipCode)

// Continue to overview page
WebUI.click(findTestObject('Object Repository/Checkout/continueButton'))