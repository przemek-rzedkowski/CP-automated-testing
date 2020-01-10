package testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.base.BasePage;

public class FlatPage extends BasePage {

    public FlatPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoaded() {
        waitHelper.waitForElementToAppear(contractNumberField);
        return contractNumberField.isDisplayed();
    }

    @FindBy(xpath = "//p[contains(text(),'Contract number')]/following-sibling::div")
    private WebElement contractNumberField;
}
