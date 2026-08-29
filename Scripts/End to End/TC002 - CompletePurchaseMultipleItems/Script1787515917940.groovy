import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement

// Login
WebUI.callTestCase(findTestCase('Common/TC001 - LoginAsStandard'), [:], FailureHandling.STOP_ON_FAILURE)

// Add first two products to cart
List<WebElement> addToCartButtons = WebUI.findWebElements(findTestObject('Object Repository/Products/addToCartButtons'), 10)
addToCartButtons[0].click()
addToCartButtons[1].click()

// Open cart page
WebUI.click(findTestObject('Object Repository/Common/cartIcon'))

// Verify cart badge shows 2 items
WebUI.verifyElementText(findTestObject('Object Repository/Common/cartBadge'), '2')

// Proceed to checkout
WebUI.click(findTestObject('Object Repository/Cart/checkoutButton'))

// Fill shipping information
WebUI.setText(findTestObject('Object Repository/Checkout/inputFirstName'), firstName)
WebUI.setText(findTestObject('Object Repository/Checkout/inputLastName'), lastName)
WebUI.setText(findTestObject('Object Repository/Checkout/inputZipCode'), zipCode)
WebUI.click(findTestObject('Object Repository/Checkout/continueButton'))

// Complete the order
WebUI.click(findTestObject('Object Repository/Checkout/finishButton'))

// Verify order completion message
WebUI.verifyElementText(findTestObject('Object Repository/Checkout/completeHeader'), 'Thank you for your order!')

WebUI.closeBrowser()