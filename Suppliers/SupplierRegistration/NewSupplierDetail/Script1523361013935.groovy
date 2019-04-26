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

WebUI.callTestCase(findTestCase('Suppliers/SupplierLogins/LoginCBrown'), [('Pwrd') : GlobalVariable.Password], FailureHandling.STOP_ON_FAILURE)

//Store the Row number to be changed for the Excell sheet
def row = 4
def drawerButton = findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/Drawer_button');

String randomName = "";
randomName = CustomKeywords.'RandomNameGenerator.randomName'()

//Register New Supplier
WebUI.navigateToUrl('http://unitytest.clientele.local/#/Suppliers/RegisteredSuppliers/')

WebUI.waitForPageLoad(30)

//def drawerButton = findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/Drawer_button');

if (WebUI.verifyElementVisible(drawerButton, FailureHandling.OPTIONAL)) {
	WebUI.click(drawerButton)
}

WebUI.waitForElementVisible(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/SupplierDetails_OR/button_Register New Supplier'), 15)

WebUI.click(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/button_Register New Supplier'))

WebUI.setText(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/input_Name'), randomName)

//WebUI.setText(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/input_Name'), findTestData('SupplierTestData/SupplierRegistration').getValue(1, row))

WebUI.setText(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/SupplierDetails_OR/input_TradingName'), findTestData(
        'SupplierTestData/SupplierRegistration').getValue(1, row))

WebUI.setText(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/SupplierDetails_OR/input_RegistrationNumber'), findTestData(
        'SupplierTestData/SupplierRegistration').getValue(2, row))

WebUI.setText(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/SupplierDetails_OR/input_VATnumber'), findTestData('SupplierTestData/SupplierRegistration').getValue(3, row))

WebUI.click(findTestObject('Suppliers_OR/NewSupplierReg_OR/Page_Clientle Unity/SupplierDetails_OR/input_SelectEntity'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/div_Life Suppliers'))

WebUI.callTestCase(findTestCase('Suppliers/SupplierRegistration/SupplierContactDetails'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Suppliers/SupplierRegistration/SupplierAddressDetails'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Suppliers/SupplierRegistration/SupplierBankDetails'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/a_Other'))

WebUI.selectOptionByValue(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/select_0306090120'), '1', true)

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/span_-- Please Select --'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/div_Yes'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/span_-- Select Supplier Servic'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/div_Advertising'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/a_Create Supplier'))

//Prompt to upload documents
WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/span_Select'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/small_Bank Confirmation'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/button_Ok'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/div_Select File'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/span_Select'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/small_Supplier Registration Fo'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/button_Ok'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/label_Select Document Type'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/span_Select'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/small_Certificate Of Incorpora'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/button_Ok'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/div_Select File'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/span_Select'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/small_BEE Certificate  Sworn A'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/button_Ok'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/span_Select'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/small_VAT Certificate'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/button_Ok'))

WebUI.click(findTestObject('Suppliers_OR/RegisterNewSupplierPage_OR/Page_Clientle Unity/a_Send Supplier For Approval'))

