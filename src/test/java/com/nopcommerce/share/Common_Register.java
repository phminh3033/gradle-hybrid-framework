package com.nopcommerce.share;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;


public class Common_Register extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    public static String emailAddress, password, firstName, lastName;

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

        System.out.println("At common: " + emailAddress);
        System.out.println("At common: " + password);

        driver.quit();
        System.out.println("quit");
    }
}