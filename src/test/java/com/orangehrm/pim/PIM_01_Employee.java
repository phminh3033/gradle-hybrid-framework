package com.orangehrm.pim;

import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangehrm.*;
import reportConfig.ExtentTestManagerV5;

import java.lang.reflect.Method;

public class PIM_01_Employee extends BaseTest {
    private WebDriver driver;
    private String browserName;
    private String employeeID, firstName, lastName;
    private String driverLicense, licenseExp, nationality, maritalStatus, dob, gender;
    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailsPageObject personalDetailsPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        this.browserName = browserName;

        firstName = "Michael";
        lastName = "Qwen";
        driverLicense = "DF456G45";
        licenseExp = "2025-11-06";
        nationality = "Vietnamese";
        maritalStatus = "Married";
        dob = "1999-05-21";
        gender = "Male";

        driver = getBrowserDriver(browserName, url);
        loginPage = PageGeneratorManager.getLoginPage(driver);

        loginPage.enterToUsernameTxt(GlobalConstants.ORANGE_HRM_ADMIN_USERNAME);
        loginPage.enterToPasswordTxt(GlobalConstants.ORANGE_HRM_ADMIN_PASSWORD);
        dashboardPage = loginPage.clickLoginBtn();
        employeeListPage = dashboardPage.openPIMModule();
    }

    @Test
    public void Employee_01_Add_New(Method method) {
        ExtentTestManagerV5.startTest(method.getName() + "- Run on " + browserName.toUpperCase(), "Employee_01_Add_New");
        addEmployeePage = employeeListPage.clickToAddEmployeeBtn();

        addEmployeePage.enterToFirstnameTxt(firstName);
        addEmployeePage.enterToLastnameTxt(lastName);
        employeeID = addEmployeePage.getEmployeeID();

        addEmployeePage.clickSaveBtn();

        Assert.assertTrue(addEmployeePage.isSuccessMsgDisplayed("Successfully Saved"));
        addEmployeePage.waitForSpinnerIconInvisible();

        personalDetailsPage = PageGeneratorManager.getPersonalDetailsPage(driver);

        Assert.assertTrue(personalDetailsPage.isPersonalDetailHeaderDisplayed());

        personalDetailsPage.waitForSpinnerIconInvisible();

        Assert.assertEquals(personalDetailsPage.getFirstnameValue(), firstName);
        Assert.assertEquals(personalDetailsPage.getLastnameValue(), lastName);
        Assert.assertEquals(personalDetailsPage.getEmployeeIDValue(), employeeID);

        employeeListPage = personalDetailsPage.clickToEmployeeListTab();
        employeeListPage.enterToEmployeeIDTxt(employeeID);
        employeeListPage.clickToSearchBtn();

        Assert.assertTrue(employeeListPage.isValueDisplayedAtColName("Id", "1", employeeID));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColName("First (& Middle) Name", "1", firstName));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColName("Last Name", "1", lastName));
    }

    @Test
    public void Employee_02_Personal_Details(Method method) {
        ExtentTestManagerV5.startTest(method.getName() + "- Run on " + browserName.toUpperCase(), "Employee_02_Personal_Details");
        personalDetailsPage = employeeListPage.clickToEditIconByEmployeeID(employeeID);
        Assert.assertTrue(personalDetailsPage.isPersonalDetailHeaderDisplayed());

        Assert.assertEquals(personalDetailsPage.getFirstnameValue(), firstName);
        Assert.assertEquals(personalDetailsPage.getLastnameValue(), lastName);
        Assert.assertEquals(personalDetailsPage.getEmployeeIDValue(), employeeID);

        personalDetailsPage.enterToDriverLicenseNumTxt(driverLicense);
        personalDetailsPage.enterToLicenseExpiryDatePicker(licenseExp);
        personalDetailsPage.selectToNationalityDropdown(nationality);
        personalDetailsPage.selectToMaritalStatusDropdown(maritalStatus);
        personalDetailsPage.enterToDoBDatePicker(dob);
        personalDetailsPage.selectToRadioBtnByLabelName(gender);
        personalDetailsPage.clickToSaveBtnAtPersonalDetailsPart();

        Assert.assertTrue(addEmployeePage.isSuccessMsgDisplayed("Successfully Updated"));
        addEmployeePage.waitForSpinnerIconInvisible();

        Assert.assertEquals(personalDetailsPage.getDriverLicenseValue(), driverLicense);
        Assert.assertEquals(personalDetailsPage.getLicenseExpValue(), licenseExp);
        Assert.assertEquals(personalDetailsPage.getDoBValue(), dob);
        Assert.assertEquals(personalDetailsPage.getNationalityDropdownSelectedText(), nationality);
        Assert.assertEquals(personalDetailsPage.getMaritalStatusDropdownSelectedText(), maritalStatus);
        Assert.assertTrue(personalDetailsPage.isRadioBtnSelectedByLabelName(gender));
    }

    @AfterClass
    public void afterClass() {
        closingBrowser();
    }
}