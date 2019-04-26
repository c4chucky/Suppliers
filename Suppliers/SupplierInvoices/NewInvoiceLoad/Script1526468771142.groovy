import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.junit.After as After
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

GlobalVariable.rowFrom = 7
GlobalVariable.rowTo = 7

//Open browser and login as Invoiceloader
WebUI.callTestCase(findTestCase('Suppliers/SupplierLogins/LoginSupplierInvoiceLoader'), [:], FailureHandling.STOP_ON_FAILURE)

for (GlobalVariable.rowFrom; GlobalVariable.rowFrom<=GlobalVariable.rowTo; GlobalVariable.rowFrom++) {
	CompleteInvoiceWebForm(MapDataSheet())
}

def MapDataSheet() {
	int randomInvNum = Math.random()*1000000
	
	Map data = [
		entity : findTestData('SupplierTestData/LoadInvoice').getValue('Entity', GlobalVariable.rowFrom),
		supplierType : findTestData('SupplierTestData/LoadInvoice').getValue('SupplierType', GlobalVariable.rowFrom),
		randomNum : Math.random()*10,
		supplierName : findTestData('SupplierTestData/LoadInvoice').getValue('SupplierName', GlobalVariable.rowFrom),
		paymenRef : findTestData('SupplierTestData/LoadInvoice').getValue('PaymentRef', GlobalVariable.rowFrom),
		invType : findTestData('SupplierTestData/LoadInvoice').getValue('invType', GlobalVariable.rowFrom),
		invNumber : 'INV'+(randomInvNum.toString()),
		invDate : findTestData('SupplierTestData/LoadInvoice').getValue('InvDate', GlobalVariable.rowFrom),
		PONumber : ('PO'+randomInvNum),
		TotInvoiceAmnt : findTestData('SupplierTestData/LoadInvoice').getValue('TotInvoiceAmnt', GlobalVariable.rowFrom)]
	
	return data
	}

def CloseDrawer() {
	if (WebUI.verifyElementPresent(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/SupplierDetails_OR/Drawer_button'), 3, FailureHandling.OPTIONAL)) {
		
			WebUI.click(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/Drawer_button'), FailureHandling.OPTIONAL)
		}
	WebUI.waitForElementNotPresent(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/SupplierDetails_OR/Drawer_button'), 3)
}

def CompleteInvoiceWebForm(Map data) {
	
	//WebUI.authenticate(GlobalVariable.url, 'cbrown', 'MyMarPwrd!2019', 5)
		
	WebUI.navigateToUrl(GlobalVariable.url)
	
	WebUI.waitForPageLoad(3)
	
	CloseDrawer()
	
	def button_CreateNewInvoice = findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/button_Create New Invoice')
	
	WebUI.waitForElementNotPresent(findTestObject('Object Repository/Suppliers_OR/Page_Clientle Unity/img_loadingReel'), 5)
	
	WebUI.waitForElementPresent(button_CreateNewInvoice, 3)
	
	WebUI.waitForElementClickable(button_CreateNewInvoice, 3)

	WebUI.click(button_CreateNewInvoice)

	//If drawerButton displays, close it.
	CloseDrawer()
	
	WebUI.waitForElementClickable(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/div_chooseEntity'),
		GlobalVariable.Timeout)

	WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/div_chooseEntity'))

	WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_chooseEntity'), "${data.entity}")

	WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/span_ui-match'))

	WebUI.waitForElementVisible(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/div_supplierType'),
		GlobalVariable.Timeout)

	WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/div_supplierType'))

	WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_supplierType'), "${data.supplierType}")

	WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/span_ui-match'))

	WebUI.waitForElementVisible(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/span_-- Choose registered supp'),
		5)

	WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/span_-- Choose registered supp'))

	WebUI.setText(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_supplierName'),
		"${data.supplierName}")

	WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/span_ui-match'))

	WebUI.waitForAngularLoad(GlobalVariable.Timeout, FailureHandling.OPTIONAL)

	Thread.sleep(500)
	
	WebUI.waitForElementClickable(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_supplierPaymentReference'), 3)
	
	WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_supplierPaymentReference'),
		"${data.paymenRef}")

	WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_invoiceNumber'), "${data.invNumber}")

	WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_invoiceDate'), "${data.invDate}")

	WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_purchaseOrderNumber'),
		"${data.PONumber}")

	WebUI.click(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/label_Invoice Payment Type'))

	WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/span_InvoicePaymentType'))

	//WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/div_Invoice'))
	
	/*def invoiceType = WebUI.modifyObjectProperty(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/div_Invoice'), 'text', 'contains', "${data.invType}" , true)
	
	WebUI.scrollToElement(invoiceType, GlobalVariable.Timeout)
	
	WebUI.click(invoiceType)*/
	
	WebUI.setText(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_InvoicePaymentType'), "${data.invType}")
	
	WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/span_ui-match'))
	
	WebUI.selectOptionByValue(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/select_-- Select Deposit --'),
		'false', true)

	WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_capturedTotalInvoiceAmount'),
		"${data.TotInvoiceAmnt}")

	//Call Test case to load Invoice Items
	WebUI.callTestCase(findTestCase('Suppliers/SupplierInvoices/InvoiceItemLoop'), [:], FailureHandling.STOP_ON_FAILURE)

	GlobalVariable.invoiceItem = 1
	
	WebUI.waitForAngularLoad(30)

	//def CalculatedAmnt = WebUI.getText(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_calculatedTotalInvoiceAmount'))
	println(GlobalVariable.calculatedAmnt)

	String TotalAmnt = GlobalVariable.calculatedAmnt.toString()

	GlobalVariable.calculatedAmnt = 0
	
	WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/input_capturedTotalInvoiceAmount'),
		TotalAmnt)

	WebUI.verifyTextPresent('Approvals Built', false)

	WebUI.takeScreenshot()

	WebUI.verifyTextPresent('Approval Rule ', false)

	WebUI.takeScreenshot()

	WebUI.waitForElementVisible(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/a_Create Invoice'),
		30)

	WebUI.click(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/a_Create Invoice'))

	WebUI.takeScreenshot()

	WebUI.waitForAngularLoad(GlobalVariable.Timeout)

	WebUI.callTestCase(findTestCase('Suppliers/SupplierInvoices/UploadInvoiceDocuments - Copy'), [:], FailureHandling.STOP_ON_FAILURE)
}