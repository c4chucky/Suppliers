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

//def row = 1
//def calculatedAmnt = 0
for (GlobalVariable.invoiceItem; GlobalVariable.invoiceItem <= GlobalVariable.NumberOfInvoiceItems; (GlobalVariable.invoiceItem)++) {
    

    WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/a_Add Item'))

    WebUI.waitForElementVisible(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_description'), 
        GlobalVariable.Timeout, FailureHandling.OPTIONAL)

    WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_description'), findTestData('SupplierTestData/InvoiceItems').getValue('ItemDescription', GlobalVariable.invoiceItem))

    //GlobalVariable.calculatedAmnt as double
    GlobalVariable.calculatedAmnt += findTestData('SupplierTestData/InvoiceItems').getValue('ItemAmnt', GlobalVariable.rowFrom) as double

    //def calcAmnt = GlobalVariable.calculatedAmnt as Integer
    println('----------------------- The calcamount is ' + GlobalVariable.calculatedAmnt)

    WebUI.setText(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/input_amount'), findTestData(
            'SupplierTestData/InvoiceItems').getValue('ItemAmnt', GlobalVariable.rowFrom))

    WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/span_-- Select Expense Type --'))

    def OpexCapexOption = WebUI.modifyObjectProperty(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_SupplierNewInvoiceLoad/div_ExpenseType'), 
        'text', 'equals', findTestData('SupplierTestData/InvoiceItems').getValue('ExpenseType', GlobalVariable.invoiceItem), true)

    WebUI.click(OpexCapexOption)

    WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/span_-- Select Budgeted For --'))

    def IsBudgeted = WebUI.modifyObjectProperty(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/div_Yes'), 
        'text', 'equals', findTestData('SupplierTestData/InvoiceItems').getValue('isBudgeted', GlobalVariable.invoiceItem), true)

    WebUI.click(IsBudgeted)

    WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/span_-- Select Department --'))

	String department = findTestData('SupplierTestData/LoadInvoice').getValue('Dpt', GlobalVariable.rowFrom);
	
    def divDepartment = WebUI.modifyObjectProperty(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/a_Actuarial'), 'text', 'contains', department , true)
	
	WebUI.scrollToElement(divDepartment, GlobalVariable.Timeout)
	
    WebUI.click(divDepartment)

    WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/span_-- Select Budget Item --'))

	//Select the BudgetItem by Index
	//WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/a_BudgetItem'))
	//WebUI.selectOptionByIndex(findTestObject('Object Repository/Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/select_BudgetItem'), 2, FailureHandling.STOP_ON_FAILURE)
	
	//Select the BudgetItem by the ledger number
	String budgetItem = findTestData('SupplierTestData/LoadInvoice').getValue('BudgetItem', GlobalVariable.rowFrom)
	
    def InvoiceItem = WebUI.modifyObjectProperty(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/a_BudgetItem'), 
        'text', 'contains', budgetItem, true)

    WebUI.click(InvoiceItem)
	
    WebUI.takeScreenshot()

    WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/span_-- Select Tax Code --'))

    WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/a_NA'))

    WebUI.click(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/a_Save'))

    WebUI.waitForAngularLoad(GlobalVariable.Timeout)
	
	Thread.sleep(1000)
	
	WebUI.waitForElementVisible(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/a_Add Item'), GlobalVariable.Timeout)
	
	WebUI.waitForElementClickable(findTestObject('Suppliers_OR/NewSupplierInvoicePage_OR/Page_Clientle Unity/a_Add Item'), GlobalVariable.Timeout)
}

println('calculatedAmnt is ' + GlobalVariable.calculatedAmnt)

GlobalVariable.NumberOfInvoiceItems = 1
