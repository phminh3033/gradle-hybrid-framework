package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.factory.CustomerPageObject;
import pageObjects.user.factory.HomePageObject;
import pageObjects.user.factory.LoginPageObject;
import pageObjects.user.factory.RegisterPageObject;


public class Level_06_Selenium_Page_Factory extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerPageObject customerPage;

    private String emailAddress = getRandomEmail();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        // Mo URL ra o page nao -> Khoi tao page do len
        // Tu page nay chuyen sang page kia -> Khoi tao page do len
        homePage = new HomePageObject(driver);
    }

    @Test
    public void User_01_Register_Empty_data() {
        homePage.clickToRegisterLink();

        // Tu HomePage click vao Register link mo ra trang RegisterPage
        registerPage = new RegisterPageObject(driver);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorMsgText(), "Last name is required.");
        Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Email is required.");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsgText(), "Password is required.");
    }

    @Test
    public void User_02_Register_Invalid_Email() {
        registerPage.clickToNopCommerceLogo();

        //
        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();

        // Tu HomePage click vao Register link mo ra trang RegisterPage
        registerPage = new RegisterPageObject(driver);

        registerPage.enterToFirstNameTxt("Automatic");
        registerPage.enterToLastNameTxt("FC");
        registerPage.enterToEmailTxt("srre@df");
        registerPage.enterToPasswordTxt("123456");
        registerPage.enterToConfirmPasswordTxt("123456");

        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Wrong email");
    }

    // var text = $$("span#Password-error")[0]
    // text.textContent
    @Test
    public void User_03_Register_Invalid_Pass() {
        // Test case for registering a new account
    }

    @Test
    public void User_04_Register_Incorrect_Confirm_Pass() {
        registerPage.clickToNopCommerceLogo();

        //
        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();

        // Tu HomePage click vao Register link mo ra trang RegisterPage
        registerPage = new RegisterPageObject(driver);

        registerPage.enterToPasswordTxt("123456");
        registerPage.enterToConfirmPasswordTxt("123");

        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsgText(), "The password and confirmation password do not match.");
    }

    @Test
    public void User_05_Register_Success() {
        registerPage.clickToNopCommerceLogo();

        //
        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();

        // Tu HomePage click vao Register link mo ra trang RegisterPage
        registerPage = new RegisterPageObject(driver);

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
        registerPage.clickToNopCommerceLogo();
        /*//
        homePage = new HomePageObject(driver);
        homePage.clickToLoginLink();

        // Tu trang home click vao Login link thi qua trang LoginPage
        loginPage = new LoginPageObject(driver);

        // Input Email/Pass
        loginPage.enterToEmailTxt(emailAddress);
        loginPage.enterToPasswordTxt("123456");
        loginPage.clickToLoginButton();

        homePage = new HomePageObject(driver);*/
        homePage.clickToMyAccountLink();

        // Tu trang home click vao MyAccount link thi qua trang CustomerPage
        customerPage = new CustomerPageObject(driver);

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
