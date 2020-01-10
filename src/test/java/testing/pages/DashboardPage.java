package testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.base.BasePage;

public class DashboardPage extends BasePage {

    protected DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoaded() {
        waitHelper.waitForElementToAppear(PVSystemName);
        //waitHelper.waitForPageLoaded(driver);
        return PVSystemName.isDisplayed();
    }

    @FindBy(xpath = "//p[@class='c-icon-badge__label'][contains(text(),'Max Mustermann')]")
    private WebElement mainPageChecker;

    @FindBy(xpath = "//h2[contains(text(),'PV System')]")
    private WebElement PVSystemName;


}
