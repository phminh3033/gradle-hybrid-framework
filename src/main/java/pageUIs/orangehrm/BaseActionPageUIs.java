package pageUIs.orangehrm;

public class BaseActionPageUIs {
    public static final String SPINNER_ICON = "css=div.oxd-loading-spinner-container";
    public static final String DYNAMIC_SUCCESS_MSG = "xpath=//p[contains(@class,'oxd-text--toast-message') and text()='%s']";
    public static final String DYNAMIC_INDEX_COL_BY_NAME = "xpath=//div[text()='%s']/preceding-sibling::div";
    public static final String DYNAMIC_ROW_VALUE_BY_COL_INDEX_ROW_INDEX = "xpath=//div[@class='oxd-table-card']/div[@role='row'][%s]/div[%s]/div[contains(text(),'%s')]";

    public static final String DYNAMIC_RADIO_BTN_BY_LABEL_NAME = "xpath=//label[text()='%s']/input";
    public static final String DYNAMIC_CHECKBOX_BY_LABEL_NAME = "xpath=//label[text()='%s']/input";
}