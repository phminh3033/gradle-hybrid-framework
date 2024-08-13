package pageUIs.orangehrm;

public class PersonalDetailsPageUI {
    public static final String FIRSTNAME_TXT = "css=input[name='firstName']";
    public static final String LASTNAME_TXT = "css=input[name='lastName']";
    public static final String EMPLOYEE_ID_TXT = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String EMPLOYEE_LIST_BTN = "xpath=//a[text()='Employee List']";
    public static final String PERSONAL_DETAIL_PAGE_HEADER = "xpath=//h6[text()='Personal Details']";

    public static final String DRIVER_LICENSE_NUM_TXT = "xpath=//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div//input";
    public static final String DRIVER_EXP_DATE_PICKER = "xpath=//label[text()='License Expiry Date']/parent::div/following-sibling::div//input";

    public static final String NATIONALITY_DROPDOWN_PARENT = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//i";
    public static final String NATIONALITY_DROPDOWN_ITEM = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-dropdown')]//span";
    public static final String NATIONALITY_DROPDOWN_SELECTED_ITEM = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";

    public static final String MARITAL_STATUS_DROPDOWN_PARENT = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//i";
    public static final String MARITAL_STATUS_DROPDOWN_ITEM = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-dropdown')]//span";
    public static final String MARITAL_STATUS_DROPDOWN_SELECTED_ITEM = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";

    public static final String DOB_DATE_PICKER = "xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";
    public static final String SAVE_BTN_AT_PERSONAL_DETAIL = "xpath=//div[contains(@class,'orangehrm-horizontal-padding')]//button[contains(string(),'Save')]";
}