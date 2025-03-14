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
import org.openqa.selenium.Keys as Keys

/**
 * Verify if the it directs to Home Building's content calculator page.
 * 
 */

def buildingCalculatorLink = findTestObject('Object Repository/Hohh/Plan Page/dylink_ProceedToCostCalculator_text', 
	[('text') : GlobalVariable.dyobj_ORPP001['homeBuilding']])
def toBuildingThirdPartyButton = findTestObject('Object Repository/Hohh/ORM002_dybutton_CommonButton_text',
	[('text') : GlobalVariable.dyobj_ORPP001['proceedToBuildingCalculator']])
def thirdPartyLink = GlobalVariable.link_CostCalculator

// Start
WebUI.callTestCase(findTestCase('Hohh/Reusable Module/Page Flow/TC002_RM_PF_Direct to Plan Page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.enhancedClick(buildingCalculatorLink)
WebUI.enhancedClick(toBuildingThirdPartyButton)
WebUI.delay(3) // To make sure website loaded
WebUI.switchToWindowIndex(1)

url = WebUI.getUrl()

WebUI.takeScreenshot()
WebUI.closeBrowser()

assert WebUI.verifyEqual(thirdPartyLink, url) : "It does not direct to the building link (${thirdPartyLink}), but to ${url} instead"

