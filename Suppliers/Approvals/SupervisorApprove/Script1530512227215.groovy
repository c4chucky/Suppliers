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
import java.lang.Thread


WebUI.callTestCase(findTestCase('Suppliers/SupplierLogins/LoginSupplierSupervisor'), [:], FailureHandling.STOP_ON_FAILURE)

Thread.sleep(1000)

WebUI.waitForPageLoad(GlobalVariable.Timeout)

WebUI.navigateToUrl("http://unitytest.clientele.local/#/Suppliers/Tasks")

WebUI.waitForPageLoad(GlobalVariable.Timeout)

if (WebUI.verifyElementPresent(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/SupplierDetails_OR/Drawer_button'),
	GlobalVariable.Timeout, FailureHandling.OPTIONAL)) {

WebUI.click(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/Drawer_button'))
}

WebUI.waitForPageLoad(GlobalVariable.Timeout)

WebUI.waitForElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/td_Supervisor Invoice Approval'), GlobalVariable.Timeout)

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/strong_Supplier Supervisor'), 
    15)

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/td_Supervisor Invoice Approval'), 
    15)

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/th_Available'), GlobalVariable.Timeout)

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/th_Name'), GlobalVariable.Timeout)

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/th_Active'), GlobalVariable.Timeout)

//WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/a_btn Refresh'))

//Thread.sleep(1000)
WebUI.waitForElementClickable(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/button_claimTask'), GlobalVariable.Timeout)

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/button_claimTask'))

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/a_Reject'), GlobalVariable.Timeout)

WebUI.waitForElementVisible(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/a_ApproveInvoice'), GlobalVariable.Timeout)

WebUI.waitForElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/a_ApproveInvoice'), GlobalVariable.Timeout)

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/a_ApproveInvoice'))

WebUI.setText(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/textarea_divdiv'), 'Approve')

WebUI.verifyElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/button_modalCancel'), GlobalVariable.Timeout)

WebUI.waitForElementPresent(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/button_modalApprove'), GlobalVariable.Timeout)

WebUI.click(findTestObject('Suppliers_OR/FinanceApprovals_OR/Page_ApprovalTasks/button_modalApprove'))

WebUI.verifyTextPresent('Invoice successfully approved.', false)

