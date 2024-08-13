package pageObjects.user;

import commons.BaseElement;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.user.HomePageUI;

public class HomePageObject extends BaseElement {
    /*
        BasePage basePage = new BasePage(); // 2
    */

    WebDriver driver; // 1 & 3

    public HomePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click to Register link")
    public RegisterPageObject clickToRegisterLink() {
        /**
         // 1
         driver.findElement(By.xpath(HomePageUI.REGISTER_LINK)).click();

         // 2
         basePage.clickToElement(driver, HomePageUI.REGISTER_LINK);
         */

        // 3
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        // return new RegisterPageObject(driver); // PageManager 2
        return PageGeneratorManager.getRegisterPage(driver); // PageManager 3
    }

    @Step("Click to Login link")
    public UserLoginPageObject clickToLoginLink() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        // return new LoginPageObject(driver); // PageManager 2
        return PageGeneratorManager.getUserLoginPage(driver); // PageManager 3
    }

    @Step("Click to My account link")
    public CustomerPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        //return new CustomerPageObject(driver); // PageManager 2
        return PageGeneratorManager.getCustomerPage(driver); // PageManager 3
    }

    @Step("Click to My account link")
    public CustomerPageObject openMyAccountLink() {
        String myAccountLink = getElementAttribute(driver, HomePageUI.MY_ACCOUNT_LINK, "href");
        openPageUrl(driver, myAccountLink);
        //return new CustomerPageObject(driver); // PageManager 2
        return PageGeneratorManager.getCustomerPage(driver); // PageManager 3
    }

    @Step("Click to Logout link")
    public void clickToLogoutLink() {
        waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
        clickToElement(driver, HomePageUI.LOGOUT_LINK);
    }

    @Step("Verify Register link is displayed")
    public boolean isRegisterLinkDisplayed() {
        waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
        return isElementDisplayed(driver, HomePageUI.REGISTER_LINK);
    }
}
