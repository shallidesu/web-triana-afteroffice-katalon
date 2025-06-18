import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://demoqa.com/')

safeClick(findTestObject('Object Repository/Page_Home DEMOQA/div_forms'))

safeClick(findTestObject('Object Repository/Page_Form DEMOQA/li_practiceForm'))

WebUI.scrollToElement(findTestObject('Object Repository/Page_Form DEMOQA/h5_formTitle'), 3)

safeClick(findTestObject('Object Repository/Page_Form DEMOQA/input_firstName'))

WebUI.setText(findTestObject('Object Repository/Page_Form DEMOQA/input_firstName'), firstName)

safeClick(findTestObject('Object Repository/Page_Form DEMOQA/input_lastName'))

WebUI.setText(findTestObject('Object Repository/Page_Form DEMOQA/input_lastName'), lastName)

safeClick(findTestObject('Object Repository/Page_Form DEMOQA/input_userEmail'))

WebUI.setText(findTestObject('Object Repository/Page_Form DEMOQA/input_userEmail'), email)

//WebUI.scrollToElement(findTestObject('Object Repository/Page_Form DEMOQA/input_selectGender'), 5)
safeClick(findTestObject('Page_Form DEMOQA/input_selectGender', [('gender') : gender]))

safeClick(findTestObject('Object Repository/Page_Form DEMOQA/input_userNumber'))

WebUI.setText(findTestObject('Object Repository/Page_Form DEMOQA/input_userNumber'), noPhone)

//WebUI.scrollToElement(findTestObject('Object Repository/Page_Form DEMOQA/input_dateOfBirthInput'), 0)
safeClick(findTestObject('Object Repository/Page_Form DEMOQA/input_dateOfBirthInput'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Form DEMOQA/select_monthOfBirth'), monthOfBirth, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Form DEMOQA/select_yearOfBirth'), yearOfBirth, true)

safeClick(findTestObject('Page_Form DEMOQA/div_dateOfBirth', [('dateOfBirth') : dateOfBirth]))

safeClick(findTestObject('Object Repository/Page_Form DEMOQA/div_selectSubjects'))

WebUI.setText(findTestObject('Object Repository/Page_Form DEMOQA/input_subjects'), subject)

safeClick(findTestObject('Object Repository/Page_Form DEMOQA/li_subject'))

// Split berdasarkan koma dan hapus spasi di sekitar tiap item
List<String> hobbies = hobby.split(/[;,g\s]+/).findAll { it.trim() }

for (String selectHobby in hobbies) {
//	WebUI.comment("Selecting hobby: " + selectHobby)
	safeClick(findTestObject('Page_Form DEMOQA/input_selectHobby', [('hobby') : selectHobby]))
}

//safeClick(findTestObject('Page_Form DEMOQA/input_selectHobby', [('hobby') : hobby]))

safeClick(findTestObject('Object Repository/Page_Form DEMOQA/textarea_currentAddress'))

WebUI.setText(findTestObject('Object Repository/Page_Form DEMOQA/textarea_currentAddress'), address)

safeClick(findTestObject('Object Repository/Page_Form DEMOQA/div_selectState'))

WebUI.click(findTestObject('Page_Form DEMOQA/select_listState', [('state') : state]))

safeClick(findTestObject('Object Repository/Page_Form DEMOQA/div_selectCity'))

WebUI.click(findTestObject('Page_Form DEMOQA/select_listCity', [('city') : city]))

safeClick(findTestObject('Object Repository/Page_Form DEMOQA/button_submit'))

WebUI.takeFullPageScreenshot()

if (testType == 'P') {
    WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Form DEMOQA/div_succeed'), 3)
} else {
    WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Form DEMOQA/div_succeed'),3)
}

WebUI.closeBrowser() 

def safeClick(TestObject obj) {
    WebUI.scrollToElement(obj, 3)

    WebUI.delay(1)

    WebUI.click(obj)
}

