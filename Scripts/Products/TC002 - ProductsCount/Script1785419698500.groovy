import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement

// Call the predefined login test case
WebUI.callTestCase(findTestCase('Common/TC001 - LoginAsStandard'), [:], FailureHandling.STOP_ON_FAILURE)

// Get all product item elements as a list
List<WebElement> products = WebUI.findWebElements(findTestObject('Object Repository/Products/productItems'), 10)

// Verify the count matches the expected value (verified manually on the site)
WebUI.verifyEqual(products.size(), 6)

WebUI.closeBrowser()