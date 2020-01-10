package testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.base.BasePage;

public class BatteriePage extends BasePage {

    public BatteriePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoaded() {
        waitHelper.waitForElementToAppear(stateOfCharge);
        return stateOfCharge.isDisplayed();
    }

    @FindBy(xpath = "//div[contains(text(),'State of charge')]/following-sibling::div")
    private WebElement stateOfCharge;
}
