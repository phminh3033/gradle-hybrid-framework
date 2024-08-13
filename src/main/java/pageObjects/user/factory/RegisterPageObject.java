package pageObjects.user.factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePageFactory {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='header-logo']//img")
    private WebElement nopcommerceLogo;

    @FindBy(id = "FirstName")
    private WebElement firstNameTxt;

    @FindBy(id = "LastName")
    private WebElement lastNameTxt;

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(id = "Password")
    private WebElement passwordTxt;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(id = "FirstName-error")
    private WebElement firstNameErrorMsg;

    @FindBy(id = "LastName-error")
    private WebElement lastNameErrorMsg;

    @FindBy(id = "Email-error")
    private WebElement emailErrorMsg;

    @FindBy(id = "Password-error")
    private WebElement passErrorMsg;

    @FindBy(id = "ConfirmPassword-error")
    private WebElement confirmPasswordErrorMsg;

    @FindBy(className = "result")
    private WebElement registrationCompletedMsg;

    @FindBy(id = "register-button")
    private WebElement registerBtn;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerBtn);
        clickToElement(registerBtn);
    }

    public String getFirstNameErrorMsgText() {
        waitForElementVisible(driver, firstNameErrorMsg);
        return getElementText(firstNameErrorMsg);
    }

    public String getLastNameErrorMsgText() {
        waitForElementVisible(driver, lastNameErrorMsg);
        return getElementText(lastNameErrorMsg);
    }

    public String getEmailErrorMsgText() {
        waitForElementVisible(driver, emailErrorMsg);
        return getElementText(emailErrorMsg);
    }

    public String getConfirmPasswordErrorMsgText() {
        waitForElementVisible(driver, confirmPasswordErrorMsg);
        return getElementText(confirmPasswordErrorMsg);
    }

    public void clickToNopCommerceLogo() {
        waitForElementClickable(driver, nopcommerceLogo);
        clickToElement(nopcommerceLogo);
    }

    public void enterToFirstNameTxt(String firstName) {
        waitForElementVisible(driver, firstNameTxt);
        sendKeyToElement(firstNameTxt, firstName);
    }

    public void enterToLastNameTxt(String lastName) {
        waitForElementVisible(driver, lastNameTxt);
        sendKeyToElement(lastNameTxt, lastName);
    }

    public void enterToEmailTxt(String email) {
        waitForElementVisible(driver, emailTxt);
        sendKeyToElement(emailTxt, email);
    }

    public void enterToPasswordTxt(String pass) {
        waitForElementVisible(driver, passwordTxt);
        sendKeyToElement(passwordTxt, pass);
    }

    public void enterToConfirmPasswordTxt(String confirmPass) {
        waitForElementVisible(driver, confirmPasswordTxt);
        sendKeyToElement(confirmPasswordTxt, confirmPass);
    }

    public String getRegisterSuccessMsgTxt() {
        waitForElementVisible(driver, registrationCompletedMsg);
        return getElementText(registrationCompletedMsg);
    }
}
