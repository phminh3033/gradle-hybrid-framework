package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.PersonalDetailsPageUI;

public class PersonalDetailsPageObject extends BaseActions {
    private WebDriver driver;

    public PersonalDetailsPageObject(WebDriver driver) {
        super(driver); // Goi qua constructor cua class cha BaseActions
        this.driver = driver;
    }

    public String getFirstnameValue() {
        waitForElementVisible(driver, PersonalDetailsPageUI.FIRSTNAME_TXT);
        return getElementAttribute(driver, PersonalDetailsPageUI.FIRSTNAME_TXT, "value");
    }

    public String getLastnameValue() {
        waitForElementVisible(driver, PersonalDetailsPageUI.LASTNAME_TXT);
        return getElementAttribute(driver, PersonalDetailsPageUI.LASTNAME_TXT, "value");
    }

    public String getEmployeeIDValue() {
        waitForElementVisible(driver, PersonalDetailsPageUI.EMPLOYEE_ID_TXT);
        return getElementAttribute(driver, PersonalDetailsPageUI.EMPLOYEE_ID_TXT, "value");
    }

    public String getDriverLicenseValue() {
        waitForElementVisible(driver, PersonalDetailsPageUI.DRIVER_LICENSE_NUM_TXT);
        return getElementAttribute(driver, PersonalDetailsPageUI.DRIVER_LICENSE_NUM_TXT, "value");
    }

    public String getLicenseExpValue() {
        waitForElementVisible(driver, PersonalDetailsPageUI.DRIVER_EXP_DATE_PICKER);
        return getElementAttribute(driver, PersonalDetailsPageUI.DRIVER_EXP_DATE_PICKER, "value");
    }

    public String getDoBValue() {
        waitForElementVisible(driver, PersonalDetailsPageUI.DOB_DATE_PICKER);
        return getElementAttribute(driver, PersonalDetailsPageUI.DOB_DATE_PICKER, "value");
    }

    public EmployeeListPageObject clickToEmployeeListTab() {
        waitForElementClickable(driver, PersonalDetailsPageUI.EMPLOYEE_LIST_BTN);
        clickToElement(driver, PersonalDetailsPageUI.EMPLOYEE_LIST_BTN);
        waitForSpinnerIconInvisible();
        return PageGeneratorManager.getEmployeeListPage(driver);
    }

    public boolean isPersonalDetailHeaderDisplayed() {
        waitForElementVisible(driver, PersonalDetailsPageUI.PERSONAL_DETAIL_PAGE_HEADER);
        return isElementDisplayed(driver, PersonalDetailsPageUI.PERSONAL_DETAIL_PAGE_HEADER);
    }

    public void enterToDriverLicenseNumTxt(String driverLicense) {
        waitForElementVisible(driver, PersonalDetailsPageUI.DRIVER_LICENSE_NUM_TXT);
        sendKeyToElement(driver, PersonalDetailsPageUI.DRIVER_LICENSE_NUM_TXT, driverLicense);
    }

    public void enterToLicenseExpiryDatePicker(String licenseExp) {
        waitForElementVisible(driver, PersonalDetailsPageUI.DRIVER_EXP_DATE_PICKER);
        sendKeyToElement(driver, PersonalDetailsPageUI.DRIVER_EXP_DATE_PICKER, licenseExp);
    }

    public void selectToNationalityDropdown(String nationality) {
        waitForElementClickable(driver, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_PARENT);
        selectItemInDropdown(driver, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_PARENT, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_ITEM, nationality);
    }

    public void selectToMaritalStatusDropdown(String maritalStatus) {
        waitForElementClickable(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_PARENT);
        selectItemInDropdown(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_ITEM, maritalStatus);
    }

    public void enterToDoBDatePicker(String dob) {
        waitForElementVisible(driver, PersonalDetailsPageUI.DOB_DATE_PICKER);
        sendKeyToElement(driver, PersonalDetailsPageUI.DOB_DATE_PICKER, dob);
    }

    public void clickToSaveBtnAtPersonalDetailsPart() {
        waitForElementClickable(driver, PersonalDetailsPageUI.SAVE_BTN_AT_PERSONAL_DETAIL);
        clickToElement(driver, PersonalDetailsPageUI.SAVE_BTN_AT_PERSONAL_DETAIL);
    }

    public String getNationalityDropdownSelectedText() {
        return getElementText(driver, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_SELECTED_ITEM);
    }

    public String getMaritalStatusDropdownSelectedText() {
        return getElementText(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_SELECTED_ITEM);
    }
}