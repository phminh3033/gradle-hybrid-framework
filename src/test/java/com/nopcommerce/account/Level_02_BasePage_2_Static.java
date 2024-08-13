package com.nopcommerce.account;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_2_Static {
    WebDriver driver;

    // BasePage: Dung tu pham vi cua CLASS
    private BasePage basePage = BasePage.getBasePage(); // Singleton Pattern

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void Register_01_Empty_data() {

        // basePage: Dung tu pham vi cua OBJECT de goi ham ben trong basePage Object
        basePage.openPageUrl(driver,"https://demo.nopcommerce.com/");
        basePage.clickToElement(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
    }

    @Test
    public void Register_02_Invalid_Email() {
        basePage.openPageUrl(driver,"https://demo.nopcommerce.com/");
        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Automatic");
        basePage.sendKeyToElement(driver, "//input[@id='LastName']", "FC");
        basePage.sendKeyToElement(driver, "//input[@id='Email']", "srre@df");
        basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

        basePage.clickToElement(driver,"//button[@id='register-button']");
        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
    }

    // var text = $$("span#Password-error")[0]
    // text.textContent
    @Test
    public void Register_03_Invalid_Pass() {
        // Test case for registering a new account
    }

    @Test
    public void Register_04_Incorrect_Confirm_Pass() {
        basePage.openPageUrl(driver,"https://demo.nopcommerce.com/");
        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123");

        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
    }

    @Test
    public void Register_05_Success() {
        basePage.openPageUrl(driver,"https://demo.nopcommerce.com/");
        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Automatic");
        basePage.sendKeyToElement(driver, "//input[@id='LastName']", "FC");
        basePage.sendKeyToElement(driver, "//input[@id='Email']", getRandomEmail());
        basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

        basePage.clickToElement(driver,"//button[@id='register-button']");
        Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public String getRandomEmail() {
        Random random = new Random();
        return "auto" + random.nextInt(999) + "@gmail.net";
    }
}
