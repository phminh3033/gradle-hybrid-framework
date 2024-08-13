package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePageFactory {

    protected void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    protected String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    protected String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    protected String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    protected void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    protected void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    protected void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    protected void acceptAlert(WebDriver driver) {
        //driver.switchTo().alert().accept();
        waitForAlterPresent(driver).accept();
    }

    protected void cancelAlert(WebDriver driver) {
        //driver.switchTo().alert().dismiss();
        waitForAlterPresent(driver).dismiss();
    }

    protected String getTextOfAlert(WebDriver driver) {
        //return driver.switchTo().alert().getText();
        return waitForAlterPresent(driver).getText();
    }

    protected void sendKeyToAlert(WebDriver driver, String value) {
        //driver.switchTo().alert().sendKeys(value);
        waitForAlterPresent(driver).sendKeys(value);
    }

    /*------------------------------------------Window / Tab----------------------------------------------*/

    protected void sleepInSecond(long timeSleeping) {
        try {
            Thread.sleep(timeSleeping * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Doi voi chi mo 2 tab/window
    protected void switchToWindowByID(WebDriver driver, String expectedID) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            if (!id.equals(expectedID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    //Mo bao nhieu cung dc
    protected void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
        // Get all id cac tab hien tai dang mo
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            // Cho switch vao tung ID
            driver.switchTo().window(id);

            // Lay title tab hien tai
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)) {
                break;
            }
        }
    }

    protected void closeAllWithoutParentID(WebDriver driver, String parentID) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    protected Set<Cookie> getBrowserCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    protected void setCookies(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    protected void deleteAllCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    /*------------------------------------------Web Element----------------------------------------------*/

    protected void clickToElement(WebElement element) {
        element.click();
    }

    protected void sendKeyToElement(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    protected String getElementText(WebElement element) {
        return element.getText();
    }

    protected String getElementAttribute(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }


    /*------------------------------------------Wait----------------------------------------------*/

    protected Alert waitForAlterPresent(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
    }

    protected void waitForElementVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
    }
}
