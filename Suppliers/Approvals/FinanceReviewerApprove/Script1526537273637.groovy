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

WebUI.callTestCase(findTestCase('Suppliers/SupplierLogins/LoginFinanceReviewer'), [:], FailureHandling.STOP_ON_FAILURE)

Thread.sleep(1000)

WebUI.waitForPageLoad(GlobalVariable.Timeout)

WebUI.navigateToUrl('http://unitytest.clientele.local/#/Suppliers/Tasks')

WebUI.waitForPageLoad(GlobalVariable.Timeout)

if (WebUI.verifyElementPresent(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/SupplierDetails_OR/Drawer_button'), 
    GlobalVariable.Timeout, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/Drawer_button'))
}

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/strong_Finance Reviewer'), 
    15)

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/td_Finance Reviewer Invoice Ap'), 
    15)

def availableTasks = findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/button_availableTasks')

def roleSpecificTasks = WebUI.modifyObjectProperty(availableTasks, 'xpath', 'equals', '//td[@class="h6"]/strong[@class="text-info ng-binding"][count(. | //*[(text() = "Finance Reviewer Invoice Approval")]/parent::td/parent::tr/td[@class="h6 ng-scope"]/button[@class="btn btn-sm ng-scope btn-primary"]', false)

WebUI.click(roleSpecificTasks)

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/label_Invoice Number'), 0)

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/input_invoiceNumber'), 0)

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/label_Invoice Date'), 0)

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/input_invoiceDate'), 0)

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/label_Purchase Order Number'), 
    0)

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/input_purchaseOrderNumber'), 
    0)

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/input_capturedTotalInvoiceAmou'), 
    0)

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/a_Item 1'), 0)

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/a_Item 1'))

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/span_-- Select Tax Code --  -'))

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/a_3'))

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/span_-- Select Tax Code -- NA'))

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/a_NA'))

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/label_HasAllCodes'), 0)

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/a_Cancel'), 0)

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/a_Save'))

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/a_Reject'), 0)

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/a_Item 2'), 0)

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/a_Item 2'))

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/span_7 - Exempt Expenses'))

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/small_Exempt Expenses'))

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/span_NA - NA-Not applicable'))

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/small_None'))

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/label_HasAllCodes'), 0)

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/a_Cancel'), 0)

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/a_Save'))

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/a_Approve'))

WebUI.setText(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/textarea_divdiv'), 'Approve')

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/button_Cancel'), 0)

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ReviewerTasks/button_Approve'))



