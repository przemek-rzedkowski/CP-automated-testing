package testing.steps;

import org.openqa.selenium.WebDriver;
import testing.helpers.AuthenticationHelper;
import testing.modals.UserMenu;
import testing.pages.*;

import java.io.IOException;

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

    static AuthenticationHelper authenticator;

    protected void setUpBeforeTestMethod() throws IOException {
        loadConfigurationProperties();
        setupDriver();
        driver = getDriver();
        driver.manage().deleteAllCookies();
        authenticator = new AuthenticationHelper();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        registration1Page = new Registration1Page(driver);
    }

    protected void tearDownAfterTestMethod() throws Exception {
        if (driver != null) {
            driver.quit();
        }
        Thread.sleep(500);
    }

    public void getLandingPage() {
        driver.get(properties.getProperty("app.base.url"));
        landingPage = new LandingPage(driver);
    }


}


