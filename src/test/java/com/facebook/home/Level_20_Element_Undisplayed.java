package com.facebook.home;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;
import reportConfig.ExtentTestManagerV5;

import java.lang.reflect.Method;


public class Level_20_Element_Undisplayed extends BaseTest {
    WebDriver driver;
    private String browserName;
    HomePageObject homePage;

    private String emailAddress = getRandomEmail();

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        this.browserName = browserName;
        driver = getBrowserDriver(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void Home_01_Element_Displayed(Method method) {
        ExtentTestManagerV5.startTest(method.getName() + "- Run on " + browserName.toUpperCase(), "Home_01_Element_Displayed");

        ExtentTestManagerV5.getTest().log(Status.INFO, "FB Register - Step 1: Click to Create Account button");
        homePage.clickToCreateAccountBtn();

        ExtentTestManagerV5.getTest().log(Status.INFO, "FB Register - Step 2: Verify firstname txt is displayed");
        Assert.assertTrue(homePage.isFirstNameTxtDisplayed());
        ExtentTestManagerV5.getTest().log(Status.INFO, "FB Register - Step 3: Verify surname txt is displayed");
        Assert.assertTrue(homePage.isSurNameTxtDisplayed());
        ExtentTestManagerV5.getTest().log(Status.INFO, "FB Register - Step 4: Verify email txt is displayed");
        Assert.assertTrue(homePage.isEmailTxtDisplayed());
        ExtentTestManagerV5.getTest().log(Status.INFO, "FB Register - Step 5: Verify password txt is displayed");
        Assert.assertTrue(homePage.isPassTxtDisplayed());

        ExtentTestManagerV5.getTest().log(Status.INFO, "FB Register - Step 6: Enter to Email txt is " + emailAddress);
        homePage.enterToEmailTxt(emailAddress);

        ExtentTestManagerV5.getTest().log(Status.INFO, "FB Register - Step 7: Verify ConfirmEmail txt is displayed");
        log.info("Verify Confirm Email txt is displayed");
        Assert.assertTrue(homePage.isConfirmEmailTxtDisplayed());
    }

    @Test(enabled = false)
    public void Home_02_Element_Undisplayed_In_HTML() {
        homePage.enterToEmailTxt("");
        homePage.sleepInSecond(2);

        // Element van co trong HTML
        log.info("Verify Confirm Email txt is not displayed");
        verifyFalse(homePage.isConfirmEmailTxtDisplayed());
        verifyTrue(homePage.isConfirmEmailTxtUnDisplayed());
    }

    @Test(enabled = false)
    public void Home_03_Element_Undisplayed_NOT_In_HTML_01() {
        homePage.clickToCloseSignUpPopup();

        log.info("Verify Firstname txt is not displayed");
        verifyFalse(homePage.isFirstNameTxtDisplayed());

        log.info("Verify Surname txt is not displayed");
        verifyFalse(homePage.isSurNameTxtDisplayed());

        log.info("Verify Email txt is not displayed");
        verifyFalse(homePage.isEmailTxtDisplayed());

        log.info("Verify Pass txt is not displayed");
        verifyFalse(homePage.isPassTxtDisplayed());
    }

    @Test(enabled = false)
    public void Home_03_Element_Undisplayed_NOT_In_HTML_02() {
        log.info("Verify Firstname txt is not displayed");
        verifyTrue(homePage.isFirstNameTxtUnDisplayed());

        log.info("Verify Surname txt is not displayed");
        verifyTrue(homePage.isSurNameTxtUnDisplayed());

        log.info("Verify Email txt is not displayed");
        verifyTrue(homePage.isEmailTxtUnDisplayed());

        log.info("Verify Pass txt is not displayed");
        verifyTrue(homePage.isPassTxtUnDisplayed());
    }

    @AfterClass
    public void afterClass() {
        closingBrowser();
    }
}
