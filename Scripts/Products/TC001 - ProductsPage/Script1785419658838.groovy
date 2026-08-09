import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// call the predefined login
WebUI.callTestCase(findTestCase('Common/TC001 - LoginAsStandard'), [:], FailureHandling.STOP_ON_FAILURE)

// check current destination
WebUI.verifyEqual(WebUI.getUrl(), 'https://www.saucedemo.com/inventory.html')

// check elements
WebUI.verifyElementVisible(findTestObject('Object Repository/Products/lblProducts'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Products/sortDropdown'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Products/cartIcon'))

