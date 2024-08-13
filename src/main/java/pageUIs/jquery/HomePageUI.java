package pageUIs.jquery;

public class HomePageUI {
    public static final String COL_TXT_BY_NAME = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
    public static final String PAGE_LINK_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link' and text()='%s']";
    public static final String PAGE_LINK_ACTIVE_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
    public static final String DYNAMIC_ROW_VALUE = "xpath=//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
    public static final String ROW_ACTION_BY_COUNTRY_NAME = "xpath=//td[@data-key='country' and text()='%s']//preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'%s')]";
    public static final String ALL_PAGES_LINK = "xpath=//a[contains(@class,'qgrd-pagination-page-link')]";
    public static final String COL_INDEX_BY_COL_NAME = "xpath=//div[text()='%s']/ancestor::th/preceding-sibling::th";
    public static final String ALL_VALUE_BY_COL_NAME = "xpath=//tr/td[%s]";

    //
    public static final String DYNAMIC_COL_INDEX_BY_COL_NAME = "xpath=//th[text()='%s']/preceding-sibling::th";
    public static final String DYNAMIC_TXT_ROW_INDEX_AND_COL_INDEX = "xpath=//tr[%s]/td[%s]/input";
    public static final String DYNAMIC_DROPDOWN_ROW_INDEX_AND_COL_INDEX = "xpath=//tr[%s]/td[%s]//select";
    public static final String DYNAMIC_CHECKBOX_ROW_INDEX_AND_COL_INDEX = "xpath=//tr[%s]/td[%s]//input[@type='checkbox']";

}
