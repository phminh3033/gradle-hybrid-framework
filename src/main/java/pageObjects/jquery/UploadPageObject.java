package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.UploadPageUI;

import java.util.List;

public class UploadPageObject extends BasePage {
    WebDriver driver;

    public UploadPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFileLoadedSuccess(String fileName) {
        waitForElementVisible(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
        return isElementDisplayed(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
    }

    public void clickStartBtnOnEachFile() {
        List<WebElement> startBtns = getListWebElements(driver, UploadPageUI.START_BTN);
        for (WebElement startBtn : startBtns) {
            waitForElementClickable(driver, startBtn);
            clickToElement(driver, startBtn);
            sleepInSecond(1);
        }
    }

    public boolean isFileUploadedSuccess(String fileName) {
        waitForElementVisible(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
        return isElementDisplayed(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
    }

    public boolean isLoadingIconAtMainContentDisappear() {
        return waitForElementInvisible(driver, UploadPageUI.SPIN_BORDER_ICON_AT_MAIN_CONTENT);
    }

    public boolean isLoadingIconAtMainUploadDisappear() {
        return waitForElementInvisible(driver, UploadPageUI.SPIN_BORDER_ICON_AT_MAIN_UPLOAD);
    }

    public boolean isMultipleProgressBarIconDisappear() {
        return waitForListElementsInvisible(driver, UploadPageUI.MULTIPLE_PROGRESS_BAR_ICON);
    }

    public boolean isSuccessMsgDisplayed(String successMsg) {
        waitForElementVisible(driver, UploadPageUI.UPLOAD_SUCCESS_MSG, successMsg);
        return isElementDisplayed(driver, UploadPageUI.UPLOAD_SUCCESS_MSG, successMsg);
    }

    public void clickToSuccessLink() {
        waitForElementClickable(driver, UploadPageUI.UPLOAD_SUCCESS_LINK);
        clickToElement(driver, UploadPageUI.UPLOAD_SUCCESS_LINK);
    }

    public boolean isContentTableDisplayed() {
        waitForElementVisible(driver, UploadPageUI.CONTENT_TABLE);
        return isElementDisplayed(driver, UploadPageUI.CONTENT_TABLE);
    }

    public boolean isDownloadBtnDisplayed(String benz) {
        waitForListElementsVisible(driver, UploadPageUI.DOWNLOAD_BTN_BY_FILE_NAME);
        return isElementDisplayed(driver, UploadPageUI.DOWNLOAD_BTN_BY_FILE_NAME);
    }

    public boolean isPlayBtnDisplayed(String benz) {
        waitForListElementsVisible(driver, UploadPageUI.PLAY_BTN_BY_FILE_NAME);
        return isElementDisplayed(driver, UploadPageUI.PLAY_BTN_BY_FILE_NAME);
    }

}