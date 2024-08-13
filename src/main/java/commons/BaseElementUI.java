package commons;

public class BaseElementUI {
    public static final String UPLOAD_FILE_TYPE = "css=input[name='files[]']";
    public static final String NOPCOMMERCE_LOGO = "Xpath=//div[@class='header-logo']//img";

    public static final String DYNAMIC_HEADER_LINK_BY_NAME = "xpath=//div[@class='header-links']//a[contains(string(),'%s')]"; // 6 link tren Header
    public static final String DYNAMIC_BTN_BY_NAME = "xpath=//button[text()='%s']";
    public static final String DYNAMIC_TXT_ERROR_MSG_BY_ID = "id=%s-error";
    public static final String DYNAMIC_TXT_BY_ID = "css=input[id='%s']";
}
