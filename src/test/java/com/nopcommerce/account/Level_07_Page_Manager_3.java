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


public class Level_07_Page_Manager_3 extends BaseTest {
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
        registerPage = homePage.clickToRegisterLink();
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorMsgText(), "Last name is required.");
        Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Email is required.");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsgText(), "Password is required.");
    }

    @Test
    public void User_02_Register_Invalid_Email() {
        homePage = registerPage.clickToNopCommerceLogo();
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTxt("Automatic");
        registerPage.enterToLastNameTxt("FC");
        registerPage.enterToEmailTxt("srre@df");
        registerPage.enterToPasswordTxt("123456");
        registerPage.enterToConfirmPasswordTxt("123456");

        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Wrong email");
    }

    @Test
    public void User_03_Register_Invalid_Pass() {
        // Test case for registering a new account
    }

    @Test
    public void User_04_Register_Incorrect_Confirm_Pass() {
        homePage = registerPage.clickToNopCommerceLogo();
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToPasswordTxt("123456");
        registerPage.enterToConfirmPasswordTxt("123");

        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsgText(), "The password and confirmation password do not match.");
    }

    @Test
    public void User_05_Register_Success() {
        homePage = registerPage.clickToNopCommerceLogo();
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTxt("Automatic");
        registerPage.enterToLastNameTxt("FC");
        registerPage.enterToEmailTxt(emailAddress);
        registerPage.enterToPasswordTxt("123456");
        registerPage.enterToConfirmPasswordTxt("123456");

        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMsgTxt(), "Your registration completed");
    }

    @Test
    public void User_06_Login_Success() {
        homePage = registerPage.clickToNopCommerceLogo();

        /*loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTxt(emailAddress);
        loginPage.enterToPasswordTxt("123456");
        homePage = loginPage.clickToLoginButton();*/

        customerPage = homePage.clickToMyAccountLink();


        // Verify
        Assert.assertEquals(customerPage.getFirstNameTxtAttributeValue(), "Automatic");
        Assert.assertEquals(customerPage.getLastNameTxtAttributeValue(), "FC");
        Assert.assertEquals(customerPage.getEmailTxtAttributeValue(), emailAddress);


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
