package pageObjects.user.factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPageObject extends BasePageFactory {
    WebDriver driver;

    @FindBy(id = "FirstName")
    private WebElement firstNameTxt;

    @FindBy(id = "LastName")
    private WebElement lastNameTxt;

    @FindBy(id = "Email")
    private WebElement emailTxt;


    public CustomerPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getFirstNameTxtAttributeValue() {
        waitForElementVisible(driver, firstNameTxt);
        return getElementAttribute(firstNameTxt, "value");
    }

    public String getLastNameTxtAttributeValue() {
        waitForElementVisible(driver, lastNameTxt);
        return getElementAttribute(lastNameTxt, "value");
    }

    public String getEmailTxtAttributeValue() {
        waitForElementVisible(driver, emailTxt);
        return getElementAttribute(emailTxt, "value");
    }
}
