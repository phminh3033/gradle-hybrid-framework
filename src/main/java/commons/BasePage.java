package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    private long longTimeout = GlobalConstants.LONG_TIMEOUT;
    private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;

    // Ham KHOI TAO chinh no
    // static: KHONG can phai khoi tao doi tuong o CLASS ma van truy cap vao ham duoc
    // Truy cap truc tiep tu pham vi CLASS
    // Apply for Level_02_BasePage_2_Static
    public static BasePage getBasePage() {
        return new BasePage();
    }

    /*------------------------------------------Web Browser----------------------------------------------*/

    public void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void acceptAlert(WebDriver driver) {
        //driver.switchTo().alert().accept();
        waitForAlterPresent(driver).accept();
    }

    public void cancelAlert(WebDriver driver) {
        //driver.switchTo().alert().dismiss();
        waitForAlterPresent(driver).dismiss();
    }

    public String getTextOfAlert(WebDriver driver) {
        //return driver.switchTo().alert().getText();
        return waitForAlterPresent(driver).getText();
    }

    public void sendKeyToAlert(WebDriver driver, String value) {
        //driver.switchTo().alert().sendKeys(value);
        waitForAlterPresent(driver).sendKeys(value);
    }

    /* Window / Tab */

    public void sleepInSecond(long timeSleeping) {
        try {
            Thread.sleep(timeSleeping * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Doi voi chi mo 2 tab/window
    public void switchToWindowByID(WebDriver driver, String expectedID) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            if (!id.equals(expectedID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    //Mo bao nhieu cung dc
    public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
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

    public void closeAllWithoutParentID(WebDriver driver, String parentID) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public Set<Cookie> getBrowserCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public void setCookies(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    public void deleteAllCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }


    /*------------------------------------------Web Element----------------------------------------------*/

    public By getByLocator(String locatorValue) {
        By by;
        if (locatorValue.startsWith("xpath=") || locatorValue.startsWith("XPath=") || locatorValue.startsWith("XPATH=") || locatorValue.startsWith("Xpath=")) {
            by = By.xpath(locatorValue.substring(6));
        } else if (locatorValue.startsWith("css=") || locatorValue.startsWith("Css=") || locatorValue.startsWith("CSS=")) {
            by = By.cssSelector(locatorValue.substring(4));
        } else if (locatorValue.startsWith("id=") || locatorValue.startsWith("Id=") || locatorValue.startsWith("ID=")) {
            by = By.id(locatorValue.substring(3));
        } else if (locatorValue.startsWith("name=") || locatorValue.startsWith("Name=") || locatorValue.startsWith("NAME=")) {
            by = By.name(locatorValue.substring(5));
        } else if (locatorValue.startsWith("class=") || locatorValue.startsWith("Class=") || locatorValue.startsWith("CLASS=")) {
            by = By.className(locatorValue.substring(6));
        } else if (locatorValue.startsWith("tagname=") || locatorValue.startsWith("Tagname=") || locatorValue.startsWith("TAGNAME=")) {
            by = By.tagName(locatorValue.substring(8));
        } else {
            throw new RuntimeException("Locator type is not valid");
        }
        //System.out.println(by);
        return by;
    }

    public String getDynamicLocator(String locator, String... restParams) {
        return String.format(locator, (Object[]) restParams);
    }

    public By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public List<WebElement> getListWebElements(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListWebElements(WebDriver driver, String locator, String... restParams) {
        return driver.findElements(getByLocator(getDynamicLocator(locator, restParams)));
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, WebElement element) {
        element.click();
    }

    public void clickToElement(WebDriver driver, String locator, String... restParams) {
        getElement(driver, getDynamicLocator(locator, restParams)).click();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String value) {
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(value);
    }

    public void sendKeyToElement(WebDriver driver, String locator, String valueToSend, String... restParams) {
        getElement(driver, getDynamicLocator(locator, restParams)).clear();
        getElement(driver, getDynamicLocator(locator, restParams)).sendKeys(valueToSend);
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue) {
        new Select(getElement(driver, locator)).selectByVisibleText(itemValue);
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue, String... restParams) {
        new Select(getElement(driver, getDynamicLocator(locator, restParams))).selectByVisibleText(itemValue);
    }

    public String getFirstSelectedTextInDefaultDropdown(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public boolean isDefaultDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }

    public void selectItemInDropdown(WebDriver driver, String parentLocator, String childItemLocator, String itemTextExpected) {
        getElement(driver, parentLocator).click();
        sleepInSecond(1);
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

        for (WebElement item : allItems) {
            String textOfItem = item.getText();

            if (textOfItem.equals(itemTextExpected)) {
                System.out.println("Text item selected = " + textOfItem);
                item.click();
                break;
            }
        }
    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getElementText(WebDriver driver, String locator, String... restParams) {
        return getElement(driver, getDynamicLocator(locator, restParams)).getText();
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
        return getElement(driver, locator).getAttribute(attributeName);
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName, String... restParams) {
        return getElement(driver, getDynamicLocator(locator, restParams)).getAttribute(attributeName);
    }

    public String getElementCssValue(WebDriver driver, String locator, String cssPropertyName) {
        return getElement(driver, locator).getCssValue(cssPropertyName);
    }

    public String convertRGBAToHexaColor(WebDriver driver, String locator) {
        String backgroundColorRGBA = getElementCssValue(driver, locator, "background-color");
        return Color.fromString(backgroundColorRGBA).asHex();
    }

    public int getListElementSize(WebDriver driver, String locator) {
        return getListWebElements(driver, locator).size();
    }

    public int getListElementSize(WebDriver driver, String locator, String... restParams) {
        return getListWebElements(driver, getDynamicLocator(locator, restParams)).size();
    }

    /**
     * Apply for both checkbox and radio button
     *
     * @param driver  The WebDriver instance used to interact with the web page.
     * @param locator The XPath locator of the element to be checked and clicked.
     */
    public void checkToElement(WebDriver driver, String locator) {
        if (!getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    public void checkToElement(WebDriver driver, String locator, String... restParams) {
        if (!getElement(driver, getDynamicLocator(locator, restParams)).isSelected()) {
            getElement(driver, getDynamicLocator(locator, restParams)).click();
        }
    }

    /**
     * Only apply for checkbox
     *
     * @param driver  The WebDriver instance used to interact with the web page.
     * @param locator The XPath locator of the element to be checked and clicked.
     */
    public void uncheckToElement(WebDriver driver, String locator) {
        if (getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    /**
     * Case 1: Element co hien thi tren UI va CO trong HTML -> isDisplayed tra ve true
     * Case 2: Element KHONG hien thi tren UI va CO trong HTML -> isDisplayed tra ve false
     */
    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String... restParams) {
        return getElement(driver, getDynamicLocator(locator, restParams)).isDisplayed();
    }

    public void setImplicitWait(WebDriver driver, long timeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    public boolean isElementUnDisplayed(WebDriver driver, String locator) {
        setImplicitWait(driver, shortTimeout); // Truoc khi tim element set ngan
        List<WebElement> elements = getListWebElements(driver, locator);
        setImplicitWait(driver, longTimeout); // Tra lai timeout cho cac step con lai

        if (elements.size() > 0 && elements.get(0).isDisplayed()) {
            // Case 1: Element co hien thi tren UI va CO trong HTML -> isDisplayed tra ve true
            System.out.println("Case 1: Element co hien thi tren UI va CO trong HTML -> isDisplayed tra ve true");
            return false;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            // Case 2: Element KHONG hien thi tren UI va CO trong HTML -> isDisplayed tra ve false
            System.out.println("Case 2: Element KHONG hien thi tren UI va CO trong HTML -> isDisplayed tra ve false");
            return true;
        } else {
            // Case 3: Element KHONG hien thi tren UI va KHONG trong HTML -> isDisplayed tra ve true
            System.out.println("Case 3: Element KHONG hien thi tren UI va KHONG trong HTML -> isDisplayed tra ve true");
            return true;
        }
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public boolean isElementSelected(WebDriver driver, String locator, String... restParams) {
        return getElement(driver, getDynamicLocator(locator, restParams)).isSelected();
    }

    public boolean isElementEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    /*----------------------------------------------------------------------------------------*/
    /* Frame | iFrame */
    public void switchToIframe(WebDriver driver, String locator) {
        //driver.switchTo().frame(getElement(driver, locator));
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByLocator(locator)));
    }

    public void backToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    /*----------------------------------------------------------------------------------------*/
    /* User Actions */
    public void hoverToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getElement(driver, locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }

    public void dragAndDropToElement(WebDriver driver, String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
    }

    public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
        new Actions(driver).sendKeys(getElement(driver, locator), key);
    }

    /* jsExecutor */
    public Object executeForBrowser(WebDriver driver, String javaScript) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(WebDriver driver, String textExpected) {
        String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
        ((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void hightlightElement(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInSecond(3);
    }

    public void clickToElementByJS(WebDriver driver, String locator, String... restParams) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, getDynamicLocator(locator, restParams)));
        sleepInSecond(3);
    }

    public void scrollToElementOnTop(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnDown(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public String getAttributeInDOM(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(driver, locator));
    }

    /*------------------------------------------Wait----------------------------------------------*/

    public Alert waitForAlterPresent(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.alertIsPresent());
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... restParams) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParams))));
    }

    public void waitForListElementsVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfAllElements(getListWebElements(driver, locator)));
    }

    public boolean waitForElementInvisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public boolean waitForListElementsInvisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... restParams) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locator, restParams))));
    }

    public boolean isPageLoadedSuccess(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public void upLoadMultipleFiles(WebDriver driver, String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";
        for (String file : fileNames) {
            fullFileName = fullFileName + filePath + file + "\n";
        }
        fullFileName = fullFileName.trim();

        // KHONG dung sendKeyToElement() vi co clear() -> Se ERROR khi su dung
        getElement(driver, BaseElementUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
    }

}
