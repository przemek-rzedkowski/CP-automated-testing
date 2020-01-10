package testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.base.BasePage;

public class DemoModePage extends BasePage {

    public DemoModePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoaded() {
        waitHelper.waitForElementToAppear(demoBanner);
        return demoBanner.isDisplayed();
    }

    @FindBy(xpath = "//span[contains(text(), \"DEMO\")]")
    private WebElement demoBanner;

    @FindBy(xpath = "//a[./span[contains(text(), \"Dashboard\")]]")
    private WebElement dashboardButton;

    @FindBy(xpath = "//a[./span[contains(text(), \"Live State\")]]")
    private WebElement liveStateButton;

    @FindBy(xpath = "//a[./span[contains(text(), \"Analysis\")]]")
    private WebElement analysisButton;

    @FindBy(xpath = "//a[./span[contains(text(), \"sonnenCommunity\")]]")
    private WebElement communityButton;

    @FindBy(xpath = "//a[./span[contains(text(), \"sonnenFlat\")]]")
    private WebElement flatButton;

    @FindBy(xpath = "//a[./span[contains(text(), \"sonnenBatterie\")]]")
    private WebElement batterieButton;

    @FindBy(xpath = "//span[contains(text(),'Leave Demo')]")
    private WebElement leavingButton;

    public DashboardPage proceedToDashboard() {
        element.click(dashboardButton);
        return new DashboardPage(driver);
    }

    public LiveStatePage proceedToLiveState() {
        element.click(liveStateButton);
        return new LiveStatePage(driver);
    }

    public AnalysisPage proceedToAnalysis() {
        element.click(analysisButton);
        return new AnalysisPage(driver);
    }

    public CommunityPage proceedToCommunity() {
        element.click(communityButton);
        return new CommunityPage(driver);
    }

    public FlatPage proceedToFlat() {
        element.click(flatButton);
        return new FlatPage(driver);
    }

    public BatteriePage proceedToBatterie() {
        element.click(batterieButton);
        return new BatteriePage(driver);
    }

    public LoginPage leaveDemo() {
        element.click(leavingButton);
        return new LoginPage(driver);
    }
}

