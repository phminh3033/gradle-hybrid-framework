package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.EmployeeListPageUI;

public class EmployeeListPageObject extends BaseActions {
    private WebDriver driver;

    public EmployeeListPageObject(WebDriver driver) {
        super(driver); // Goi qua constructor cua class cha BaseActions
        this.driver = driver;
    }

    public AddEmployeePageObject clickToAddEmployeeBtn() {
        waitForElementClickable(driver, EmployeeListPageUI.ADD_EMPLOYEE_BTN);
        clickToElement(driver, EmployeeListPageUI.ADD_EMPLOYEE_BTN);
        waitForSpinnerIconInvisible();
        return PageGeneratorManager.getAddEmployeePage(driver);
    }

    public void enterToEmployeeIDTxt(String employeeID) {
        waitForElementVisible(driver, EmployeeListPageUI.EMPLOYEE_ID_TXT);
        sendKeyToElement(driver, EmployeeListPageUI.EMPLOYEE_ID_TXT, employeeID);
    }

    public void clickToSearchBtn() {
        waitForElementClickable(driver, EmployeeListPageUI.SEARCH_BTN);
        clickToElement(driver, EmployeeListPageUI.SEARCH_BTN);
        waitForSpinnerIconInvisible();
    }

    public PersonalDetailsPageObject clickToEditIconByEmployeeID(String employeeID) {
        waitForElementClickable(driver, EmployeeListPageUI.EDIT_ICON_BY_EMPLOYEE_ID, employeeID);
        clickToElement(driver, EmployeeListPageUI.EDIT_ICON_BY_EMPLOYEE_ID, employeeID);
        waitForSpinnerIconInvisible();
        return PageGeneratorManager.getPersonalDetailsPage(driver);
    }
}
