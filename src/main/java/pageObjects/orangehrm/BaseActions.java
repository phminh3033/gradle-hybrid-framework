package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.BaseActionPageUIs;

public class BaseActions extends BasePage {
    private WebDriver driver;

    public BaseActions(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForSpinnerIconInvisible() {
        waitForListElementsInvisible(driver, BaseActionPageUIs.SPINNER_ICON);
    }

    public boolean isSuccessMsgDisplayed(String successMsg) {
        waitForElementVisible(driver, BaseActionPageUIs.DYNAMIC_SUCCESS_MSG, successMsg);
        return isElementDisplayed(driver, BaseActionPageUIs.DYNAMIC_SUCCESS_MSG, successMsg);
    }

    public boolean isValueDisplayedAtColName(String colName, String rowIndex, String rowValue) {
        int colIndex = getListElementSize(driver, BaseActionPageUIs.DYNAMIC_INDEX_COL_BY_NAME, colName) + 1;
        //div[@class='oxd-table-card']/div[@role='row'][%s]/div[%s]/div[contains(text(),'%s')]
        return isElementDisplayed(driver, BaseActionPageUIs.DYNAMIC_ROW_VALUE_BY_COL_INDEX_ROW_INDEX, rowIndex, String.valueOf(colIndex), rowValue);
    }

    //===============================================
    // KHONG waitVisible vi the input cua custom dropdown/radio btn bi an
    public void selectToRadioBtnByLabelName(String labelName) {
        clickToElementByJS(driver, BaseActionPageUIs.DYNAMIC_RADIO_BTN_BY_LABEL_NAME, labelName);
    }

    public void clickToCheckboxByLabelName(String labelName) {
        if (!isElementSelected(driver, BaseActionPageUIs.DYNAMIC_CHECKBOX_BY_LABEL_NAME, labelName)) {
            clickToElementByJS(driver, BaseActionPageUIs.DYNAMIC_CHECKBOX_BY_LABEL_NAME, labelName);
        }
    }

    public boolean isRadioBtnSelectedByLabelName(String labelName) {
        return isElementSelected(driver, BaseActionPageUIs.DYNAMIC_RADIO_BTN_BY_LABEL_NAME, labelName);
    }

    public boolean isCheckboxSelectedByLabelName(String labelName) {
        return isElementSelected(driver, BaseActionPageUIs.DYNAMIC_CHECKBOX_BY_LABEL_NAME, labelName);
    }
}
