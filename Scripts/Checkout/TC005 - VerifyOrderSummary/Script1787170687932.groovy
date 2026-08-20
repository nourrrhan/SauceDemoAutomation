import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


// Login only
WebUI.callTestCase(findTestCase('Common/TC001 - LoginAsStandard'), [:], FailureHandling.STOP_ON_FAILURE)

// Add product to cart
WebUI.click(findTestObject('Object Repository/Products/addToCart'))

// Open cart page
WebUI.click(findTestObject('Object Repository/Common/cartIcon'))

// Capture product name and price from cart page
String productNameBefore = WebUI.getText(findTestObject('Object Repository/Products/productName'))
String productPriceBefore = WebUI.getText(findTestObject('Object Repository/Products/productPrice'))

// Proceed to checkout
WebUI.click(findTestObject('Object Repository/Cart/checkoutButton'))

// Enter checkout information
WebUI.setText(findTestObject('Object Repository/Checkout/inputFirstName'), firstName)
WebUI.setText(findTestObject('Object Repository/Checkout/inputLastName'), lastName)
WebUI.setText(findTestObject('Object Repository/Checkout/inputZipCode'), zipCode)

// Continue to overview
WebUI.click(findTestObject('Object Repository/Checkout/continueButton'))

// Capture product name and price from overview page
String productNameAfter = WebUI.getText(findTestObject('Object Repository/Products/productName'))
String productPriceAfter = WebUI.getText(findTestObject('Object Repository/Products/productPrice'))

// Verify product details match
WebUI.verifyEqual(productNameAfter, productNameBefore)
WebUI.verifyEqual(productPriceAfter, productPriceBefore)

// Get prices
String subtotalText = WebUI.getText(findTestObject('Object Repository/Checkout/subtotalLabel'))
String taxText = WebUI.getText(findTestObject('Object Repository/Checkout/taxLabel'))
String totalText = WebUI.getText(findTestObject('Object Repository/Checkout/totalLabel'))

// Convert to numbers
double subtotal = subtotalText.replaceAll('[^0-9.]', '').toDouble()
double tax = taxText.replaceAll('[^0-9.]', '').toDouble()
double total = totalText.replaceAll('[^0-9.]', '').toDouble()

// Verify total = subtotal + tax
WebUI.verifyEqual(total, subtotal + tax)


