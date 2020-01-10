package testing.steps;

import io.cucumber.java.hu.De;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import testing.helpers.AuthenticationHelper;
import testing.modals.UserMenu;
import testing.pages.*;

import java.io.IOException;
import java.net.URL;

import static testing.helpers.BrowserHelper.getDriver;
import static testing.helpers.BrowserHelper.setupDriver;
import static testing.helpers.PropertiesHelper.loadConfigurationProperties;
import static testing.helpers.PropertiesHelper.properties;

public class CommonSteps {

    private static WebDriver driver;

    LoginPage loginPage;
    DashboardPage dashboardPage;
    UserMenu userMenu;
    LandingPage landingPage;
    Registration1Page registration1Page;
    Registration2Page registration2Page;
    OnboardingConfirmationPage onboardingConfirmationPage;
    DemoModePage demoModePage;
    AnalysisPage analysisPage;
    BatteriePage batteriePage;
    CommunityPage communityPage;
    FlatPage flatPage;
    LiveStatePage liveStatePage;

    static AuthenticationHelper authenticator;

    protected void setUpBeforeTestMethod() throws IOException {
        //System.out.println("odpalam drivera");
        loadConfigurationProperties();
        if (properties.getProperty("config.browser.env").equals("local")) {
            setupDriver();
            driver = getDriver();
        } else {
            String host = "http://localhost:4444/wd/hub";
            ChromeOptions dc = new ChromeOptions();
            driver = new RemoteWebDriver(new URL(host), dc);
        }
        driver.manage().deleteAllCookies();
        authenticator = new AuthenticationHelper();
        driver.manage().window().maximize();

        landingPage = new LandingPage(driver);
        demoModePage = new DemoModePage(driver);
        loginPage = new LoginPage(driver);
        registration1Page = new Registration1Page(driver);
    }

    protected void tearDownAfterTestMethod() throws Exception {
        //System.out.println("close");
        if (driver != null) {
            driver.quit();
        }
        Thread.sleep(500);
    }

    public void getLandingPage() {
        driver.get(properties.getProperty("app.base.url"));
        landingPage = new LandingPage(driver);
    }

    /*public void getDemoModePage() {
        demoModePage = new DemoModePage(driver);
    }*/
}


