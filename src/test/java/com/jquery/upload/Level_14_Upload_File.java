package com.jquery.upload;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.PageGeneratorManager;
import pageObjects.jquery.UploadPageObject;


public class Level_14_Upload_File extends BaseTest {
    WebDriver driver;
    UploadPageObject uploadPage;
    String benz = "benz.jpg";
    String car = "car.jpg";
    String monitor = "monitor.jpg";

    String[] fileNames = {benz, car, monitor};

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        uploadPage = PageGeneratorManager.getUploadPage(driver);
    }

    //@Test
    public void TC_01_Upload_Single_File() {
        uploadPage.upLoadMultipleFiles(driver, benz);
        uploadPage.upLoadMultipleFiles(driver, car);
        uploadPage.upLoadMultipleFiles(driver, monitor);

        Assert.assertTrue(uploadPage.isFileLoadedSuccess(benz));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(car));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(monitor));

        uploadPage.clickStartBtnOnEachFile();

        Assert.assertTrue(uploadPage.isFileUploadedSuccess(benz));
        Assert.assertTrue(uploadPage.isFileUploadedSuccess(car));
        Assert.assertTrue(uploadPage.isFileUploadedSuccess(monitor));
    }

    //@Test
    public void TC_02_Upload_Multiple_File() {
        uploadPage.refreshCurrentPage(driver);
        uploadPage.upLoadMultipleFiles(driver, fileNames);

        Assert.assertTrue(uploadPage.isFileLoadedSuccess(benz));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(car));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(monitor));

        uploadPage.clickStartBtnOnEachFile();

        Assert.assertTrue(uploadPage.isFileUploadedSuccess(benz));
        Assert.assertTrue(uploadPage.isFileUploadedSuccess(car));
        Assert.assertTrue(uploadPage.isFileUploadedSuccess(monitor));
    }

    @Test
    public void TC_03_Upload_GoFile() {
        uploadPage.openPageUrl(driver, "https://gofile.io/?t=uploadFiles");

        Assert.assertTrue(uploadPage.isLoadingIconAtMainContentDisappear());

        uploadPage.upLoadMultipleFiles(driver, fileNames);

        Assert.assertTrue(uploadPage.isLoadingIconAtMainUploadDisappear());

        Assert.assertTrue(uploadPage.isMultipleProgressBarIconDisappear());

        Assert.assertTrue(uploadPage.isSuccessMsgDisplayed("Your files have been successfully uploaded"));

        uploadPage.clickToSuccessLink();

        Assert.assertTrue(uploadPage.isContentTableDisplayed());

        Assert.assertTrue(uploadPage.isDownloadBtnDisplayed(benz));
        Assert.assertTrue(uploadPage.isDownloadBtnDisplayed(car));
        Assert.assertTrue(uploadPage.isDownloadBtnDisplayed(monitor));

        Assert.assertTrue(uploadPage.isPlayBtnDisplayed(benz));
        Assert.assertTrue(uploadPage.isPlayBtnDisplayed(car));
        Assert.assertTrue(uploadPage.isPlayBtnDisplayed(monitor));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
