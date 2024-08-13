package pageUIs.jquery;

public class UploadPageUI {
    public static final String FILE_LOADED_BY_NAME = "xpath=//p[text()='%s']";
    public static final String START_BTN = "css=td>button.start";
    public static final String FILE_UPLOADED_BY_NAME = "xpath=//a[text()='%s']";

    public static final String SPIN_BORDER_ICON_AT_MAIN_CONTENT = "css=div#mainContent>div>div>div.spinner-border";
    public static final String SPIN_BORDER_ICON_AT_MAIN_UPLOAD = "css=div.mainUploadInitInfo>div>div.spinner";
    public static final String MULTIPLE_PROGRESS_BAR_ICON = "css=div.progress";
    public static final String UPLOAD_SUCCESS_MSG = "xpath=//div[contains(@class,'mainUploadSuccess)]//div[text()='%s']";
    public static final String UPLOAD_SUCCESS_LINK = "xpath=//div[contains(@class,'mainUploadSuccessLink)]//a[@class='ajaxLink']";
    public static final String CONTENT_TABLE = "css=div#filesContentTable";
    public static final String DOWNLOAD_BTN_BY_FILE_NAME = "xpath=//span[text()='%s']/parent::a//parent::div/following-sibling::div//span[text()='Download']";
    public static final String PLAY_BTN_BY_FILE_NAME = "xpath=//span[text()='%s']/parent::a//parent::div/following-sibling::div/button[contains(@class,'filesContentOptionPlay')]";
}