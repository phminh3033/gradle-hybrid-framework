package com.nopcommerce.share;

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

public class Product extends BaseTest {
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

        loginPage.enterToEmailTxt(Common_Register.emailAddress);
        loginPage.enterToPasswordTxt(Common_Register.password);
        homePage = loginPage.clickToLoginButton();

        customerPage = homePage.clickToMyAccountLink();

        // Verify
        Assert.assertEquals(customerPage.getFirstNameTxtAttributeValue(), Common_Register.firstName);
        Assert.assertEquals(customerPage.getLastNameTxtAttributeValue(), Common_Register.lastName);
        Assert.assertEquals(customerPage.getEmailTxtAttributeValue(), Common_Register.emailAddress);

        System.out.println("At Product: " + Common_Register.emailAddress);
        System.out.println("At Product: " + Common_Register.password);
    }

    @Test
    public void Product_01_New_Product() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}