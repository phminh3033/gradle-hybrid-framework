package com.nopcommerce.cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;

import java.util.Set;


public class Common_Register extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private static String password;
    public static String emailAddress, firstName, lastName;
    public static Set<Cookie> cookies;

    @Parameters("browser")
    @BeforeTest
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

        firstName = "Automatic";
        lastName = "FC";
        emailAddress = getRandomEmail();
        password = "123456";

        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTxt(firstName);
        registerPage.enterToLastNameTxt(lastName);
        registerPage.enterToEmailTxt(emailAddress);
        registerPage.enterToPasswordTxt(password);
        registerPage.enterToConfirmPasswordTxt(password);

        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMsgTxt(), "Your registration completed");

        /*homePage = registerPage.clickToNopCommerceLogo();
        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTxt(emailAddress);
        loginPage.enterToPasswordTxt(password);

        homePage = loginPage.clickToLoginButton();
        homePage.sleepInSecond(5);*/

        cookies = homePage.getBrowserCookies(driver);
        System.out.println("At common: " + emailAddress);
        System.out.println("At common: " + password);

        driver.quit();
    }
}
