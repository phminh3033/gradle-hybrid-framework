package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.AddEmployeePageUI;

public class AddEmployeePageObject extends BaseActions {
    private WebDriver driver;

    public AddEmployeePageObject(WebDriver driver) {
        super(driver); // Goi qua constructor cua class cha BaseActions
        this.driver = driver;
    }

    public void enterToFirstnameTxt(String firstName) {
        waitForElementVisible(driver, AddEmployeePageUI.FIRSTNAME_TXT);
        sendKeyToElement(driver, AddEmployeePageUI.FIRSTNAME_TXT, firstName);
    }

    public void enterToLastnameTxt(String password) {
        waitForElementVisible(driver, AddEmployeePageUI.LASTNAME_TXT);
        sendKeyToElement(driver, AddEmployeePageUI.LASTNAME_TXT, password);
    }

    public void enterToEmployeeIDTxt(String employeeID) {
        waitForElementVisible(driver, AddEmployeePageUI.EMPLOYEE_ID_TXT);
        sendKeyToElement(driver, AddEmployeePageUI.EMPLOYEE_ID_TXT, employeeID);
    }

    public String getEmployeeID() {
        return getElementAttribute(driver, AddEmployeePageUI.EMPLOYEE_ID_TXT, "value");
    }

    public void clickSaveBtn() {
        waitForElementClickable(driver, AddEmployeePageUI.SAVE_BTN);
        clickToElement(driver, AddEmployeePageUI.SAVE_BTN);
    }
}
