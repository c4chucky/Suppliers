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

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/a_Banking Details'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/i_caret pull-right'))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Banking Details_OR/input_Choose Bank'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/div_ABSA Bank'))

WebUI.waitForElementVisible(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Banking Details_OR/input_supplierBankAccountNumber'), 
    30)

WebUI.setText(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Banking Details_OR/input_supplierBankAccountNumber'), '9261359194')

WebUI.selectOptionByValue(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/select_CurrentSavingsTransmiss'), 
    'Current', true)

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/a_Validate Banking Details'))

WebUI.takeScreenshot()

