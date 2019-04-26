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
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

def uploadPath = findTestObject('Object Repository/Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/input_fieldControl')

String filePath = 'C:\\Users\\cbrown\\Documents\\Test Docs\\Test Document.pdf'

String documentType = findTestData('SupplierTestData/LoadInvoice').getValue('invType', GlobalVariable.rowFrom)

WebUI.uploadFile(uploadPath, filePath)

WebUI.click(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/span_Select'))

println(WebUI.getText(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/h3_Upload Required Document -')))

def docType = WebUI.modifyObjectProperty(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/small_Invoice'), 
    'text', 'contains', documentType, true)

WebUI.scrollToElement(docType, GlobalVariable.Timeout)

WebUI.click(docType)

//WebUI.click(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/small_Invoice'))
WebUI.click(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/button_Ok'))

WebUI.waitForAngularLoad(GlobalVariable.Timeout)

//Thread.sleep(1000)
WebUI.waitForElementVisible(findTestObject('Object Repository/Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/input_fieldControl'), 
    GlobalVariable.Timeout)

WebUI.uploadFile(uploadPath, filePath)

//WebUI.setText(findTestObject('Object Repository/Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/input_fieldControl'), 'C:\\Users\\cbrown\\Documents\\Test Docs\\Test Document.pdf')
WebUI.click(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/span_Select'))

WebUI.click(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/a_Purchase Order'))

WebUI.click(findTestObject('Suppliers_OR/UploadInvoiceDocsPage_OR/Page_Clientle Unity/button_Ok'))

WebUI.waitForAngularLoad(GlobalVariable.Timeout)

WebUI.verifyTextPresent('Invoice', false)

WebUI.verifyTextPresent('Purchase Order', false, FailureHandling.OPTIONAL)

WebUI.takeScreenshot()

