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

def row = 3

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/a_Address Details'))

WebUI.setText(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/input_physicalStreet'), findTestData('SupplierTestData/SupplierRegistration').getValue(
        4, row))

WebUI.setText(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/input_physicalSuburb'), findTestData('SupplierTestData/SupplierRegistration').getValue(
        5, row))

WebUI.setText(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/input_physicalTown'), findTestData('SupplierTestData/SupplierRegistration').getValue(
        6, row))

WebUI.selectOptionByIndex(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/select_Eastern CapeFree StateG'), 
    '2', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_SupplierAddress_OR/input_physicalCode'), 15)

WebUI.setText(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/input_physicalCode'), findTestData('SupplierTestData/SupplierRegistration').getValue(
        7, row))

WebUI.setText(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/input_PostalStreet'), findTestData('SupplierTestData/SupplierRegistration').getValue(
        4, row))

WebUI.setText(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/input_PostalSuburb'), findTestData('SupplierTestData/SupplierRegistration').getValue(
        5, row))

WebUI.setText(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/input_PostalTown'), findTestData('SupplierTestData/SupplierRegistration').getValue(
        6, row))

WebUI.selectOptionByIndex(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/select_Eastern CapeFree StateG_1'), 
    '2', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_SupplierAddress_OR/input_PostalCode'), 15)

WebUI.setText(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_SupplierAddress_OR/input_PostalCode'), findTestData('SupplierTestData/SupplierRegistration').getValue(
        7, row))

