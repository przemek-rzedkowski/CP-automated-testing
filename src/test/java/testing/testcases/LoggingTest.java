package testing.testcases;

import org.testng.annotations.Test;
import testing.base.BaseTest;
import testing.pages.DashboardPage;

import static org.testng.Assert.assertTrue;

public class LoggingTest extends BaseTest {


    public void logInUsingCorrectCredentials() {
        DashboardPage dashboardPage = loginPage.login(authenticator.getSuperUser());
        assertTrue(dashboardPage.isLoaded());
    }


    public void tryToLogInUsingIncorrectCredentialsAndFail() {
        loginPage.tryToLogInWithIncorrectCredentials();
        assertTrue(loginPage.isLoaded());
    }

}
