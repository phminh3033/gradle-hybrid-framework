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


public class Level_15_Assert_Verify extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private CustomerPageObject customerPage;

    private String emailAddress = getRandomEmail();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_Register_Success() {
        // Verify Register link displayed -> FAILED
        verifyFalse(homePage.isRegisterLinkDisplayed());

        registerPage = homePage.clickToRegisterLink();
        registerPage.clickToRegisterButton();

        // Verify error msg at FirstName txt -> PASSED
        verifyEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");

        // Verify error msg at LastName txt -> FAILED
        verifyEquals(registerPage.getLastNameErrorMsgText(), "Last name is required");

        registerPage.enterToFirstNameTxt("Automatic");
        registerPage.enterToLastNameTxt("FC");
        registerPage.enterToEmailTxt(emailAddress);
        registerPage.enterToPasswordTxt("123456");
        registerPage.enterToConfirmPasswordTxt("123456");

        registerPage.clickToRegisterButton();

        // Verify success msg -> FAILED
        verifyEquals(registerPage.getRegisterSuccessMsgTxt(), "Your registration completed.");
    }

    @Test
    public void User_02_Login_Success() {
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
