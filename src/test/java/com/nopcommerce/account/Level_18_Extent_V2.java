package com.nopcommerce.account;/*
package com.nopcommerce.account;

import com.relevantcodes.extentreports.LogStatus;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.*;
import reportConfig.ExtentManagerV2;

import java.lang.reflect.Method;


public class Level_18_Extent_V2 extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;

    private String firstName, lastName, password;
    private String emailAddress = getRandomEmail();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        firstName = "Automatic";
        lastName = "FC";
        password = "123456";
    }

    @Test
    public void User_01_Register_Validate(Method method) {
        ExtentManagerV2.startTest(method.getName(), "User_01_Register_Validate");

        ExtentManagerV2.getTest().log(LogStatus.INFO, "Register - Step 1: Verify Register link is displayed");
        Assert.assertFalse(homePage.isRegisterLinkDisplayed());

        ExtentManagerV2.getTest().log(LogStatus.INFO,"Register - Step 2: Click to Register link");
        registerPage = homePage.clickToRegisterLink();

        ExtentManagerV2.getTest().log(LogStatus.INFO,"Register - Step 3: Click to Register button");
        registerPage.clickToRegisterButton();

        ExtentManagerV2.getTest().log(LogStatus.INFO,"Register - Step 4: Verify error msg at First Name txt");
        Assert.assertEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");

        ExtentManagerV2.getTest().log(LogStatus.INFO,"Register - Step 5: Verify error msg at Last Name txt");
        Assert.assertEquals(registerPage.getLastNameErrorMsgText(), "Last name is required.");
    }

    @Test
    public void User_02_Register_Success(Method method) {
        ExtentManagerV2.startTest(method.getName(), "User_02_Login_Success");

        ExtentManagerV2.getTest().log(LogStatus.INFO,"Register - Step 1: Click to Register link");
        registerPage = homePage.clickToRegisterLink();

        ExtentManagerV2.getTest().log(LogStatus.INFO,"Register - Step 2: Enter to First Name txt is " + firstName);
        registerPage.enterToFirstNameTxt(firstName);

        ExtentManagerV2.getTest().log(LogStatus.INFO,"Register - Step 3: Enter to Last Name txt is " + lastName);
        registerPage.enterToLastNameTxt(lastName);

        ExtentManagerV2.getTest().log(LogStatus.INFO,"Register - Step 4: Enter to Email txt is " + emailAddress);
        registerPage.enterToEmailTxt(emailAddress);

        ExtentManagerV2.getTest().log(LogStatus.INFO,"Register - Step 5: Enter to Password txt is " + password);
        registerPage.enterToPasswordTxt(password);

        ExtentManagerV2.getTest().log(LogStatus.INFO,"Register - Step 6: Enter to Confirm Password txt is " + password);
        registerPage.enterToConfirmPasswordTxt(password);

        ExtentManagerV2.getTest().log(LogStatus.INFO,"Register - Step 7: Click to Register button");
        registerPage.clickToRegisterButton();

        ExtentManagerV2.getTest().log(LogStatus.INFO,"Register - Step 8: Verify success msg is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMsgTxt(), "Your registration completed");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
*/
