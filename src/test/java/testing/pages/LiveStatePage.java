package testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import testing.base.BasePage;

import java.util.Arrays;
import java.util.List;

public class LiveStatePage extends BasePage {

    public LiveStatePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoaded() {
        waitHelper.waitForElementToAppear(energyFlowHeader);
        return energyFlowHeader.isDisplayed();
    }

    @FindBy(xpath = "//h2[contains(text(), \"Live energy flow\")]")
    private WebElement energyFlowHeader;

    @FindBy(xpath = "//button[contains(text(), 'Close')]")
    private WebElement tutorialClosingButton;

    public void shutDownTutorial() {
        element.click(tutorialClosingButton);
    }

    public boolean userCannotSeeTutorial() {
        return !element.isDisplayed(tutorialClosingButton);
    }
}
