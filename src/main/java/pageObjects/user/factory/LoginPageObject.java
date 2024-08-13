package pageObjects.user.factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePageFactory {
    WebDriver driver;

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(id = "Password")
    private WebElement passwordTxt;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginBtn;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void enterToEmailTxt(String emailAddress) {
        waitForElementVisible(driver, emailTxt);
        sendKeyToElement(emailTxt, emailAddress);
    }

    public void enterToPasswordTxt(String password) {
        waitForElementVisible(driver, passwordTxt);
        sendKeyToElement(passwordTxt, password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, loginBtn);
        clickToElement(loginBtn);
    }
}
