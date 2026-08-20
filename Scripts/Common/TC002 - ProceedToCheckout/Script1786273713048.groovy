import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling


// Login
WebUI.callTestCase(findTestCase('Common/TC001 - LoginAsStandard'), [:], FailureHandling.STOP_ON_FAILURE)


// Add product
WebUI.click(findTestObject('Object Repository/Products/addToCart'))

// Click Cart
WebUI.click(findTestObject('Object Repository/Common/cartIcon'))


// 4. Verify Cart page is opened
WebUI.verifyElementPresent(findTestObject('Object Repository/Cart/checkoutButton'), 10,FailureHandling.STOP_ON_FAILURE)


// 5. Click Checkout
WebUI.click(findTestObject('Object Repository/Cart/checkoutButton'), FailureHandling.STOP_ON_FAILURE)
