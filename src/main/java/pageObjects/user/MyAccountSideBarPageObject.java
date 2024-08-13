package pageObjects.user;

import commons.BaseElement;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.user.MyAccountSideBarPageUI;

public class MyAccountSideBarPageObject extends BaseElement {
    WebDriver driver;

    public MyAccountSideBarPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /*------------------------------------------Pages----------------------------------------------*/

    public CustomerPageObject openCustomerPage() {
        waitForElementVisible(driver, MyAccountSideBarPageUI.CUSTOMER_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.CUSTOMER_LINK_TEXT);
        return PageGeneratorManager.getCustomerPage(driver);
    }

    public AddressPageObject openAddressPage() {
        waitForElementVisible(driver, MyAccountSideBarPageUI.ADDRESS_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.ADDRESS_LINK_TEXT);
        return PageGeneratorManager.getAddressPage(driver);
    }

    public OrdersPageObject openOrdersPage() {
        waitForElementVisible(driver, MyAccountSideBarPageUI.ORDERS_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.ORDERS_LINK_TEXT);
        return PageGeneratorManager.getOrdersPage(driver);
    }

    public MyAccountSideBarPageObject openDynamicSideBarPage(String pageName) {
        waitForElementClickable(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
        clickToElement(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);

        switch (pageName) {
            case "Customer info":
                return PageGeneratorManager.getCustomerPage(driver);
            case "Addresses":
                return PageGeneratorManager.getAddressPage(driver);
            case "Orders":
                return PageGeneratorManager.getOrdersPage(driver);
            default:
                new RuntimeException("Sidebar page name incorrect");
                return null;
        }
    }

    public void openDynamicSideBarPageByName(String pageName) {
        waitForElementClickable(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
        clickToElement(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
    }
}
