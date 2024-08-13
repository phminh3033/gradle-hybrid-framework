package pageObjects.admin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTxt(String email) {
        waitForElementVisible(driver, AdminLoginPageUI.EMAIL_ADDRESS_TXT);
        sendKeyToElement(driver, AdminLoginPageUI.EMAIL_ADDRESS_TXT, email);
    }

    public void enterToPassTxt(String pass) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TXT);
        sendKeyToElement(driver, AdminLoginPageUI.PASSWORD_TXT, pass);
    }

    public AdminDashboardPageObject clickToLoginBtn() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BTN);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BTN);
        return PageGeneratorManager.getAdminDashboardPage(driver);
    }

    public AdminDashboardPageObject loginToAdmin(String email, String pass) {
        enterToEmailTxt(email);
        enterToPassTxt(pass);
        return clickToLoginBtn();
    }
}
