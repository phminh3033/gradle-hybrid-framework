package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;


public class Level_17_ReportNG extends BaseTest {
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

        firstName = "Automatic";
        lastName = "FC";
        password = "123456";
    }

    @Test
    public void User_01_Register_Validate() {
        log.info("Register - Step 1: Verify Register link is displayed");
        verifyFalse(homePage.isRegisterLinkDisplayed());

        log.info("Register - Step 2: Click to Register link");
        registerPage = homePage.clickToRegisterLink();

        log.info("Register - Step 3: Click to Register button");
        registerPage.clickToRegisterButton();

        log.info("Register - Step 4: Verify error msg at First Name txt");
        verifyEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");

        log.info("Register - Step 5: Verify error msg at Last Name txt");
        verifyEquals(registerPage.getLastNameErrorMsgText(), "Last name is required.");
    }

    @Test
    public void User_02_Register_Success() {
        log.info("Register - Step 6: Enter to First Name txt is " + firstName);
        registerPage.enterToFirstNameTxt(firstName);

        log.info("Register - Step 7: Enter to Last Name txt is " + lastName);
        registerPage.enterToLastNameTxt(lastName);

        log.info("Register - Step 8: Enter to Email txt is " + emailAddress);
        registerPage.enterToEmailTxt(emailAddress);

        log.info("Register - Step 9: Enter to Password txt is " + password);
        registerPage.enterToPasswordTxt(password);

        log.info("Register - Step 10: Enter to Confirm Password txt is " + password);
        registerPage.enterToConfirmPasswordTxt(password);

        log.info("Register - Step 11: Click to Register button");
        registerPage.clickToRegisterButton();

        log.info("Register - Step 12: Verify success msg is displayed");
        verifyEquals(registerPage.getRegisterSuccessMsgTxt(), "Your registration completed.");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
