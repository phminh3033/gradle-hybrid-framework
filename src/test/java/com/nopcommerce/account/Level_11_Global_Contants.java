package com.nopcommerce.account;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;

public class Level_11_Global_Contants extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject userLoginPage;
    private AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;

    private String adminUrl = GlobalConstants.DEV_ADMIN_URL;
    private String endUserUrl = GlobalConstants.DEV_USER_URL;

    private String emailAddress = getRandomEmail();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName, endUserUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_User_To_Admin() {
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTxt("Automatic");
        registerPage.enterToLastNameTxt("FC");
        registerPage.enterToEmailTxt(emailAddress);
        registerPage.enterToPasswordTxt("123456");
        registerPage.enterToConfirmPasswordTxt("123456");

        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMsgTxt(), "Your registration completed");

        homePage = registerPage.clickToNopCommerceLogo();

        // Log out
        homePage.clickToLogoutLink();

        // Home page (User) -> Login page (Admin)
        homePage.openPageUrl(driver, adminUrl);

        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

        adminDashboardPage = adminLoginPage.loginToAdmin(GlobalConstants.DEV_ADMIN_USERNAME, GlobalConstants.DEV_ADMIN_PASS);
        adminDashboardPage.isPageLoadedSuccess(driver);
    }

    @Test
    public void User_02_Admin_To_User() {
        adminLoginPage = adminDashboardPage.clickToLogoutLink();

        // Login page (Admin) -> Home page (User)
        adminLoginPage.openPageUrl(driver, endUserUrl);
        homePage = PageGeneratorManager.getHomePage(driver);

        userLoginPage = homePage.clickToLoginLink();
        homePage = userLoginPage.loginToUser(emailAddress, "123456");


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
