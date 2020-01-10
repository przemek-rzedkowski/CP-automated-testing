package testing.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import testing.pages.DemoModePage;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LandingSteps extends CommonSteps {

    @Before
    public void setUpBeforeTestMethod() throws IOException {
        //System.out.println("landing");
        super.setUpBeforeTestMethod();
    }

    @After
    public void tearDownAfterTestMethod() throws Exception {
        super.tearDownAfterTestMethod();
    }

    @Given("^Customer is on Landing Page$")
    public void userIsOnLandingPage() {
        super.getLandingPage();
        assertTrue(landingPage.isLoaded());
    }

    @When("^Customer proceed to Demo mode$")
    public void userProceedToDemoMode() {
        super.getLandingPage();
        landingPage.proceedToDemoMode();
        //super.getDemoModePage();
    }

    @Given("^Customer proceed to Register Page$")
    public void userProceedToRegisterPage() {
        super.getLandingPage();
        landingPage.proceedToRegistrationPage();
    }

    @Given("^Customer proceed to Login Page$")
    public void userProceedToLoginPage() {
        super.getLandingPage();
        landingPage.proceedToLoginPage();
    }



}
