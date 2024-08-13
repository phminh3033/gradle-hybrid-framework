package com.nopcommerce.account;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import reportConfig.ExtentTestManagerV5;

import java.lang.reflect.Method;


public class Level_18_Extent_V5 extends BaseTest {
    private WebDriver driver;
    private String browserName;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;

    private String firstName, lastName, password;
    private String emailAddress = getRandomEmail();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        this.browserName = browserName;
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        firstName = "Automatic";
        lastName = "FC";
        password = "123456";
    }

    @Test
    public void User_01_Register_Validate(Method method) {
        ExtentTestManagerV5.startTest(method.getName() + "- Run on " + browserName.toUpperCase(), "User_01_Register_Validate");

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 1: Verify Register link is displayed");
        Assert.assertFalse(homePage.isRegisterLinkDisplayed());

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 2: Click to Register link");
        registerPage = homePage.clickToRegisterLink();

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 3: Click to Register button");
        registerPage.clickToRegisterButton();

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 4: Verify error msg at First Name txt");
        Assert.assertEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 5: Verify error msg at Last Name txt");
        Assert.assertEquals(registerPage.getLastNameErrorMsgText(), "Last name is required.");
    }

    @Test
    public void User_02_Register_Success(Method method) {
        ExtentTestManagerV5.startTest(method.getName() + "- Run on " + browserName.toUpperCase(), "User_02_Login_Success");

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 1: Click to Register link");
        registerPage = homePage.clickToRegisterLink();

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 2: Enter to First Name txt is " + firstName);
        registerPage.enterToFirstNameTxt(firstName);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 3: Enter to Last Name txt is " + lastName);
        registerPage.enterToLastNameTxt(lastName);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 4: Enter to Email txt is " + emailAddress);
        registerPage.enterToEmailTxt(emailAddress);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 5: Enter to Password txt is " + password);
        registerPage.enterToPasswordTxt(password);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 6: Enter to Confirm Password txt is " + password);
        registerPage.enterToConfirmPasswordTxt(password);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 7: Click to Register button");
        registerPage.clickToRegisterButton();

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 8: Verify success msg is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMsgTxt(), "Your registration completed");
    }

    @AfterClass
    public void afterClass() {
        //closingBrowser();
    }
}
