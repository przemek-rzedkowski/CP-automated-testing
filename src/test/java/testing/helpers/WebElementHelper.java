package testing.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementHelper {

    private WebDriver driver;

    private WaitHelper wait;

    public WebElementHelper(WebDriver driver, WaitHelper waitHelper) {
        this.driver = driver;
        this.wait = waitHelper;
    }

    public void click(WebElement element) {
        wait.waitForPageLoaded(driver);
        wait.waitForElementToBeClickable(element);
        element.click();
    }

    public void type(WebElement element, String text) {
        wait.waitForPageLoaded(driver);
        wait.waitForElementToBeClickable(element);
        element.clear();
        element.sendKeys(text);
    }

    public boolean isDisplayed(WebElement element) {
        wait.waitForPageLoaded(driver);
        return element.isDisplayed();
    }

    public boolean isEnabled(WebElement element) {
        wait.waitForPageLoaded(driver);
        return element.isEnabled();
    }

    public boolean hasClass(WebElement element, String saidClass) {
        wait.waitForPageLoaded(driver);
        String classes = element.getAttribute("class");
        for (String c : classes.split(" ")) {
            if (c.equals(saidClass)) {
                return true;
            }
        }
        return false;
    }

    public void clear(WebElement element) {
        wait.waitForPageLoaded(driver);
        element.clear();
    }

}
