package com.nopcommerce.account;/*
package com.nopcommerce.account;

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

import java.lang.reflect.Method;


public class Level_18_Extent_V4 extends BaseTest {
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
        Assert.assertFalse(homePage.isRegisterLinkDisplayed());
        registerPage = homePage.clickToRegisterLink();
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorMsgText(), "Last name is required.");
    }

    @Test
    public void User_02_Register_Success(Method method) {
        registerPage = homePage.clickToRegisterLink();
        registerPage.enterToFirstNameTxt(firstName);
        registerPage.enterToLastNameTxt(lastName);
        registerPage.enterToEmailTxt(emailAddress);
        registerPage.enterToPasswordTxt(password);
        registerPage.enterToConfirmPasswordTxt(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMsgTxt(), "Your registration completed");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
*/
