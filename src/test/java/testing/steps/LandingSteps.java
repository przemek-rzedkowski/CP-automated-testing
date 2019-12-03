package testing.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class LandingSteps extends CommonSteps {

    @Before
    public void setUpBeforeTestMethod() throws IOException {
        super.setUpBeforeTestMethod();
    }

    @After
    public void tearDownAfterTestMethod() throws Exception {
        super.tearDownAfterTestMethod();
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
