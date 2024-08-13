package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.LoginPageUI;

public class LoginPageObject extends BaseActions {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        super(driver); // Goi qua constructor cua class cha BaseActions
        this.driver = driver;
    }

    public void enterToUsernameTxt(String userName) {
        waitForElementVisible(driver, LoginPageUI.USER_NAME_TXT);
        sendKeyToElement(driver, LoginPageUI.USER_NAME_TXT, userName);
    }

    public void enterToPasswordTxt(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TXT);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TXT, password);
    }

    public DashboardPageObject clickLoginBtn() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BTN);
        clickToElement(driver, LoginPageUI.LOGIN_BTN);
        waitForSpinnerIconInvisible();
        return PageGeneratorManager.getDashboardPage(driver);
    }
}