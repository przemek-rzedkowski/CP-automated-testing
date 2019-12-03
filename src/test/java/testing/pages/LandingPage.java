package testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.base.BasePage;


public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isLoaded() {
        return false;
    }

    @FindBy(xpath = "//span[contains(text(),'No, I´m a user already')]")
    private WebElement proceedToLoginButton;

    @FindBy(xpath = "//span[contains(text(),'Yes, it´s first time')]")
    private WebElement proceedToRegistrationButton;

    @FindBy(xpath = "//span[contains(.,'Demo')]")
    private WebElement demoButton;

    public LoginPage proceedToLoginPage() {
        element.click(proceedToLoginButton);
        return new LoginPage(driver);
    }

    public Registration1Page proceedToRegistrationPage() {
        element.click(proceedToRegistrationButton);
        return new Registration1Page(driver);
    }

    public void proceedToDemoMode() {
        element.click(demoButton);
    }
}
