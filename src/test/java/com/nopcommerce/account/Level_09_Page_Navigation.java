package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.*;


public class Level_09_Page_Navigation extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private AddressPageObject addressesPage;
    private OrdersPageObject ordersPage;

    private String emailAddress = getRandomEmail();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_Register_Success() {
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

    @Test
    public void User_03_Page_Navigation() {
        // customer -> address
        addressesPage = customerPage.openAddressPage();
        // customer -> order
        ordersPage = customerPage.openOrdersPage();
        // address -> customer
        customerPage = addressesPage.openCustomerPage();
        // address -> order

        // order -> customer

        // order -> address
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
