package com.nopcommerce.account;

import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.EnvConfig;

/**
 * Run with cmd
 */

public class Level_31_Multiple_Env_04_Owner extends BaseTest {
    private WebDriver driver;
    EnvConfig envConfig;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        String serverName = System.getProperty("env");
        ConfigFactory.setProperty("server", serverName);

        envConfig = ConfigFactory.create(EnvConfig.class);
        System.out.println(envConfig.appUrl());
        System.out.println(envConfig.appUserName());
        System.out.println(envConfig.appPassword());
        System.out.println(envConfig.dbUrl());

        driver = getBrowserDriver(browserName, envConfig.appUrl());
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