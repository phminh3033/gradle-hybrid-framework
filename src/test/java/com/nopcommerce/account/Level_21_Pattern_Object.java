package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;


public class Level_21_Pattern_Object extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;

    private String emailAddress = getRandomEmail();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_Register_Empty_data() {
        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        registerPage.clickToBtnByText("Register");

        Assert.assertEquals(registerPage.getTxtErrorMsgByID("FirstName"), "First name is required.");
        Assert.assertEquals(registerPage.getTxtErrorMsgByID("LastName"), "Last name is required.");
        Assert.assertEquals(registerPage.getTxtErrorMsgByID("Email"), "Email is required.");
        Assert.assertEquals(registerPage.getTxtErrorMsgByID("ConfirmPassword"), "Password is required.");
    }

    @Test
    public void User_02_Register_Invalid_Email() {
        homePage = registerPage.clickToNopCommerceLogo();

        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        registerPage.enterToTxtByID("FirstName", "Automatic");
        registerPage.enterToTxtByID("LastName", "FC");
        registerPage.enterToTxtByID("Email", "srre@df");
        registerPage.enterToTxtByID("Password", "123456");
        registerPage.enterToTxtByID("ConfirmPassword", "123456");

        registerPage.clickToBtnByText("Register");
        Assert.assertEquals(registerPage.getTxtErrorMsgByID("Email"), "Wrong email");
    }

    @Test
    public void User_03_Register_Invalid_Pass() {
        // Test case for registering a new account
    }

    @Test
    public void User_04_Register_Incorrect_Confirm_Pass() {
        homePage = registerPage.clickToNopCommerceLogo();

        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        registerPage.enterToTxtByID("Password", "123456");
        registerPage.enterToTxtByID("ConfirmPassword", "123");

        registerPage.clickToBtnByText("Register");
        Assert.assertEquals(registerPage.getTxtErrorMsgByID("ConfirmPassword"), "The password and confirmation password do not match.");
    }

    @Test
    public void User_05_Register_Success() {
        homePage = registerPage.clickToNopCommerceLogo();

        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        registerPage.enterToTxtByID("FirstName", "Automatic");
        registerPage.enterToTxtByID("LastName", "FC");
        registerPage.enterToTxtByID("Email", emailAddress);
        registerPage.enterToTxtByID("Password", "123456");
        registerPage.enterToTxtByID("ConfirmPassword", "123456");

        registerPage.clickToBtnByText("Register");
        Assert.assertEquals(registerPage.getRegisterSuccessMsgTxt(), "Your registration completed");
    }

    @Test
    public void User_06_Login_Success() {
        homePage = registerPage.clickToNopCommerceLogo();

        homePage.clickToHeaderLinkByName("Log in");
        loginPage = PageGeneratorManager.getUserLoginPage(driver);

        loginPage.enterToTxtByID("Email", emailAddress);
        loginPage.enterToTxtByID("Password", "123456");

        loginPage.clickToBtnByText("Log in");
        homePage = PageGeneratorManager.getHomePage(driver);

        homePage.clickToHeaderLinkByName("My account");
        customerPage = PageGeneratorManager.getCustomerPage(driver);

        // Verify
        Assert.assertEquals(customerPage.getTxtAttributeByID("FirstName"), "Automatic");
        Assert.assertEquals(customerPage.getTxtAttributeByID("LastName"), "FC");
        Assert.assertEquals(customerPage.getTxtAttributeByID("Email"), emailAddress);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
