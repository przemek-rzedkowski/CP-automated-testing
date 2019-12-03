package testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.base.BasePage;

public class Registration2Page extends BasePage {

    @Override
    public boolean isLoaded() {
        waitHelper.waitForElementToAppear(serialNumberField);
        return serialNumberField.isDisplayed();
    }

    public Registration2Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='battery_serial_number']")
    private WebElement serialNumberField;
}
