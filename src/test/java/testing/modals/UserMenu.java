package testing.modals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.base.BasePage;
import testing.pages.LoginPage;

public class UserMenu extends BasePage {

    public UserMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isLoaded() {
        return logoutButton.isDisplayed();
    }

    @FindBy(xpath = "//span[contains(text(),'Log out')]")
    private WebElement logoutButton;

    public LoginPage logOut() {
        element.click(logoutButton);
        return new LoginPage(driver);
    }
}
