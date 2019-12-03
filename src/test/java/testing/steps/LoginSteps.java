package testing.steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testing.modals.UserMenu;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginSteps extends CommonSteps {

    @Before
    public void setUpBeforeTestMethod() throws IOException {
        super.setUpBeforeTestMethod();
    }

    @After
    public void tearDownAfterTestMethod() throws Exception {
        super.tearDownAfterTestMethod();
    }


    @When("^Customer is on Login Page$")
    public void userIsOnLoginPage() {
        assertTrue(loginPage.isLoaded());
    }

    @And("^Customer uses Correct Credentials to log in$")
    public void userUsesCorrectCredentials() {
        dashboardPage = loginPage.login(authenticator.getSuperUser());
    }

    @Then("^Customer is able to log in$")
    public void userIsAbleToLogIn() {
        assertTrue(dashboardPage.isLoaded());
    }

    @And("^Customer uses Incorrect Credentials to log in$")
    public void userUsesIncorrectCredentials() {
        loginPage.tryToLogInWithIncorrectCredentials();
    }

    @Then("^Customer is unable to log in$")
    public void userIsUnableToLogIn() {
        assertTrue(loginPage.isLoaded());
    }

    @And("^Customer enters any password$")
    public void userEntersAnyPassword() {
        loginPage.enterPassword();
    }

    @And("^Customer enables display password feature$")
    public void userEnablesPasswordDisplaying() {
        loginPage.showPassword();
    }

    @Then("^Customer can see the password$")
    public void userCanSeePassword() {
        assertTrue(loginPage.isPasswordVisible());
    }

    @Given("^Customer is on Dashboard page$")
    public void userIsOnDashboard() {
        super.getLandingPage();
        landingPage.proceedToLoginPage();
        dashboardPage = loginPage.login(authenticator.getSuperUser());
        assertTrue(dashboardPage.isLoaded());
    }

    @When("^Customer goes to User Menu$")
    public void userGoesToUserMenu() {
        userMenu = loginPage.showUserMenu();
    }

    @And("^Customer logs out$")
    public void userLogsOut() {
        userMenu.logOut();
    }
}
