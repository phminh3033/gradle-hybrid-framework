package pageObjects.facebook;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.facebook.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToCreateAccountBtn() {
        waitForElementClickable(driver, HomePageUI.CREATE_NEW_ACCOUNT_BTN);
        clickToElement(driver, HomePageUI.CREATE_NEW_ACCOUNT_BTN);
    }

    public boolean isFirstNameTxtDisplayed() {
        waitForElementVisible(driver, HomePageUI.FIRSTNAME_TXT);
        return isElementDisplayed(driver, HomePageUI.FIRSTNAME_TXT);
    }

    public boolean isSurNameTxtDisplayed() {
        waitForElementVisible(driver, HomePageUI.SURNAME_TXT);
        return isElementDisplayed(driver, HomePageUI.SURNAME_TXT);
    }

    public boolean isEmailTxtDisplayed() {
        waitForElementVisible(driver, HomePageUI.EMAIL_TXT);
        return isElementDisplayed(driver, HomePageUI.EMAIL_TXT);
    }

    public boolean isConfirmEmailTxtDisplayed() {
        waitForElementVisible(driver, HomePageUI.CONFIRM_EMAIL_TXT);
        return isElementDisplayed(driver, HomePageUI.CONFIRM_EMAIL_TXT);
    }

    public boolean isPassTxtDisplayed() {
        waitForElementVisible(driver, HomePageUI.PASSWORD_TXT);
        return isElementDisplayed(driver, HomePageUI.PASSWORD_TXT);
    }

    public void enterToEmailTxt(String randomEmail) {
        waitForElementVisible(driver, HomePageUI.EMAIL_TXT);
        sendKeyToElement(driver, HomePageUI.EMAIL_TXT, randomEmail);
    }

    public void clickToCloseSignUpPopup() {
        waitForElementClickable(driver, HomePageUI.CLOSE_SIGNUP_POPUP);
        clickToElement(driver, HomePageUI.CLOSE_SIGNUP_POPUP);
        sleepInSecond(2);
    }

    public boolean isFirstNameTxtUnDisplayed() {
        return isElementUnDisplayed(driver, HomePageUI.FIRSTNAME_TXT);
    }

    public boolean isSurNameTxtUnDisplayed() {
        return isElementUnDisplayed(driver, HomePageUI.SURNAME_TXT);
    }

    public boolean isEmailTxtUnDisplayed() {
        return isElementUnDisplayed(driver, HomePageUI.EMAIL_TXT);
    }

    public boolean isConfirmEmailTxtUnDisplayed() {
        return isElementUnDisplayed(driver, HomePageUI.CONFIRM_EMAIL_TXT);
    }

    public boolean isPassTxtUnDisplayed() {
        return isElementUnDisplayed(driver, HomePageUI.PASSWORD_TXT);
    }
}
