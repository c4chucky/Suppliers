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

WebUI.callTestCase(findTestCase('Suppliers/SupplierLogins/LoginSupplierInvoiceLoader'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('http://unitytest.clientele.local/#/Suppliers/')

WebUI.waitForPageLoad(30)

WebUI.waitForElementPresent(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/button_Create New Invoice'), 30)

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/button_Create New Invoice'))

WebUI.waitForAngularLoad(30)

//if (findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/Drawer_button'){ 


//WebUI.click(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/Drawer_button'))

//}

WebUI.click(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/Drawer_button'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/div_chooseEntity'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/div_Life Suppliers'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/div_supplierType'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/div_Existing'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/span_-- Choose registered supp'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/div_CTest12'))

WebUI.waitForAngularLoad(30)

WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_supplierPaymentReference'), 'clientele')

WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_invoiceNumber'), '2323241')

WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_invoiceDate'), '01/01/2019')

WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_purchaseOrderNumber'), 'PO11144')

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/span_InvoicePaymentType'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/div_Invoice'))

WebUI.selectOptionByValue(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/select_-- Select Deposit --'), 'false', 
    true)

WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_capturedTotalInvoiceAmou'), '4444')

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/a_Add Item'))

WebUI.waitForAngularLoad(15)

WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_description'), 'item 1')

WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_amount'), '4444')

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/span_-- Select Expense Type --'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/div_OPEX'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/span_-- Select Budgeted For --'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/div_Yes'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/span_-- Select Department --'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/a_Actuarial'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/span_-- Select Budget Item --'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/a_BudgetItem'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/span_-- Select Tax Code --'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/a_NA'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/a_Save'))

WebUI.takeScreenshot()

WebUI.waitForElementClickable(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/a_Create Invoice'), 
    15)

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/a_Create Invoice'))

WebUI.click(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/span_Select'))

WebUI.click(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/small_Invoice'))

WebUI.click(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/button_Ok'))

WebUI.click(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/span_Select'))

WebUI.click(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/a_Purchase Order'))

WebUI.click(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/button_Ok'))

