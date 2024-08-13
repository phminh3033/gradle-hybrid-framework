package pageObjects.user;

import commons.BaseElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.user.RegisterPageUI;

public class RegisterPageObject extends BaseElement {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click to Register button")
    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    @Step("Get FIRSTNAME_ERROR_MSG")
    public String getFirstNameErrorMsgText() {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
        return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
    }

    @Step("Get LASTNAME_ERROR_MSG")
    public String getLastNameErrorMsgText() {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
        return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
    }

    @Step("Get EMAIL_ERROR_MSG")
    public String getEmailErrorMsgText() {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MSG);
        return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MSG);
    }

    @Step("Get CONFIRM_PASSWORD_ERROR_MSG")
    public String getConfirmPasswordErrorMsgText() {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
        return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
    }

    @Step("Enter to FIRSTNAME_TEXTBOX with value is {0}")
    public void enterToFirstNameTxt(String firstName) {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    @Step("Enter to LASTNAME_TEXTBOX with value is {0}")
    public void enterToLastNameTxt(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
    }

    @Step("Enter to EMAIL_TEXTBOX with value is {0}")
    public void enterToEmailTxt(String email) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
    }

    @Step("Enter to PASSWORD_TEXTBOX with value is {0}")
    public void enterToPasswordTxt(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Enter to CONFIRM_PASSWORD_TEXTBOX with value is {0}")
    public void enterToConfirmPasswordTxt(String confirmPassword) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    @Step("Verify the register success msg is displayed")
    public String getRegisterSuccessMsgTxt() {
        waitForElementVisible(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
        return getElementText(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
    }
}
