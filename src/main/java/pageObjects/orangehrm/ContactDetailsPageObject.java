package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

public class ContactDetailsPageObject extends BaseActions {
    private WebDriver driver;

    public ContactDetailsPageObject(WebDriver driver) {
        super(driver); // Goi qua constructor cua class cha BaseActions
        this.driver = driver;
    }
}