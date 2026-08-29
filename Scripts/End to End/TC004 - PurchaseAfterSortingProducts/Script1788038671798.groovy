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
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys as Keys

// login as standard user
WebUI.callTestCase(findTestCase('Common/TC001 - LoginAsStandard'), [:], FailureHandling.STOP_ON_FAILURE)


// Select sort option "Price (low to high)" from the dropdown
WebUI.selectOptionByValue(findTestObject('Object Repository/Products/sortDropdown'), 'lohi', false)


// Add first product to cart after sorting
List<WebElement> addToCartButtons = WebUI.findWebElements(findTestObject('Object Repository/Products/addToCartButtons'), 10)
addToCartButtons[0].click()


// Open cart page
WebUI.click(findTestObject('Object Repository/Common/cartIcon'))

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


