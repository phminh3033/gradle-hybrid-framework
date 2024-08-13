package com.nopcommerce.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_01_DRY {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void Register_01_Empty_data() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.cssSelector("button#register-button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(), "First name is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(), "Last name is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "Password is required.");
    }

    @Test
    public void Register_02_Invalid_Email() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("a.ico-register")).click();

        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automatic");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
        driver.findElement(By.cssSelector("input#Email")).sendKeys("srre@df");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");

        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");
    }

    // var text = $$("span#Password-error")[0]
    // text.textContent
    @Test
    public void Register_03_Invalid_Pass() {
        // Test case for registering a new account
    }

    @Test
    public void Register_04_Incorrect_Confirm_Pass() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("a.ico-register")).click();

        driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123");

        Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");
    }

    @Test
    public void Register_05_Success() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("a.ico-register")).click();

        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automatic");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
        driver.findElement(By.cssSelector("input#Email")).sendKeys(getRandomEmail());
        driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");

        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
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
