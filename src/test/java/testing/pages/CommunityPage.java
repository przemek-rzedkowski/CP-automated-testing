package testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.base.BasePage;

public class CommunityPage extends BasePage {

    public CommunityPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoaded() {
        waitHelper.waitForElementToAppear(communityPageChecker);
        return communityPageChecker.isDisplayed();
    }

    @FindBy(xpath = "//h2[contains(text(),'The sonnenCommunity is balancing the grid')]")
    private WebElement communityPageChecker;
}
