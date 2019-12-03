package testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.base.BasePage;
import testing.helpers.WebElementHelper;
import testing.modals.UserMenu;
import testing.models.User;

public class LoginPage extends BasePage {

    private static final String ANY_PASSWORD = "!@#$%^&*";

    protected WebElementHelper element;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.element = new WebElementHelper(driver, waitHelper);
    }

    @Override
    public boolean isLoaded() {
        waitHelper.waitForElementToAppear(loginField);
        return loginField.isDisplayed();
    }

    @FindBy(xpath = "//span[contains(text(),'No, I´m a user already')]")
    private WebElement proceedToLoginButton;

    @FindBy(xpath = "//input[@id = 'user_email']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id = 'user_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='commit']")
    private WebElement loginSubmitButton;

    @FindBy(xpath = "//span[@class = 'eye hidden']")
    private WebElement showPasswordButtonHidden;

    @FindBy(xpath = "//span[@class = 'eye visible']")
    private WebElement showPasswordButtonVisible;

    @FindBy(xpath = "(//div[@class = 'c-icon-badge'][.//p[@class = 'c-icon-badge__label']])[2]")
    private WebElement showUserMenuButton;


    public DashboardPage login(User user) {
        element.type(loginField, user.getUsername());
        element.type(passwordField, user.getPassword());
        element.click(loginSubmitButton);

        return new DashboardPage(driver);
    }

    public void tryToLogInWithIncorrectCredentials() {
        element.type(loginField, "!@#$%^&*");
        element.type(passwordField, "!@#$%^&*");
        element.click(loginSubmitButton);

    }

    public void enterPassword() {
        element.type(passwordField, ANY_PASSWORD);
    }

    public void showPassword() {
        element.click(showPasswordButtonHidden);
    }

    public boolean isPasswordVisible() {
        return passwordField.getAttribute("value").equals(ANY_PASSWORD);
    }

    public UserMenu showUserMenu() {
        element.click(showUserMenuButton);
        return new UserMenu(driver);
    }
}
