package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.PropertiesConfig;

public class Level_31_Multiple_Env_03_Java_Properties extends BaseTest {
    private WebDriver driver;
    PropertiesConfig propConfig;

    @Parameters({"browser", "server"})
    @BeforeClass
    public void beforeClass(String browserName, String server) {
        propConfig = PropertiesConfig.getProperties(server);
        driver = getBrowserDriver(browserName, propConfig.getApplicationUrl());
        System.out.println(propConfig.getApplicationUrl());
        System.out.println(propConfig.getApplicationUserName());
        System.out.println(propConfig.getApplicationPassword());
    }

    @Test
    public void User_01_Register_Validate() {
    }

    @Test
    public void User_02_Register_Success() {
    }

    @Test
    public void User_03_Login_Success() {
    }

    @AfterClass
    public void afterClass() {
        //closingBrowser();
    }
}