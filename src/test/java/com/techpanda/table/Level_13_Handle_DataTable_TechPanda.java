package com.techpanda.table;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

import java.util.ArrayList;
import java.util.List;


public class Level_13_Handle_DataTable_TechPanda extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    List<String> allValuesUI = new ArrayList<String>();
    List<String> allValuesDB = new ArrayList<String>();
    List<String> allValuesAPI = new ArrayList<String>();

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    //@Test
    public void TC_01_Search() {
        // Search data tren header cua table
        homePage.enterToColTextboxByName("Females", "24128");
        homePage.enterToColTextboxByName("Total", "107000");
        homePage.enterToColTextboxByName("Males", "4490");
        homePage.enterToColTextboxByName("Country", "Western Europe");
    }

    //@Test
    public void TC_02_Paging() {
        homePage.clickToPageNumber("2");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isPageActiveByNumber("2"));

        homePage.clickToPageNumber("4");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isPageActiveByNumber("4"));

        homePage.clickToPageNumber("6");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isPageActiveByNumber("6"));
    }

    //@Test
    public void TC_03_Displayed() {
        // Verify for any row
        Assert.assertTrue(homePage.isRowValueDisplayed("338282", "Argentina", "349238", "687522"));

        /*
        Neu nam o page khac, co 2 cach:
        + click trang + verify
        + search + verify
        */
    }

    //@Test
    public void TC_04_Click_Icon_Button_Checkbox() {
        // Click vao bat ky
        // Tim duoc data unit
        homePage.clickToRowActionByCountryName("Afghanistan", "remove");
        homePage.clickToRowActionByCountryName("AFRICA", "remove");
        homePage.clickToRowActionByCountryName("Albania", "remove");
        homePage.clickToRowActionByCountryName("Arab Rep of Egypt", "remove");
        homePage.clickToRowActionByCountryName("Aruba", "remove");
        homePage.refreshCurrentPage(driver);

        homePage.clickToRowActionByCountryName("Afghanistan", "edit");
        homePage.sleepInSecond(2);
        homePage.refreshCurrentPage(driver);

        homePage.clickToRowActionByCountryName("Albania", "edit");
        homePage.sleepInSecond(2);
        homePage.refreshCurrentPage(driver);
    }

    //@Test
    public void TC_05_Get_All_Row_Value() {
        // B1: Lay ra all pages
        // B2: Duyet qua tung page
        // B3: Lat ra tat ca cac gia tri cua 1 cot trong page do -> Luu vao List/Set/...
        // B4: Duyet het cac page con lai

        //UI
        allValuesUI = homePage.getAllValueByColName("Country");

        //API: Rest Assured/Karate...
        allValuesUI = homePage.getAllValueByColNameInAPI("Country");

        // DB: JTDS/SQL...
        // Data trong DB co the KHONG theo thu tu -> Can SORT truoc
        allValuesDB = homePage.getAllValueByColNameInDB("Country");
        Assert.assertEquals(allValuesUI, allValuesDB);
    }

    @Test
    public void TC_06_Action_By_Index() {
        homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        homePage.enterToTxtByColNameAndRowIndex("Contact Person", "2", "Ohhh");
        homePage.enterToTxtByColNameAndRowIndex("Company", "3", "dsfsdfdsfd");

        // Select Dropdown
        homePage.selectDropdownByColNameAndRowIndex("Country","2", "Japan");

        // Click checkbox
        homePage.selectCheckboxByColNameAndRowIndex("NPO?", "2");
    }

    @AfterClass
    public void afterClass() {
        ///driver.quit();
    }
}
