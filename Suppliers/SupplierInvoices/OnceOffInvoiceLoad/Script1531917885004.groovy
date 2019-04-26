import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After

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

import java.lang.Thread

GlobalVariable.rowFrom = 3
GlobalVariable.row = 3
//Open browser and login as Invoiceloader

String entity = (findTestData('SupplierTestData/OnceOffInvoice').getValue('Entity', GlobalVariable.rowFrom));
String supplierType = findTestData('SupplierTestData/OnceOffInvoice').getValue('SupplierType', GlobalVariable.rowFrom);
//String supplierName = findTestData('SupplierTestData/OnceOffInvoice').getValue('SupplierName', GlobalVariable.rowFrom);
String paymenRef = findTestData('SupplierTestData/OnceOffInvoice').getValue('PaymentRef', GlobalVariable.rowFrom);
//String invNumber = findTestData('SupplierTestData/OnceOffInvoice').getValue('InvNumber', GlobalVariable.rowFrom);
String invDate = findTestData('SupplierTestData/OnceOffInvoice').getValue('InvDate', GlobalVariable.rowFrom);
//String PONumber = findTestData('SupplierTestData/OnceOffInvoice').getValue('PONumber', GlobalVariable.rowFrom);
String TotInvoiceAmnt =  findTestData('SupplierTestData/OnceOffInvoice').getValue('TotInvoiceAmnt', GlobalVariable.rowFrom);
def uploadPath = findTestObject('Object Repository/Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/input_fieldControl')
String bankName = findTestData('BankDetails').getValue('BankName', GlobalVariable.row)
String accType = findTestData('BankDetails').getValue('AccountType', GlobalVariable.row)
String accNumber = findTestData('BankDetails').getValue('AccNumber', GlobalVariable.row)

String filePath = 'C:\\Users\\cbrown\\Documents\\Test Docs\\Test Document.pdf';
String OnceOffSupplier = 'Floyd Hough & Co'

//String OnceOffSupplier = CustomKeywords.'RandomNameGenerator.randomSupplierName'();

int randomNum = Math.random()*1000000;
String invNumber = randomNum.toString();
String PONumber = 'PO'+randomNum.toString();

WebUI.callTestCase(findTestCase('Suppliers/SupplierLogins/LoginSupplierInvoiceLoader'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('http://unitytest.clientele.local/#/Suppliers/')

//WebUI.maximizeWindow()

WebUI.waitForPageLoad(GlobalVariable.Timeout)

// Loop through number of Invoices
//while (GlobalVariable.rowFrom <= GlobalVariable.rowTo) {
	

//If drawerButton displays, close it.
if (WebUI.verifyElementPresent(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/SupplierDetails_OR/Drawer_button'), GlobalVariable.Timeout, FailureHandling.OPTIONAL)) {

	WebUI.click(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/Drawer_button'), FailureHandling.OPTIONAL)
}

WebUI.waitForElementPresent(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/button_Create New Invoice'), GlobalVariable.Timeout)

WebUI.waitForElementClickable(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/button_Create New Invoice'), GlobalVariable.Timeout)

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/button_Create New Invoice'))



WebUI.waitForElementClickable(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/div_chooseEntity'), GlobalVariable.Timeout)

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/div_chooseEntity'))

WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_chooseEntity'), entity)
	
WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/span_ui-match'))

WebUI.waitForElementVisible(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/div_supplierType'), GlobalVariable.Timeout)

//Select new supplier
WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/div_supplierType'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_OnceOffSupplierName'), 5)

WebUI.setText(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_supplierType'), supplierType)

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/span_ui-match'))

//WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/span_-- Choose registered supp'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_OnceOffSupplierName'), 5)

WebUI.setText(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_OnceOffSupplierName'), OnceOffSupplier)

//WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/span_ui-match'))

WebUI.waitForAngularLoad(GlobalVariable.Timeout, FailureHandling.OPTIONAL)

//Add Banking details

WebUI.click(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/span_Bank'))

WebUI.setText(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_Bank'), bankName)

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/span_ui-match'))

//Thread.sleep(2000)

WebUI.waitForElementVisible(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_AccountNumber'), 5)

WebUI.setText(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_AccountNumber'), accNumber)

//WebUI.waitForAngularLoad(5)

WebUI.click(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/label_Account Number'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_AccountHolder'), 5)

//Thread.sleep(2000)

WebUI.setText(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_AccountHolder'), 'AC Holder')

WebUI.click(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/div_AccountType'))

WebUI.setText(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_AccountType'), accType)

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/span_ui-match'))

WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_supplierPaymentReference'), paymenRef)

WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_invoiceNumber'), invNumber)

WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_invoiceDate'), invDate)

WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_purchaseOrderNumber'), PONumber)

WebUI.click(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/label_Invoice Payment Type'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/span_InvoicePaymentType'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/div_Invoice'))

WebUI.selectOptionByValue(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/select_-- Select Deposit --'), 'false', true)

WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_capturedTotalInvoiceAmount'), TotInvoiceAmnt)

//Call Test case to load Invoice Items
WebUI.callTestCase(findTestCase('Suppliers/SupplierInvoices/InvoiceItemLoop'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForAngularLoad(30)

//def CalculatedAmnt = WebUI.getText(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_calculatedTotalInvoiceAmount'))

println(GlobalVariable.calculatedAmnt)

def input_calculatedAmnt = findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_capturedTotalInvoiceAmount')

String TotAmnt = GlobalVariable.calculatedAmnt.toString()

WebUI.setText(input_calculatedAmnt, TotAmnt)

WebUI.verifyTextPresent('Approvals Built', false)

WebUI.takeScreenshot()

String ApprovalRules = WebUI.verifyTextPresent('Approval Rule ', false)

WebUI.takeScreenshot()

WebUI.waitForElementVisible(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/a_Create Invoice'), 30)

WebUI.click(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/a_Create Invoice'))

WebUI.takeScreenshot()

WebUI.waitForAngularLoad(GlobalVariable.Timeout)

//WebUI.setText(findTestObject('Object Repository/Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/input_fieldControl'), 'C:\\Users\\cbrown\\Documents\\Test Docs\\Test Document.pdf')

WebUI.uploadFile(uploadPath, filePath)

WebUI.click(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/span_Select'))

WebUI.click(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/small_Invoice'))

WebUI.click(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/button_Ok'))

WebUI.waitForAngularLoad(GlobalVariable.Timeout)

//Thread.sleep(1000)

WebUI.waitForElementVisible(findTestObject('Object Repository/Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/input_fieldControl'), GlobalVariable.Timeout)

WebUI.uploadFile(uploadPath, filePath)

//WebUI.setText(findTestObject('Object Repository/Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/input_fieldControl'), 'C:\\Users\\cbrown\\Documents\\Test Docs\\Test Document.pdf')

WebUI.click(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/span_Select'))

WebUI.click(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/a_Purchase Order'))

WebUI.click(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/button_Ok'))

WebUI.waitForAngularLoad(GlobalVariable.Timeout)

WebUI.verifyTextPresent('Invoice', false)

WebUI.verifyTextPresent('Purchase Order', false, FailureHandling.OPTIONAL)

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/a_SendInvoiceForApprovalButton'))

//Increment the row number for the next Invoice
//GlobalVariable.rowFrom++;

//}
