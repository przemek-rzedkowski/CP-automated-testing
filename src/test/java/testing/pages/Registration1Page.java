package testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.base.BasePage;

public class Registration1Page extends BasePage {


    public Registration1Page(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoaded() {
        waitHelper.waitForElementToAppear(nameField);
        return element.isDisplayed(nameField);
    }

    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement nameField;

    @FindBy(xpath = "//div[./input[@name = \'first_name\']]//p")
    private WebElement nameError;

    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//div[./input[@name = 'last_name']]//p")
    private WebElement lastNameError;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement mailField;

    @FindBy(xpath = "//div[./input[@name = 'email']]//p")
    private WebElement mailInvalidError;

    @FindBy(xpath = "//div[.//span[contains(.,'terms')]]/preceding-sibling::span")
    private WebElement tncBox;

    @FindBy(xpath = "//div[./input[@name = \"terms_accepted\"]]")
    private WebElement tncBoxError;

    @FindBy(xpath = "//div[.//span[contains(.,'policy')]]/preceding-sibling::span")
    private WebElement ppBox;

    @FindBy(xpath = "//div[./input[@name = \"privacy_accepted\"]]")
    private  WebElement ppBoxError;

    @FindBy(xpath = "//span[contains(.,'Next')]")
    private WebElement submitButton;

    public Registration2Page registerUsingCorrectCredentials() {
        element.type(nameField, "Marcin");
        element.type(lastNameField, "Szewc");
        element.type(mailField, "somemail@gmail.com");
        element.click(tncBox);
        element.click(ppBox);
        element.click(submitButton);

        return new Registration2Page(driver);
    }

    public void leaveFieldsEmpty() {
        element.click(nameField);
        element.click(lastNameField);
        element.click(mailField);
        element.click(submitButton);
    }

    public boolean isSubmitAvailable() {
        return element.isEnabled(submitButton);
    }

    public boolean areThereThreeErrors() {
        if (element.isDisplayed(nameError)
                && element.isDisplayed(lastNameError)
                && element.isDisplayed(mailInvalidError)) {
            return true;
        }

        return false;
    }

    public void leaveNameBlank() {
        element.click(nameField);
        element.type(lastNameField, "Maciak");
        element.type(mailField, "somemail@gmail.com");
        element.click(tncBox);
        element.click(ppBox);
    }

    public void leaveLastNameBlank() {
        element.type(nameField, "Marcin");
        element.clear(lastNameField);
        element.click(lastNameField);
        element.type(mailField, "somemail@gmail.com");
        //element.click(tncBox);
        //element.click(ppBox);
    }

    public void leaveMailBlank() {
        element.type(nameField, "Marcin");
        element.type(lastNameField, "Maciak");
        element.clear(mailField);
        element.click(mailField);
        //element.click(tncBox);
        //element.click(ppBox);
    }

    public void typeIncorrectEmailAddress() {
        element.type(nameField, "Marcin");
        element.type(lastNameField, "Maciak");
        element.type(mailField, "!@#$%^&*");
        //element.click(tncBox);
        //element.click(ppBox);
    }

    public void typeEmailAlreadyTaken() {
        element.type(nameField, "Marcin");
        element.type(lastNameField, "Maciak");
        element.type(mailField, "portal.sonnen@gmail.com");
        element.click(tncBox);
        element.click(ppBox);
    }

    public void doNotTickTNC() {
        element.type(nameField, "Marcin");
        element.type(lastNameField, "Maciak");
        element.type(mailField, "somemaik@gmail.com");
        element.click(tncBox);
        //element.click(ppBox);
    }

    public void doNotTickPP() {
        element.type(nameField, "Marcin");
        element.type(lastNameField, "Maciak");
        element.type(mailField, "somemaik@gmail.com");
        //element.click(tncBox);
        element.click(ppBox);
    }

    public boolean isNameErrorDisplaying() {

        if (element.isDisplayed(nameError)) {
            return true;
        }
        return false;
    }

    public boolean isLastNameErrorDisplaying() {

        if (element.isDisplayed(lastNameError)) {
            return true;
        }
        return false;
    }

    public boolean isEmailErrorDisplaying() {

        if (element.isDisplayed(mailInvalidError)) {
            return true;
        }
        return false;
    }

    public boolean isTnCCheckboxRed() {
        if (element.hasClass(tncBoxError, "sw-form-checkbox--error")) {
            return true;
        }
        return false;
    }

    public boolean isPPCheckboxRed() {
        if (element.hasClass(ppBoxError, "sw-form-checkbox--error")) {
            return true;
        }
        return false;
    }

    public OnboardingConfirmationPage userSubmitsForm() {
        element.click(submitButton);
        return new OnboardingConfirmationPage(driver);
    }

}
