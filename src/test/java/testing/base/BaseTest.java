package testing.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import testing.helpers.AuthenticationHelper;
import testing.pages.LandingPage;
import testing.pages.LoginPage;

import java.io.IOException;

import static testing.helpers.BrowserHelper.getDriver;
import static testing.helpers.BrowserHelper.setupDriver;
import static testing.helpers.PropertiesHelper.loadConfigurationProperties;
import static testing.helpers.PropertiesHelper.properties;

public abstract class BaseTest {

    protected WebDriver driver;

    protected LoginPage loginPage;

    protected LandingPage landingPage;

    protected static AuthenticationHelper authenticator;

    @BeforeMethod
    public void setUpBeforeTestMethod() throws IOException {
        loadConfigurationProperties();
        setupDriver();
        driver = getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("app.base.url"));
        authenticator = new AuthenticationHelper();
        //loginPage = new LoginPage(driver);
        //landingPage = new LandingPage(driver);
    }

    @AfterMethod
    public void tearDownAfterTestMethod() throws Exception {
        if (driver != null) {
            driver.quit();
        }
        Thread.sleep(500);
    }
}
