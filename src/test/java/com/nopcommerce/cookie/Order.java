package com.nopcommerce.cookie;

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
import pageObjects.user.UserLoginPageObject;


public class Order extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

        loginPage = homePage.clickToLoginLink();

        loginPage.setCookies(driver, Common_Register.cookies);
        loginPage.sleepInSecond(5);
        loginPage.refreshCurrentPage(driver);

        customerPage = homePage.openMyAccountLink();

        // Verify
        Assert.assertEquals(customerPage.getFirstNameTxtAttributeValue(), Common_Register.firstName);
        Assert.assertEquals(customerPage.getLastNameTxtAttributeValue(), Common_Register.lastName);
        Assert.assertEquals(customerPage.getEmailTxtAttributeValue(), Common_Register.emailAddress);

        System.out.println("At Order: " + Common_Register.emailAddress);
    }

    @Test
    public void Order_01_Invalid_Address() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}