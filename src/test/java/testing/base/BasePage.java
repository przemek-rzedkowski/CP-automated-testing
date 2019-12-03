package testing.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import testing.helpers.WaitHelper;
import testing.helpers.WebElementHelper;

import static testing.helpers.WaitHelper.DEFAULT_TIMEOUT_SECONDS;

public abstract class BasePage {

    protected abstract boolean isLoaded();

    protected WebDriver driver;

    protected WaitHelper waitHelper;

    protected Actions actions;

    protected WebElementHelper element;

    protected WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        waitHelper = new WaitHelper(driver);
        actions = new Actions(driver);
        element = new WebElementHelper(driver, waitHelper);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, DEFAULT_TIMEOUT_SECONDS);
        //wait.until(d -> this.isLoaded());
        }

    protected void refreshPage() {
        driver.navigate().refresh();
    }

    protected boolean isElementDisplayed(By locator) {
        return !driver.findElements(locator).isEmpty();
    }
}
