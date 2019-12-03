package testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.base.BasePage;

public class OnboardingConfirmationPage extends BasePage {

    public OnboardingConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoaded() {
        waitHelper.waitForElementToAppear(onboardingConfirmationHeader);
        return onboardingConfirmationHeader.isDisplayed();
    }

    @FindBy(xpath = "//h2[contains(., \"You already have an account\")]")
    private WebElement onboardingConfirmationHeader;

}
