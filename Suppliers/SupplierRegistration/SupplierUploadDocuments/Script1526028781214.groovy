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

//Create a list of Documents to upload
String[] docsToUpload = 
	['Bank Confirmation', 
	'Supplier Registration Fo', 
	'Certificate Of Incorpora', 
	'BEE Certificate  Sworn A', 
	'VAT Certificate']

//Prompt to upload documents
for (int index=0; index<docsToUpload.length; index++) {
	WebUI.waitForElementPresent(findTestObject('Object Repository/Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/modal_docUpload'), 5)
	
	WebUI.setText(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_supplierDocumentUpload/input_SelectFile'), 'C:\\Users\\cbrown\\Documents\\Test Docs\\Test Document.pdf')
	
	WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/span_Select'))
	
	WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/small_' + docsToUpload[index]))
	
	WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/button_Ok'))
	
	Thread.sleep(1000)
}

//int index=0; index<docsToUpload.length; index++