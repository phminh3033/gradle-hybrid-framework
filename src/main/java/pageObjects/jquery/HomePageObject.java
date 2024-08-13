package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.HomePageUI;

import java.util.ArrayList;
import java.util.List;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToColTextboxByName(String colName, String valueToSend) {
        waitForElementVisible(driver, HomePageUI.COL_TXT_BY_NAME, colName);
        sendKeyToElement(driver, HomePageUI.COL_TXT_BY_NAME, valueToSend, colName);
    }

    public void clickToPageNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
        clickToElement(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
    }

    public boolean isPageActiveByNumber(String pageNumber) {
        waitForElementVisible(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
        return isElementDisplayed(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
    }

    public boolean isRowValueDisplayed(String female, String country, String male, String total) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_ROW_VALUE, female, country, male, total);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_ROW_VALUE, female, country, male, total);
    }

    public void clickToRowActionByCountryName(String country, String rowAction) {
        waitForElementClickable(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, country, rowAction);
        clickToElement(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, country, rowAction);
    }

    public List<String> getAllValueByColName(String colName) {
        List<String> allValues = new ArrayList<String>();
        // B1: Lay ra all pages
        List<WebElement> allPagesLinks = getListWebElements(driver, HomePageUI.ALL_PAGES_LINK);
        int colIndex = getListElementSize(driver, HomePageUI.COL_INDEX_BY_COL_NAME, colName) + 1;

        // B2: Duyet qua tung page
        for (WebElement pageLink : allPagesLinks) {
            pageLink.click();
            sleepInSecond(1);
            // B3: Lat ra tat ca cac gia tri cua 1 cot trong page do -> Luu vao List/Set/...
            List<WebElement> allRowValues = getListWebElements(driver, HomePageUI.ALL_VALUE_BY_COL_NAME, String.valueOf(colIndex));
            for (WebElement rowValue : allRowValues) {
                allValues.add(rowValue.getText());
            }
            // B4: Duyet het cac page con lai
        }
        // In het allValues cua 1 cot trong allPages
        for (String value : allValues) {
            System.out.println(value);
        }
        //Sort ASC/DESC
        return allValues;
    }

    public List<String> getAllValueByColNameInDB(String country) {
        //Sort ASC/DESC
        return null;
    }

    public List<String> getAllValueByColNameInAPI(String country) {
        //Sort ASC/DESC
        return null;
    }

    public void enterToTxtByColNameAndRowIndex(String colName, String rowIndex, String valueToSend) {
        int colIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COL_INDEX_BY_COL_NAME, colName) + 1;
        sendKeyToElement(driver, HomePageUI.DYNAMIC_TXT_ROW_INDEX_AND_COL_INDEX, valueToSend, rowIndex, String.valueOf(colIndex));
    }

    public void selectDropdownByColNameAndRowIndex(String colName, String rowIndex, String dropdownItem) {
        int colIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COL_INDEX_BY_COL_NAME, colName) + 1;
        waitForElementClickable(driver, HomePageUI.DYNAMIC_DROPDOWN_ROW_INDEX_AND_COL_INDEX, rowIndex, String.valueOf(colIndex));
        selectItemInDefaultDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_ROW_INDEX_AND_COL_INDEX, dropdownItem, rowIndex, String.valueOf(colIndex));
    }

    public void selectCheckboxByColNameAndRowIndex(String colName, String rowIndex) {
        int colIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COL_INDEX_BY_COL_NAME, colName) + 1;
        waitForElementClickable(driver, HomePageUI.DYNAMIC_CHECKBOX_ROW_INDEX_AND_COL_INDEX, rowIndex, String.valueOf(colIndex));
        checkToElement(driver, HomePageUI.DYNAMIC_CHECKBOX_ROW_INDEX_AND_COL_INDEX, rowIndex, String.valueOf(colIndex));
    }
}
