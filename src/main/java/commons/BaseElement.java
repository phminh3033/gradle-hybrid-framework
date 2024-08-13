package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.user.HomePageObject;

public class BaseElement extends BasePage {
    WebDriver driver;

    public BaseElement(WebDriver driver) {
        this.driver = driver;
    }

    // Ham nay theo business la bat ki page nao cung nhin thay de thao tac
    public HomePageObject clickToNopCommerceLogo() {
        waitForElementClickable(driver, BaseElementUI.NOPCOMMERCE_LOGO);
        clickToElement(driver, BaseElementUI.NOPCOMMERCE_LOGO);
        //return new HomePageObject(driver); // PageManager 2
        return PageGeneratorManager.getHomePage(driver); // PageManager 3
    }

    /**
     * Pattern Object
     */
    // Ham nay theo business la bat ki page nao cung nhin thay de thao tac
    public void clickToHeaderLinkByName(String pageName) {
        waitForElementClickable(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
        clickToElement(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
    }

    // Thao tac voi bat ki 1 btn o page nao
    public void clickToBtnByText(String btnText) {
        waitForElementClickable(driver, BaseElementUI.DYNAMIC_BTN_BY_NAME, btnText);
        clickToElement(driver, BaseElementUI.DYNAMIC_BTN_BY_NAME, btnText);
    }

    // Get ra error msg cua txt tai bat ki page nao
    public String getTxtErrorMsgByID(String errorMsgID) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_TXT_ERROR_MSG_BY_ID, errorMsgID);
        return getElementText(driver, BaseElementUI.DYNAMIC_TXT_ERROR_MSG_BY_ID, errorMsgID);
    }

    // Nhap vao 1 txt bat ki tai bat ki page nao
    public void enterToTxtByID(String txtID, String valueToSend) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_TXT_BY_ID, txtID);
        sendKeyToElement(driver, BaseElementUI.DYNAMIC_TXT_BY_ID, valueToSend, txtID);
    }

    // Get ra attribute cua txt tai bat ki page nao
    public String getTxtAttributeByID(String txtID) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_TXT_BY_ID, txtID);
        return getElementAttribute(driver, BaseElementUI.DYNAMIC_TXT_BY_ID, "value", txtID);
    }
}
