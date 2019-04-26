import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Suppliers/SupplierLogins/LoginFinanceManager'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('http://unitytest.clientele.local/#/Finance/Tasks')

//If drawerButton displays, close it.
if (WebUI.verifyElementPresent(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/SupplierDetails_OR/Drawer_button'),
	GlobalVariable.Timeout, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/Drawer_button'), FailureHandling.OPTIONAL)
}

def availableTasks = findTestObject('GPS_OR/button_availableTasks')

WebUI.waitForElementClickable(availableTasks, 5)

def roleSpecificTasks = WebUI.modifyObjectProperty(availableTasks, 'xpath', 'equals', '//td[@class="h6"]/strong[@class="text-info ng-binding"][count(. | //*[(text() = "Release Life Supplier Batch")]/parent::td/parent::tr/td[@class="h6 ng-scope"]/button[@class="btn btn-sm ng-scope btn-primary"]', false)
 
WebUI.click(roleSpecificTasks)

WebUI.click(findTestObject('Object Repository/GPS_OR/a_Batch'))

WebUI.click(findTestObject('Object Repository/GPS_OR/a_Release batch for payment'))