import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Suppliers/SupplierLogins/LoginFinance1stApprover'), [:], FailureHandling.STOP_ON_FAILURE)

Thread.sleep(1000)

WebUI.waitForPageLoad(GlobalVariable.Timeout)

WebUI.navigateToUrl("http://unitytest.clientele.local/#/Suppliers/Tasks")

WebUI.waitForPageLoad(GlobalVariable.Timeout)

if (WebUI.verifyElementPresent(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/SupplierDetails_OR/Drawer_button'),
	GlobalVariable.Timeout, FailureHandling.OPTIONAL)) {

WebUI.click(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/Drawer_button'))
}

WebUI.waitForPageLoad(GlobalVariable.Timeout)

//WebUI.waitForElementClickable(findTestObject('Object Repository/Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/Page_Clientle Unity/button_ClaimAvailableTask'), GlobalVariable.Timeout)

def availableTasks = findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/button_availableTasks')

WebUI.waitForElementClickable(availableTasks, 5)

def roleSpecificTasks = WebUI.modifyObjectProperty(availableTasks, 'xpath', 'equals', '//td[@class="h6"]/strong[@class="text-info ng-binding"][count(. | //*[(text() = "Finance First Approver Invoice Approval")]/parent::td/parent::tr/td[@class="h6 ng-scope"]/button[@class="btn btn-sm ng-scope btn-primary"]', false)

WebUI.click(roleSpecificTasks)

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/a_Reject'), GlobalVariable.Timeout)

WebUI.waitForElementVisible(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/a_ApproveInvoice'), GlobalVariable.Timeout)

WebUI.waitForElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/a_ApproveInvoice'), GlobalVariable.Timeout)

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/a_ApproveInvoice'))

WebUI.setText(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/textarea_divdiv'), 'Approve as First Approver')

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/button_modalCancel'), GlobalVariable.Timeout)

WebUI.waitForElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/button_modalApprove'), GlobalVariable.Timeout)

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/button_modalApprove'))

WebUI.verifyTextPresent('Invoice successfully approved.', false)
