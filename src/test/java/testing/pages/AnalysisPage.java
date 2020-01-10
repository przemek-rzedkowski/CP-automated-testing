package testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.base.BasePage;

public class AnalysisPage extends BasePage {

    public AnalysisPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoaded() {
        waitHelper.waitForElementToAppear(dayChartHeader);
        return dayChartHeader.isDisplayed();
    }

    @FindBy(xpath = "//div[contains(text(), \"Your day chart\")]")
    private WebElement dayChartHeader;
}
